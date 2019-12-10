package com.proyectofinal.picoplaca.Interfaces;

public interface LoginInteractor {
    void validarUser(String user, String pass, OnLoginFinishListener listener);
}
