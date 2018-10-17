package com.university.soa.bus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Properties;

import Models.AppStatus;

/**
 * Created by pkumar on 5/7/18.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        String str_empcode,a,b;

        EditText edt_empcode;
        Button login, newuser;
        //boolean b=false;
        Properties prop;
        DatabaseReference ref;
        FirebaseDatabase Database;
        LinearLayout ll;
        TextView t1;
        RelativeLayout Rl;
        //private ProgressBar progressBar;
        AppStatus appStatus;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                t1= findViewById(R.id.seat);
                ll= findViewById(R.id.layout1);
                Rl= findViewById(R.id.home);
                ll.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                Rl.setVisibility(View.INVISIBLE);
                prop=new Properties();
               // auth = FirebaseAuth.getInstance();
                Database = FirebaseDatabase.getInstance();
                ref = Database.getReference().child("Employee Details : ");
                appStatus=new AppStatus(getApplicationContext());
                login = findViewById(R.id.btn_login);
                newuser = findViewById(R.id.newuser);
                edt_empcode = findViewById(R.id.CodeNum);


                newuser.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(MainActivity.this,LoginRegistration.class));
                        }
                });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater=getMenuInflater();
                inflater.inflate(R.menu.logout,menu);
                return true;
        }

        @Override
        public void onClick(View v) {
                if (appStatus.isOnline()) {
                        str_empcode=edt_empcode.getText().toString().trim();
                        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                        try {
                                if (str_empcode.length()==0) {
                                        Toast.makeText(getApplicationContext(),
                                                "Please enter your Employee Code",
                                                Toast.LENGTH_LONG).show();
                                }
                                else if(str_empcode.equals("1234")){
                                        Toast.makeText(this, "Welcome User", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(MainActivity.this,book.class);
                                        startActivity(intent);

                                }
                                else if(str_empcode.equals("0000")){
                                        Toast.makeText(this, "Welcome User", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(MainActivity.this,book.class);
                                        startActivity(intent);

                                }
                                else if(str_empcode.equals("1111")){
                                        Toast.makeText(this, "Welcome User", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(MainActivity.this,book.class);
                                        startActivity(intent);

                                }
                        }catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "We did not find any account with the given Employee Code in this device", Toast.LENGTH_LONG).show();
                        }
                } else {
                        Toast.makeText(getApplicationContext(),"Please see that you have Active internet connection..",Toast.LENGTH_LONG).show();
                }
        }

        }


