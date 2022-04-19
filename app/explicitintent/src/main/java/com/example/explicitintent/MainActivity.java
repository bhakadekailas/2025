package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonNext);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Name", "Kailas Bhakade");
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}