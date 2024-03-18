package com.example.proyecto.usuariomvc;

import static androidx.core.content.ContextCompat.startActivity;
import static java.lang.String.valueOf;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto.MainActivity;
import java.util.HashMap;
import java.util.Map;

public class UsuarioModel extends Activity{
    public void userRegister(Activity activity, String name, String lastname, String email, String password, long phone, String country, String city, String birthdate, String usertype ) {
        int resp = 0;
        String username = name + " " + lastname;
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.10.12/restAPI/insertar.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (response.equalsIgnoreCase("datos insertados")) {
                            Toast.makeText(activity, "Registrado, inicie sesión", Toast.LENGTH_SHORT).show();
                        } else if (response.equalsIgnoreCase("datos error")) {
                            Toast.makeText(activity, "Error, intente más tarde", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(request);
        }
    }

