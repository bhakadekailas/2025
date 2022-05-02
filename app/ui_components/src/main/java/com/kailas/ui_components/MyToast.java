package com.kailas.ui_components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyToast extends AppCompatActivity {
    Button button_create_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_toast);
        button_create_toast = findViewById(R.id.button_create_toast);
        button_create_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyToast.this, "Toast is created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}