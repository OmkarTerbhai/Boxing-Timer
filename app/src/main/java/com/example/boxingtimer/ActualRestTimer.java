package com.example.boxingtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class ActualRestTimer extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    static  int i;
    static int roundNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        CountDownTimer cdt = new CountDownTimer(60 * 1000, 1000) {
            int s = 0;
            public void onTick(long millisUntilFinished) {
                s++;
                tv.setText(s + " ");
            }

            public void onFinish() {
                tv.setText("Finsihed this one");
                Intent intent = new Intent(getApplicationContext(), ActualTimer.class);
                startActivity(intent);
            }
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_rest_timer);
        tv = (TextView)findViewById(R.id.actualRestTimer);
        tv2 = (TextView)findViewById(R.id.textView3);

        Intent intent = getIntent();
        i = Integer.parseInt(intent.getStringExtra("counter"));
        roundNumber = Integer.parseInt(intent.getStringExtra("rounds"));

        tv2.setText(i + "");

        if(i < roundNumber)
            cdt.start();
        else {
            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent1);
        }

        tv.setText("Reached from ActualTimer");





    }
}