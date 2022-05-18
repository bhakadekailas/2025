package com.kailas.factorialdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button buttonFactorialOnAlert, buttonFactorialOnOtherActivity;
    private EditText editTextFactNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFactorialOnAlert = findViewById(R.id.buttonFactorialOnAlert);
        buttonFactorialOnOtherActivity = findViewById(R.id.buttonFactorialOnOtherActivity);
        editTextFactNo = findViewById(R.id.editTextFactNo);
        buttonFactorialOnAlert.setOnClickListener(view -> {
            int num = Integer.parseInt(editTextFactNo.getText().toString());
            double fact = factorial(num);
            callAlertDialog(fact);
        });

        buttonFactorialOnOtherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(editTextFactNo.getText().toString());
                double fact = factorial(num);
                callNextActivity(fact);
            }
        });
    }

    private void callNextActivity(double fact) {
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("MyFact", fact);
        startActivity(intent);
    }

    private double factorial(double num) {
        double fact = 1, i;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private void callAlertDialog(double fact) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Factorial is:-  " + fact);
        builder.setCancelable(false);
        builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}