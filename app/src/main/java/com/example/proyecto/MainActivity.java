package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    public void onClickShowRegisterUI(View view){
        startActivity(new Intent(this, Register.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClickLogin(View view){
        email = findViewById(R.id.email_textField);
        password = findViewById(R.id.password_textfield);

    }
}