package com.example.pankajthawani.onlinedoctor;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button symp,special,tips,precautions,google;
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        symp=findViewById(R.id.symptopmsbtn);
        special=findViewById(R.id.Specialistsbtn);
        precautions=findViewById(R.id.prebtn);
        tips=findViewById(R.id.tipsbtn);
        google=findViewById(R.id.searchbtn);
        symp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(HomePage.this,Next.class);
                startActivity(int2);
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Specialists.class);
                startActivity(intent);
            }
        });
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Tips.class);
                startActivity(intent);
            }
        });
        precautions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Precaution.class);
                startActivity(intent);
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Google.class);
                startActivity(intent);
            }
        });
    }
}
