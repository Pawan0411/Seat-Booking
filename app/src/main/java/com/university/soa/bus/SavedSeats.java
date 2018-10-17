package com.university.soa.bus;

/*import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import Models.AppStatus;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by pkumar on 5/15/18.
 

public class SavedSeats extends AppCompatActivity {
    AppStatus appStatus;
    DatabaseReference ref;
    FirebaseDatabase Database;
    Button Saveinfo,button;
    TextView T1,T2;
    String str_name,str_empcode,str_psnum,str_phnmber,number;
    EditText Pname,Pnumber,Empcode,passnumber,editText2,E2,E3,E4;
    private static final String TAG = "PhoneLogin";
    private boolean mVerificationInProgress = false;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_info);
        Database = FirebaseDatabase.getInstance();
        ref = Database.getReference().child("Booked Details : ");
        appStatus = new AppStatus(getApplicationContext());
        Saveinfo=(Button)findViewById(R.id.saveinfo);
        button=(Button)findViewById(R.id.button);
        Pname =(EditText)findViewById(R.id.PName);
        Pnumber=(EditText)findViewById(R.id.PhnNumber);
        Empcode=(EditText)findViewById(R.id.EmpCode);
        passnumber=(EditText)findViewById(R.id.PsNum);
        editText2=(EditText)findViewById(R.id.editText2);
        /*E2=(EditText)findViewById(R.id.editText2);
        E3=(EditText)findViewById(R.id.editText5);
        E4=(EditText)findViewById(R.id.editText11);
        T1=(TextView)findViewById(R.id.Opt);
        T2=(TextView)findViewById(R.id.Details);

        mAuth = FirebaseAuth.getInstance();
        str_empcode=Empcode.getText().toString();

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                // Log.d(TAG, "onVerificationCompleted:" + credential);
                mVerificationInProgress = true;
                Toast.makeText(SavedSeats.this, "Verification Complete", Toast.LENGTH_SHORT).show();
                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                // Log.w(TAG, "onVerificationFailed", e);
                Toast.makeText(SavedSeats.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    Toast.makeText(SavedSeats.this, "InValid Phone Number", Toast.LENGTH_SHORT).show();
                    // ...
                } else if (e instanceof FirebaseTooManyRequestsException) {
                }

            }

            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // Log.d(TAG, "onCodeSent:" + verificationId);
                Toast.makeText(SavedSeats.this, "Verification code has been send on your number", Toast.LENGTH_LONG).show();
                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
                // ...
            }
        };

        Saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appStatus.isOnline()) {
                    str_name = Pname.getText().toString().trim();
                    str_phnmber = Pnumber.getText().toString().trim();
                    str_empcode = Empcode.getText().toString().trim();
                    str_psnum = passnumber.getText().toString().trim();

                    try {
                        if (str_name.length() == 0 && str_empcode.length() == 0 &&
                                str_phnmber.length() == 0 && str_psnum.length() == 0) {
                            Toast.makeText(getApplicationContext(), "Please fill the Details..", Toast.LENGTH_LONG).show();
                        } else if (str_name.length() == 0 || str_empcode.length() == 0 ||
                                str_empcode.length() == 0 || str_empcode.length() == 0) {
                            Toast.makeText(getApplicationContext(), "All fields are Mandatory", Toast.LENGTH_LONG).show();
                        } else if (str_empcode.equals(0)) {
                            Toast.makeText(getApplicationContext(), "EMPLOYEE IS MANDATORY", Toast.LENGTH_LONG).show();
                        } else if (!str_empcode.equals(0) && !str_name.equals(0) &&
                                 !str_phnmber.equals(0)) {
                            if (str_empcode.equals("1234")) {
                                number = "8457892173";
                                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                        "+91 " + number,
                                        60,
                                        java.util.concurrent.TimeUnit.SECONDS,
                                        SavedSeats.this,
                                        mCallbacks);
                                T2.setText("Please Enter the OTP Send to Your Registered Number "+number);
                                T1.setVisibility(View.GONE);
                                Saveinfo.setVisibility(View.GONE);
                                Pname.setVisibility(View.GONE);
                                Pnumber.setVisibility(View.GONE);
                                Empcode.setVisibility(View.GONE);
                                passnumber.setVisibility(View.GONE);
                                button.setVisibility(VISIBLE);
                                editText2.setVisibility(VISIBLE);
                            } else if (str_empcode.equals("0000")) {
                                number = "9131341690";
                                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                        "+91 " + number,
                                        60,
                                        java.util.concurrent.TimeUnit.SECONDS,
                                        SavedSeats.this,
                                        mCallbacks);
                                T2.setText("Please Enter the OTP Send to Your Registered Mobile Number "+number);
                                T1.setVisibility(INVISIBLE);
                                Saveinfo.setVisibility(INVISIBLE);
                                Pname.setVisibility(INVISIBLE);
                                Pnumber.setVisibility(INVISIBLE);
                                Empcode.setVisibility(INVISIBLE);
                                passnumber.setVisibility(INVISIBLE);
                                button.setVisibility(VISIBLE);
                                editText2.setVisibility(VISIBLE);
                            } else if (str_empcode.equals("1111")) {
                                number = "9102971804";
                                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                        "+91 " + number,
                                        60,
                                        java.util.concurrent.TimeUnit.SECONDS,
                                        SavedSeats.this,
                                        mCallbacks);
                                T2.setText("Please Enter the OTP Send to Your Registered Number "+number);
                                T1.setVisibility(View.GONE);
                                Saveinfo.setVisibility(View.GONE);
                                Pname.setVisibility(View.GONE);
                                Pnumber.setVisibility(View.GONE);
                                Empcode.setVisibility(View.GONE);
                                passnumber.setVisibility(View.GONE);
                                button.setVisibility(VISIBLE);
                                editText2.setVisibility(VISIBLE);
                            } else {
                                Toast.makeText(SavedSeats.this, "Invalid Employee Code", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Soory,Error Occured..",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Please see that you have Active internet connection..",Toast.LENGTH_LONG).show();
                }

                }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, editText2.getText().toString());
                // [END verify_with_code]
               switch (v.getId()) {
                    case R.id.button:
                   saveValueInPref();
                        break;
                }
              recyclerView.setVisibility(VISIBLE);
              button.setVisibility(INVISIBLE);
                T2.setVisibility(INVISIBLE);
                editText2.setVisibility(INVISIBLE);
                signInWithPhoneAuthCredential(credential);
            }
        });

    }

    private void saveValueInPref() {
        String key = String.valueOf(mBookAdapter.getItemCount()+1);
        String value = Pname.getText().toString();
        /*String value2 = E2.getText().toString();
        String value3 = E3.getText().toString();
        String value4 = E4.getText().toString();
     
            Toast.makeText(this, "Registered !!", Toast.LENGTH_SHORT).show();
         
            if (mbookDataList.contains(newPrefData)) {
                int index = mbookDataList.indexOf(newPrefData);
                mbookDataList.remove(index);
                mBookAdapter.notifyItemRemoved(index);
            }
            mbookDataList.add(newPrefData);
            int position = mBookAdapter.getItemCount() - 1;
            mBookAdapter.notifyItemInserted(position);

    }
   /* private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    saveValueInPref();
                    break;
            }
        }
    };
    private void signInWithPhoneAuthCredential (PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Log.d(TAG, "signInWithCredential:success");

                            Toast.makeText(SavedSeats.this, "Verification Done", Toast.LENGTH_SHORT).show();
                            // ...
                        } else {
                            // Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(SavedSeats.this, "Invalid Verification", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

    }
     /*   @Override
    public void onClick(View v) {
        if (appStatus.isOnline()){
            str_name=Pname.getText().toString().trim();
            str_phnmber=Pnumber.getText().toString().trim();
            str_empcode=Empcode.getText().toString().trim();
            str_psnum=passnumber.getText().toString().trim();
            try {
                if (str_name.length() == 0 && str_empcode.length() == 0 &&
                        str_phnmber.length() == 0 && str_psnum.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill the Details..", Toast.LENGTH_LONG).show();
                } else if (str_name.length() == 0 || str_empcode.length() == 0 ||
                        str_empcode.length() == 0 || str_empcode.length() == 0) {
                    Toast.makeText(getApplicationContext(), "All fields are Mandatory", Toast.LENGTH_LONG).show();
                } else if (str_empcode.equals(0)) {
                    Toast.makeText(getApplicationContext(), "EMPLOYEE IS MANDATORY", Toast.LENGTH_LONG).show();
                } else if (!str_empcode.equals(0)) {

                 }
             else if(!str_name.equals(0)&& !str_phnmber.equals(0)
                        && !str_empcode.equals(0) && !str_psnum.equals(0)) {
                    BookedInfo saveData = new BookedInfo(str_name,str_phnmber, str_empcode,str_psnum);
                    ref.push().setValue(saveData);
                    Toast.makeText(getApplicationContext(),"Booked Succesfully..",Toast.LENGTH_SHORT).show();
                   /* Intent intent=new Intent(SavedSeats.this,MainActivity.class);
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

    }*/


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.university.soa.bus.SeatClass.OnSeatSelected;
import com.university.soa.bus.SeatClass.SelectableAdapter;

import java.util.HashSet;
import java.util.Set;

public class SavedSeats extends AppCompatActivity {


    DatabaseReference ref;


    Button Saveinfo, button;
    SharedPreferences seats;
   
    Set<Integer> selected;

    
    String str_name, str_empcode, str_psnum, str_phnmber;
    EditText Pname, Pnumber, Empcode, passnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_info);
      

      selected= new HashSet<>();

        Saveinfo = findViewById(R.id.saveinfo);
        button = findViewById(R.id.button);
        Pname = findViewById(R.id.PName);
        Pnumber = findViewById(R.id.PhnNumber);
        Empcode = findViewById(R.id.EmpCode);
        passnumber = findViewById(R.id.PsNum);
        ref = FirebaseDatabase.getInstance().getReference().child("booked details");

        Saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   store();
                 }
        });
    }

    public void store() {
        str_name = Pname.getText().toString().trim();
        str_empcode = Empcode.getText().toString().trim();
        str_phnmber = Pnumber.getText().toString().trim();
        str_psnum = passnumber.getText().toString().trim();

        //Addata ad = new Addata(str_name, str_empcode, str_phnmber, str_psnum);
            //positions1.remove(positions);
           // String b = String.valueOf(seats.getStringSet("s", positions));
               ref.child(str_empcode).push().setValue(String.valueOf(selected));
           // Toast.makeText(this, "multiple", Toast.LENGTH_SHORT).show();


        Toast.makeText(SavedSeats.this, "Booked", Toast.LENGTH_SHORT).show();
    }

 
}






