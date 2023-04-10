package com.example.boxingtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
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
        //tv2 = (TextView)findViewById(R.id.restView);
        tv3 = (TextView)findViewById(R.id.actualroundHolder);
        String rounds = null;
        if(intent.hasExtra("noOfRounds"))
            rounds = intent.getStringExtra("noOfRounds");

        if(intent.hasExtra("counter"))
            i = Integer.parseInt(intent.getStringExtra("counter"));

        //tv2.setText("Value of i" + i);
        roundNumber = Integer.parseInt(rounds);

        Log.d("Value of i: ", rounds);



        actualTimer();
    }

    public void actualTimer() {
        CountDownTimer cdt = new CountDownTimer(5 *60 * 1000, 1000) {

//            int minutes = 5;
//            int seconds = 300;

            public void onTick(long millisUntilFinished) {
                millisUntilFinished /= 1000;
                long minutes = millisUntilFinished / 60;
                long seconds = millisUntilFinished % 60;
                tv.setText((minutes) + " : " + seconds);
                tv3.setText("Round : " + i);

            }


            public void onFinish() {
                tv.setText("That's it! Break!");
                try {
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(i < roundNumber) {
                    i++;
                    restTimer();

                }

            }

        }.start();
    }

    public void restTimer() {
        CountDownTimer cdt = new CountDownTimer(60 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                millisUntilFinished  /= 1000;
                tv.setText(millisUntilFinished + " ");
                tv3.setText("Rest");
            }

            public void onFinish() {
                try {
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tv.setText("Finsihed this one");
                actualTimer();
            }
        }.start();
    }





}