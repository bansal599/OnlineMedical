package com.example.pankajthawani.onlinedoctor;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Otp extends AppCompatActivity {
    EditText otp;
    Button submit;
    SharedPreferences sharedPreferences;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otp=findViewById(R.id.editText3);
        sharedPreferences=getSharedPreferences("sp", Context.MODE_PRIVATE);
        submit=findViewById(R.id.submitbtn);

      submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              try {
                  if (Registration.number.toString().equals(otp.getText().toString()))
                  {
                      Intent i=new Intent(Otp.this,HomePage.class);
                      startActivity(i);
                  }
                  else
                  {
                      Toast.makeText(Otp.this, "Enter valid OTP", Toast.LENGTH_SHORT).show();
                  }
              }catch (Exception e)
              {
                  Toast.makeText(Otp.this, "Error"+e, Toast.LENGTH_SHORT).show();
              }
              String otp;
              otp=Registration.number;
              SharedPreferences.Editor editor=sharedPreferences.edit();
              editor.putString("otp",Registration.number);
              editor.commit();
          }
      });
    }
}
