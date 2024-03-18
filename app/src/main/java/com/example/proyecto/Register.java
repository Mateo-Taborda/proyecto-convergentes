package com.example.proyecto;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.proyecto.usuariomvc.UsuarioController;

import java.sql.SQLException;
import java.util.Date;

public class Register extends Activity {
UsuarioController miController = new UsuarioController();
private String birthdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

    }
    public void onClickRegister(View view) throws SQLException {
        EditText id_firstname = findViewById(R.id.firstname);
        EditText id_lastname = findViewById(R.id.lastname);
        EditText id_email = findViewById(R.id.email);
        EditText id_password = findViewById(R.id.psswrd);
        EditText id_phone = findViewById(R.id.phone);
        Spinner id_country = findViewById(R.id.country);
        Spinner id_city =  findViewById(R.id.city);
        ToggleButton id_userType = findViewById(R.id.toggleButton);

        if(!id_firstname.getText().toString().isEmpty() && !id_lastname.getText().toString().isEmpty()&&
        !id_email.getText().toString().isEmpty() && !id_password.getText().toString().isEmpty() &&
                !id_phone.getText().toString().isEmpty()
                && !birthdate.isEmpty()){
            String firstname = id_firstname.getText().toString();
            String lastname = id_lastname.getText().toString();
            String email = id_email.getText().toString();
            String password = id_password.getText().toString();
            long phone = Long.parseLong(id_phone.getText().toString());
            String country =  String.valueOf(id_country.getSelectedItem());
            String city = String.valueOf(id_city.getSelectedItem());
            String userType;
            if(id_userType.isChecked()){
                userType = "Conductor";
            }else userType="Cliente";
           miController.insertarUsuario(Register.this, firstname,lastname, email, password , phone , country, city, birthdate, userType);
            Toast.makeText(this, "Registro exitoso, inicie sesión", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else{
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
        }
         }
         public void onClickShowCalendar(View view){

             DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                 @Override
                 public void onDateSet(DatePicker datepicker, int year, int month, int dayOfMonth) {
                    birthdate = String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(dayOfMonth);
                 }
             }, 2000, 3, 19);
            dialog.show();
         }
}
