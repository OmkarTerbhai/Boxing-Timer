package com.example.boxingtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActualTimer extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    TextView tv3;
     int i = 1;
    int roundNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_timer);

        Intent intent = getIntent();
        tv = (TextView)findViewById(R.id.roundHolder);
        tv2 = (TextView)findViewById(R.id.restView);
        String rounds = null;
        if(intent.hasExtra("noOfRounds"))
            rounds = intent.getStringExtra("noOfRounds");

        if(intent.hasExtra("counter"))
            i = Integer.parseInt(intent.getStringExtra("counter"));

        tv2.setText("Value of i" + i);
        roundNumber = Integer.parseInt(rounds);

        Log.d("Value of i: ", rounds);



        actualTimer();
    }

    public void actualTimer() {
        CountDownTimer cdt = new CountDownTimer(3 *60 * 1000, 1000) {

            int minutes = 0;
            int seconds = 0;

            public void onTick(long millisUntilFinished) {
                seconds++;
                if (seconds > 59) {
                    minutes++;
                    seconds = 0;
                }
                tv.setText((minutes % 3) + " : " + seconds);
            }


            public void onFinish() {
                tv.setText("That's it! Break!");
                if(i < roundNumber) {
                    i++;
                    restTimer();

                }

            }

        }.start();
    }

    public void restTimer() {
        CountDownTimer cdt = new CountDownTimer(60 * 1000, 1000) {
            int s = 0;
            public void onTick(long millisUntilFinished) {
                s++;
                tv.setText(s + " ");
            }

            public void onFinish() {
                tv.setText("Finsihed this one");
                actualTimer();
            }
        }.start();
    }





}