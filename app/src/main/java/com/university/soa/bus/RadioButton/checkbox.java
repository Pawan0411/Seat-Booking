package com.university.soa.bus.RadioButton;

/**
 * Created by pkumar on 5/6/18.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.university.soa.bus.R;
import com.university.soa.bus.SeatClass.SeatSelection;

public class checkbox extends Activity {
    /** Called when the activity is first created. */
    RadioButton R1,R2,R3,R4;
    Button B1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);
         R1 = findViewById(R.id.Opt1);
        R2 = findViewById(R.id.Opt2);
        R3 = findViewById(R.id.Opt3);
        R4= findViewById(R.id.Opt4);
        B1= findViewById(R.id.OK);
        B1.setText(R.string.OK);
        R1.setText(R.string.Opt1);
        R2.setText(R.string.Opt2);
        R3.setText(R.string.Opt3);
        R4.setText(R.string.Opt4);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R1.isChecked()) {
                    Intent Intents= new Intent(checkbox.this, SeatSelection.class); // <----- START "BEACHES" ACTIVITY
                    startActivity(Intents);
                }
                else if (R2.isChecked()) {
                    Intent Intentm = new Intent(getApplicationContext(), SeatSelection.class); // <----- START "HIll STATIONS" ACTIVITY
                    startActivityForResult(Intentm, 0);
                }
                else if (R3.isChecked()) {
                    Intent Intentw = new Intent(getApplicationContext(), SeatSelection.class); // <----- START "WILDLIFE" ACTIVITY
                    startActivityForResult(Intentw, 0);
                }
                else if (R4.isChecked()) {
                    Intent Intenth = new Intent(getApplicationContext(), SeatSelection.class); // <----- START "HISTORICAL MONUMENTS" ACTIVITY
                    startActivityForResult(Intenth, 0);
                }
            }
        });

    }
    }
