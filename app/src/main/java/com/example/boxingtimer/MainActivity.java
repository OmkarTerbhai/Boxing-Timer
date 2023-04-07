package com.example.boxingtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        ed = (EditText)findViewById(R.id.editTextNumber);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = ed.getText().toString();

        Intent intent = new Intent(getApplicationContext(), ActualTimer.class);

        intent.putExtra("noOfRounds", str);
        startActivity(intent);
    }
}