package com.example.workouttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    ProgressBar progressBar;
    TextView Show_Duration_Timer,Show_Rest_Timer;
    Button Finish_Time,Start_Again;

    CountDownTimer countDownTimer;
    CountDownTimer Restimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        progressBar=findViewById(R.id.progressBar);
        Show_Duration_Timer=findViewById(R.id.display);
        Show_Rest_Timer=findViewById(R.id.display2);
        Finish_Time=findViewById(R.id.stopTimer);
        Start_Again=findViewById(R.id.Start_again);

        Intent timer_values=getIntent();
        String toast=timer_values.getStringExtra("name");
        String D_value=timer_values.getStringExtra("Duration_Value");
        String R_value=timer_values.getStringExtra("Rest_Value");

        long duration_value=Long.parseLong(D_value)*1000;
        long rest_value=Long.parseLong(R_value)*1000;
        System.out.println("The integer value is: " + duration_value);


        countDownTimer=new CountDownTimer(duration_value,1000) {
            @Override
            public void onTick(long secisUntilFinished) {
                Show_Duration_Timer.setText("Time Left: "+secisUntilFinished/1000);
            }
            @Override
            public void onFinish() {
                Show_Duration_Timer.setText("Time Finished");

            }
        };
        countDownTimer.start();


        Finish_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Restimer=new CountDownTimer(rest_value,1000) {
                    @Override
                    public void onTick(long secisUntilFinished) {
                        Show_Rest_Timer.setText("Remaining: "+secisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        Show_Rest_Timer.setText("Rest Time Finished");
                    }
                };
                Restimer.start();
            }
        });

        Start_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

    }
}