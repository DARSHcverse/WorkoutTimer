/* ----------------Student Details----------------
Name: Darshan Subramaniam; Id: 222550339
CourseName: SIT305
 */
package com.example.workouttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Get_name;
    Button Start_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Get_name=findViewById(R.id.Name);
        Start_Button=findViewById(R.id.start);

        Start_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Transfer_name=new Intent(MainActivity.this,StartTimer.class);
                Transfer_name.putExtra("name",Get_name.getText().toString());
                startActivity(Transfer_name);
            }
        });
    }
}