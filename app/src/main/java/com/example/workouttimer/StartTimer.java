package com.example.workouttimer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StartTimer extends AppCompatActivity {

    TextView textView;
    EditText set_duration,set_rest;
    Button START_Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_timer);

        textView=findViewById(R.id.textView3);
        set_duration=findViewById(R.id.Set_Duration);
        set_rest=findViewById(R.id.Set_Rest);
        START_Timer=findViewById(R.id.Run_Timer);

        Intent sentItem=getIntent();
        String SentName=sentItem.getStringExtra("name");
        textView.setText("Welcome "+SentName);


        START_Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToTimer=new Intent(StartTimer.this,Timer.class);
                ToTimer.putExtra("ToastName",SentName);
                ToTimer.putExtra("Duration_Value",set_duration.getText().toString());
                ToTimer.putExtra("Rest_Value",set_rest.getText().toString());
                startActivity(ToTimer);
            }
        });

    }
}