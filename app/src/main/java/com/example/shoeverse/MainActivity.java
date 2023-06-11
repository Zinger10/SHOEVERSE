package com.example.shoeverse;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.shoeverse.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

//firebase
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String mOrderMessage;

    private DatabaseReference mDatabase;
    private ImageView imageView;
    public static final String EXTRA_MESSAGE = "com.example.android.shoeverse.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageView = findViewById(R.id.imageView);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the Nike image was clicked.
     */
    public void showNikeOrder(View view) {
        mOrderMessage = getString(R.string.nike_order_message);
        displayToast(mOrderMessage);

        mDatabase.child("LED1").setValue(1);
        mDatabase.child("LED2").setValue(0);
        mDatabase.child("LED3").setValue(0);
        mDatabase.child("order_status").setValue(0);
    }

    /**
     * Shows a message that the Puma image was clicked.
     */
    public void showPumaOrder(View view) {
        mOrderMessage = getString(R.string.puma_order_message);
        displayToast(mOrderMessage);

        mDatabase.child("LED1").setValue(0);
        mDatabase.child("LED2").setValue(1);
        mDatabase.child("LED3").setValue(0);
        mDatabase.child("order_status").setValue(0);
    }

    /**
     * Shows a message that the Adidas was clicked.
     */
    public void showAdidasOrder(View view) {
        mOrderMessage = getString(R.string.adidas_order_message);
        displayToast(mOrderMessage);

        mDatabase.child("LED1").setValue(0);
        mDatabase.child("LED2").setValue(0);
        mDatabase.child("LED3").setValue(1);
        mDatabase.child("order_status").setValue(0);
    }


}