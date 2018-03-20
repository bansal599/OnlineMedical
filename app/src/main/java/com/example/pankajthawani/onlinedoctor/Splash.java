package com.example.pankajthawani.onlinedoctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    SharedPreferences d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        d=getSharedPreferences("sp", Context.MODE_PRIVATE);
        final String otp= d.getString("otp",null);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    if (otp!=null){
                        Intent intent=new Intent(Splash.this,HomePage.class);
                        startActivity(intent);
                    }
                    else if (otp==null)
                    {
                        Intent intent=new Intent(Splash.this,Registration.class);
                        startActivity(intent);
                    }
                    finish();
                }
            }
        };
        timer.start();
    }
}
