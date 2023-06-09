package com.example.shoeverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;



public class NameActivity extends AppCompatActivity {

    private TextView mWebsiteEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


    }

    public void wenruiInsta(View view)
    {


        Uri webpage = Uri.parse("https://instagram.com/__wen.rui_?igshid=MzNlNGNkZWQ4Mg==");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }


        else
        {
            Log.d("ImplicitIntents","Can't handle this!");
        }


    }


    public void kahyauInsta(View view)
    {


        Uri webpage = Uri.parse("https://www.instagram.com/kah_yau10?r=nametag");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }


        else
        {
            Log.d("ImplicitIntents","Can't handle this!");
        }


    }




}