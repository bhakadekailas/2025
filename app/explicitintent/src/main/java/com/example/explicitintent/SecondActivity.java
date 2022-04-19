package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        String myName = bundle.getString("Name");
        Log.e("SecondActivity", "onCreate: " + myName);
        Toast.makeText(this, myName, Toast.LENGTH_SHORT).show();
    }
}