package com.proyectofinal.picoplaca.Presenters;

import android.icu.lang.UScript;

import com.proyectofinal.picoplaca.Interfaces.Usuario;

public class UsuarioImpl implements Usuario {
    int id;
    String nombre, correo, usuario, password;

    public UsuarioImpl(){
    }

    public UsuarioImpl(String nombre, String correo, String usuario, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
    }

    public boolean isNull(){
        if(nombre.equals("")||correo.equals("")||usuario.equals("")||password.equals("")){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsuarioImpl{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
