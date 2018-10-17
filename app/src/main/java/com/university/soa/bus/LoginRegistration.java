package com.university.soa.bus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Models.AppStatus;

/**
 * Created by pkumar on 5/13/18.
 */

public class LoginRegistration extends AppCompatActivity implements View.OnClickListener {

    String str_name,str_empcode;
    EditText e1, e2, e3;
    Button b1, b2;
AppStatus appStatus;
    DatabaseReference ref;
    FirebaseDatabase Database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1 = findViewById(R.id.Name);
        e2 = findViewById(R.id.edt_Rpassword);
        b1 = findViewById(R.id.btn_register);
        b2 = findViewById(R.id.existinguser);
        Database = FirebaseDatabase.getInstance();
        ref = Database.getReference().child("Employee Details : ");
        appStatus = new AppStatus(getApplicationContext());
        b1.setOnClickListener(this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegistration.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onClick(View v) {
        if (appStatus.isOnline()){
            str_name=e1.getText().toString().trim();
            str_empcode=e2.getText().toString().trim();
            try{
               if(str_name.length()==0 && str_empcode.length()==0) {
                  Toast.makeText(getApplicationContext(),"Please enter Employee Name and Code..",Toast.LENGTH_LONG).show();
               }
               else if(str_name.length()==0 || str_empcode.length()==0){
                   Toast.makeText(getApplicationContext(),"All fields are Mandatory",Toast.LENGTH_LONG).show();
               }
               else if(!str_name.equals(0)&& !str_name.equals(0)) {
                   SaveData saveData = new SaveData(str_name, str_empcode);
                   ref.push().setValue(saveData);
                   Toast.makeText(getApplicationContext(),"Registered Succesfully..",Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(LoginRegistration.this,MainActivity.class);
                   startActivity(intent);
               }
            }
            catch (Exception e){
              Toast.makeText(getApplicationContext(),"Soory,Error Occured..",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Please see that you have Active internet connection..",Toast.LENGTH_LONG).show();
        }
    }
}