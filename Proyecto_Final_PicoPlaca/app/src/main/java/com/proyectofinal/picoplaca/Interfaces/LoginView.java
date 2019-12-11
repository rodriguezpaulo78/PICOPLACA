package com.proyectofinal.picoplaca.Interfaces;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setErrorUser();
    void setErrorPassword();
    void navigateToHome();
}
