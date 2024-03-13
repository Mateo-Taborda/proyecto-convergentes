package com.example.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;

public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
    }
    public void onClickRegister(View view){
        String firstname = findViewById(R.id.firstname).toString();
        String lastname = findViewById(R.id.lastname).toString();
        String email = findViewById(R.id.email).toString();
        int phone = Integer.parseInt(findViewById(R.id.phone).toString());
        String address = findViewById(R.id.address).toString();
        Spinner country = findViewById(R.id.country);
        String country2 = country.getSelectedItem().toString();
        Spinner city = findViewById(R.id.city);
        String city2 = city.getSelectedItem().toString();
        DatePicker birthdate = findViewById(R.id.birthdate);
        String birthdate2 = birthdate.toString();
        ToggleButton typeOfUser = findViewById(R.id.toggleButton);
        System.out.println(firstname + " " + lastname + ", " + email + ", " + phone + ", " + address + ", " + country2 + ", " + city2 + ", " + birthdate2);

    }
}
