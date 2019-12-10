package com.proyectofinal.picoplaca.Interactors;

import com.proyectofinal.picoplaca.Interfaces.LoginInteractor;
import com.proyectofinal.picoplaca.Interfaces.OnLoginFinishListener;

import android.os.Handler;

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void validarUser(final String user, final String pass, final OnLoginFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                if(!user.equals("") && !pass.equals("")){
                    listener.exitOperacion();
                } else {
                    if(user.equals("")) {
                        listener.usernameError();
                    }else{
                        if(pass.equals("")) {
                            listener.passwordError();
                        }
                    }
                }
            }
        }, 1500);
    }
}
