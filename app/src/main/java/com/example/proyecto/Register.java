package com.example.proyecto;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class Register extends Activity {

private String birthdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

    }
    public void onClickRegister(View view)  {
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
          userRegister(firstname,lastname, email, password , phone , country, city, birthdate, userType);
            startActivity(new Intent(this, MainActivity.class));

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
    public void userRegister(String name, String lastname, String email, String password, long phone, String country, String city, String birthdate, String usertype )  {
        String username = name + " " + lastname;
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.112/restAPI/insertar.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                        if (response.equalsIgnoreCase("1")) {
                            Toast.makeText (Register.this, "Registrado, inicie sesión", Toast.LENGTH_SHORT).show();
                        } else if (response.equalsIgnoreCase("0")) {
                            Toast.makeText(Register.this,"Error, intente más tarde", Toast.LENGTH_SHORT).show();
                        }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("username", username);
                parametros.put("firstname", name);
                parametros.put("lastname", lastname);
                parametros.put("email", email);
                parametros.put("psswrd", password);
                parametros.put("phone", String.valueOf(phone));
                parametros.put("country", country);
                parametros.put("city", city);
                parametros.put("birthdate", birthdate);
                parametros.put("usertype", usertype);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
        requestQueue.add(request);
    }
}
