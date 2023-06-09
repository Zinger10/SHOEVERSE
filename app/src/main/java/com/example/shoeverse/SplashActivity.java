package com.example.shoeverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class SplashActivity extends AppCompatActivity {

    private Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        b1 = (Button) findViewById(R.id.button_dev);
        b2 = (Button) findViewById(R.id.button_start);

        //Developers button
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SplashActivity.this, NameActivity.class));
            }
        });

        //Get Started
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });

    }


}