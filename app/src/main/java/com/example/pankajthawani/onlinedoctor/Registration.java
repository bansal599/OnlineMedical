package com.example.pankajthawani.onlinedoctor;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class
Registration extends AppCompatActivity {

    static  String usrname,usrmob;
    static Random random=new Random();
    static int num=random.nextInt(100000)+1;
    static String number=String.valueOf(num);
    TextView reg;
    EditText name,mob;
    Button register;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        reg = (TextView) findViewById(R.id.textView);
        name = (EditText) findViewById(R.id.name);
        mob = (EditText) findViewById(R.id.phoneno);
        register = (Button) findViewById(R.id.submitbtn);
        usrname = name.getText().toString();
        usrmob = mob.getText().toString();
//        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
//        {
//            requestPermissions(new String[]{
//                    Manifest.permission.SEND_SMS},10);
//            return;
//        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (name.getText().toString().length() != 10 && mob.getText().toString().length() == 0) {
                        Toast.makeText(Registration.this, "Enter Valid Mobile No.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Registration.this, "OTP send", Toast.LENGTH_SHORT).show();
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(mob.getText().toString(), null, "Hello " + name.getText().toString() + "\n" + "Your OTP is " + number, null, null);
                        Intent i = new Intent(Registration.this, Otp.class);
                        startActivity(i);
                    }
                } catch (Exception e) {
                    Toast.makeText(Registration.this, "" + e, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void on_help(View view)
    {
        Intent intent=new Intent(Registration.this,Help.class);
        startActivity(intent);
    }
}
