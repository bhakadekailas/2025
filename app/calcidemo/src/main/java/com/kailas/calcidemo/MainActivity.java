package com.kailas.calcidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_plus, button_minus, button_mul, button_div, button_clear;
    EditText edittext_first_number, edittext_second_number;
    TextView textView_result;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        initViews();
        addClickListeners();
    }

    private void addClickListeners() {
        button_plus.setOnClickListener(view -> {
            Log.e(TAG, "addClickListeners: ");
            hideKeyboard();
            int sum = addition();
            textView_result.setText(String.valueOf(sum));
        });

        button_minus.setOnClickListener(view -> {
            Log.d(TAG, "addClickListeners: ");
            hideKeyboard();
            int subtraction = subtraction();
            textView_result.setText(String.valueOf(subtraction));
        });

        button_mul.setOnClickListener(view -> {
            Log.d(TAG, "addClickListeners: ");
            hideKeyboard();
            int multiplication = multiplication();
            textView_result.setText(String.valueOf(multiplication));
        });

        button_div.setOnClickListener(view -> {
            Log.d(TAG, "addClickListeners: ");
            hideKeyboard();
            int division = division();
            textView_result.setText(String.valueOf(division));
        });

        button_clear.setOnClickListener(view -> {
            Log.d(TAG, "addClickListeners: ");
            hideKeyboard();
            clearViews();
        });
    }

    private void hideKeyboard() {
        Log.d(TAG, "hideKeyboard: ");
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.e(TAG, "hideKeyboard: " + e.getMessage());
        }
    }

    private boolean isEditTextEmpty() {
        Log.d(TAG, "isEditTextEmpty: ");
        if (edittext_first_number.getText().toString().isEmpty()) {
            Toast.makeText(this, "Number 1 should not empty.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edittext_second_number.getText().toString().isEmpty()) {
            Toast.makeText(this, "Number 2 should not empty.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void clearViews() {
        Log.d(TAG, "clearViews: ");
        edittext_first_number.setText("");
        edittext_second_number.setText("");
        textView_result.setText("");
        edittext_first_number.requestFocus();
    }

    private int division() {
        int div = 0;
        if (isEditTextEmpty()) {
            int number1 = Integer.parseInt(edittext_first_number.getText().toString());
            int number2 = Integer.parseInt(edittext_second_number.getText().toString());
            div = number1 / number2;
        }
        return div;
    }

    private int multiplication() {
        Log.d(TAG, "multiplication: ");
        int mul = 0;
        if (isEditTextEmpty()) {
            int number1 = Integer.parseInt(edittext_first_number.getText().toString());
            int number2 = Integer.parseInt(edittext_second_number.getText().toString());
            mul = number1 * number2;
        }
        return mul;
    }

    private int subtraction() {
        int sub = 0;
        if (isEditTextEmpty()) {
            int number1 = Integer.parseInt(edittext_first_number.getText().toString());
            int number2 = Integer.parseInt(edittext_second_number.getText().toString());
            sub = number1 - number2;
        }
        return sub;
    }

    private int addition() {
        Log.d(TAG, "addition: ");
        int sum = 0;
        if (isEditTextEmpty()) {
            int number1 = Integer.parseInt(edittext_first_number.getText().toString());
            int number2 = Integer.parseInt(edittext_second_number.getText().toString());
            sum = number1 + number2;
        }
        return sum;
    }

    private void initViews() {
        //find out buttons
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_mul = findViewById(R.id.button_mul);
        button_div = findViewById(R.id.button_div);
        button_clear = findViewById(R.id.button_clear);
        // find out edittext
        edittext_first_number = findViewById(R.id.edittext_first_number);
        edittext_second_number = findViewById(R.id.edittext_second_number);
        //find out textview
        textView_result = findViewById(R.id.textView_result);
    }
}