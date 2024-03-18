package com.example.proyecto.usuariomvc;

import android.app.Activity;

public class UsuarioController {
    private UsuarioModel usuarioModel;
    public UsuarioController() {
        this.usuarioModel = new UsuarioModel();
    }

    public void insertarUsuario(Activity activity, String name, String lastname, String email, String password, long phone, String country, String city, String birthdate, String usertype ) {
        usuarioModel.userRegister(activity, name, lastname, email, password, phone, country, city, birthdate, usertype);
    }
}
