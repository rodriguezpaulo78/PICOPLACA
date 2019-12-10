package com.proyectofinal.picoplaca.Presenters;

import com.proyectofinal.picoplaca.Interactors.LoginInteractorImpl;
import com.proyectofinal.picoplaca.Interfaces.LoginInteractor;
import com.proyectofinal.picoplaca.Interfaces.LoginPresenter;
import com.proyectofinal.picoplaca.Interfaces.LoginView;
import com.proyectofinal.picoplaca.Interfaces.OnLoginFinishListener;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishListener {

    //el presenter es el puente entre vista e interactor
    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view){
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    public void validarUsuario(String user, String pass){
        if(view!= null){
            view.showProgress();
        }
        interactor.validarUser(user,pass,this);
    }

    public void usernameError(){
        if(view!=null){
            view.hideProgress();
            view.setErrorUser();
        }
    }

    public void passwordError(){
        if(view!=null){
            view.hideProgress();
            view.setErrorPassword();
        }
    }

    public void exitOperacion(){
        if(view!=null){
            view.hideProgress();
            view.navigateToHome();
        }
    }
}
