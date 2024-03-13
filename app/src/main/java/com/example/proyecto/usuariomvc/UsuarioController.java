package com.example.proyecto.usuariomvc;

public class UsuarioController {
    private UsuarioModel usuarioModel;

    public UsuarioController() {
        this.usuarioModel = new UsuarioModel();
    }

    public void insertarUsuario(String username, String firstname, String lastname, String email, int phone, String address, String country, String city, String birthdate, String role, String created_at) {
        usuarioModel.insertarUsuario(username, firstname, lastname, email, phone, address, country, city, birthdate, role, created_at);
    }
}
