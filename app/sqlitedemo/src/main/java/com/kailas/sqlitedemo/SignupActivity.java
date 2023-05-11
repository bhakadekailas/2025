package com.kailas.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword;
    Button buttonSignUp;
    private final String TAG = SignupActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();
    }

    private void initViews() {
        Log.e(TAG, "initViews: ");
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTextLastName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                UserDataModel userDataModel = new UserDataModel();
                userDataModel.setFirstName(firstName);
                userDataModel.setLastName(lastName);
                userDataModel.setEmail(email);
                userDataModel.setPassword(password);

                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(SignupActivity.this);
                myDatabaseHelper.saveIntoDatabase(userDataModel);
                editTextFirstName.setText("");
                editTextLastName.setText("");
                editTextEmail.setText("");
                editTextPassword.setText("");
            }
        });
    }
}