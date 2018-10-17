package com.university.soa.bus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.university.soa.bus.RadioButton.checkbox;
import com.university.soa.bus.SeatClass.TourSelection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Models.AppStatus;

/**
 * Created by pkumar on 5/14/18.
 */

public class book extends AppCompatActivity {


    Button B1,B2,B3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);

        B1= findViewById(R.id.button7);
        B2= findViewById(R.id.button9);
        B3= findViewById(R.id.button8);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("EEE, MMM d, ''yy");
        c.add(Calendar.DAY_OF_YEAR,0);
        Date Today = c.getTime();
        String today=df.format(Today.getTime());
        B1.setText(today);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(book.this,TourSelection.class);
                startActivity(intent);
            }
        });
        c.add(Calendar.DAY_OF_YEAR,1);
        Date Tommorrow = c.getTime();
        String tm=df.format(Tommorrow.getTime());
        B3.setText(tm);
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(book.this,TourSelection.class);
                startActivity(intent);
            }
        });
        c.add(Calendar.DAY_OF_YEAR,1);
        Date Dtm = c.getTime();
        String dtm=df.format(Dtm.getTime());
        B2.setText(dtm);
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(book.this,TourSelection.class);
                startActivity(intent);
            }
        });
    }

}