package com.proyectofinal.picoplaca.Interfaces;

public interface Usuario {
    boolean isNull();
    int getId();
    void setId(int id);
    String getNombre();
    void setNombre(String nombre);
    String getCorreo();
    void setCorreo(String correo);
    String getUsuario();
    void setUsuario(String usuario);
    String getPassword();
    void setPassword(String password);

}
