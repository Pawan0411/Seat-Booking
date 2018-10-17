package com.university.soa.bus.SeatClass;

/**
 * Created by pkumar on 5/7/18.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.test.ServiceTestCase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.university.soa.bus.R;
import com.university.soa.bus.SavedSeats;
import com.university.soa.bus.book;
import com.university.soa.bus.utils.RecyclerViewItemDecorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeatSelection extends AppCompatActivity implements OnSeatSelected {

    private static final int COLUMNS =5;
    static Set<String>positions;
    // private TextView txtSeatSelected;
    Button mBook;
    TextView time;
    SharedPreferences seats;
    SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mBook=findViewById(R.id.button2);
        time=findViewById(R.id.show);
        seats=getSharedPreferences("seats",MODE_PRIVATE);
        positions= new HashSet<>(seats.getStringSet("selected", new HashSet<String>()));
        //  time.setText(R.string.show);
        mBook.setText(R.string.button2);
        //   txtSeatSelected = (TextView)findViewById(R.id.txt_seat_selected);
        List<AbstractItem> items = new ArrayList<>();
        for (int i=0; i<40; i++) {

            if (i%COLUMNS==0 || i%COLUMNS==4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);

        RecyclerView recyclerView = findViewById(R.id.lst_items);
        int spaceInPixels = 0;
        recyclerView.addItemDecoration(new RecyclerViewItemDecorator(spaceInPixels));
        recyclerView.setLayoutManager(manager);

        AirplaneAdapter adapter = new AirplaneAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onSeatSelected(int count) {
        mBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Please Select Seats", Toast.LENGTH_SHORT).show();
            }
        });
        if(count==0) {
            mBook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Toast.makeText(getApplicationContext(), "Please Select Seats", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            mBook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    edit=seats.edit();
                    edit.putStringSet("selected",positions);
                    edit.commit();
                    // Start NewActivity.class
                    Intent myIntent = new Intent(SeatSelection.this,
                            SavedSeats.class);
                    startActivity(myIntent);
                }
            });
        }


    }

}