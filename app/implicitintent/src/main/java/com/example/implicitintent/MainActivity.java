package com.example.implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.buttonCamera);

//        button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
////                startActivity(intent);
////            }
////        });

        //todo



    }
}
