package com.epis.miplaca.controller;

import android.util.Log;
import android.widget.Toast;

import com.epis.miplaca.model.MVCModelImplementor;
import com.epis.miplaca.view.MainActivityViewImplementor;

public class MVCController {
    private static final String TAG = "MVCController";
    MVCModelImplementor mvcModel;
    MainActivityViewImplementor mvcView;

    public MVCController(MVCModelImplementor mvcModel,MainActivityViewImplementor mvcView){
        this.mvcModel = mvcModel;
        this.mvcView = mvcView;
    }
    //Screen Load
    public void onViewLoaded(){
        try{
            //mvcView.showAllToDos(mvcModel.getAllToDos());
        }catch (Exception e){
            //mvcView.showErrorToast(e.getMessage());
        }
    }
    //on Add Clicked
    public void onRegisterButtonClicked(String placa, String alias){
        try{
            Log.v(TAG, "Controller AddButtonRegister");
            boolean sucess = mvcModel.addPlaca(placa,alias);
            if(sucess){
                Log.v(TAG, "Regresando a Controller AddButtonRegister");
                mvcView.updateViewOnRegister(mvcModel.getAllPlaca());
            }
        }catch (Exception e){
            mvcView.showErrorToast(e.getMessage());
        }
    }
}
