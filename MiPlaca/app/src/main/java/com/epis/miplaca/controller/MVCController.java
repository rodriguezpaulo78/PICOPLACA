package com.epis.miplaca.controller;

import android.util.Log;
import android.widget.Toast;

import com.epis.miplaca.model.MVCModelImplementor;
import com.epis.miplaca.view.ListarPlacas;
import com.epis.miplaca.view.MainActivityViewImplementor;

import java.io.Serializable;

public class MVCController {
    private static final String TAG = "MVCController";
    private static MVCController controlador = null;
    MVCModelImplementor mvcModel;
    MainActivityViewImplementor mvcView;

    private ListarPlacas listarPlacas;

    public ListarPlacas getListarPlacas() {
        return listarPlacas;
    }
    public void setListarPlacas(ListarPlacas listarPlacas) {
        this.listarPlacas = listarPlacas;
    }




    private MVCController(MVCModelImplementor mvcModel,MainActivityViewImplementor mvcView){
        this.mvcModel = mvcModel;
        this.mvcView = mvcView;
    }

    public static MVCController getControlador(MVCModelImplementor mvcModel,MainActivityViewImplementor mvcView) {
        if (controlador==null) {
            controlador = new MVCController(mvcModel,mvcView);
        }
        return controlador;
    }
    public static MVCController getControlador() {
        if (controlador==null) {
        }
        return controlador;
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
    //Screen Load
    public String pruebaController(){
        String objeto = "hola";
        try{
            //mvcView.showAllToDos(mvcModel.getAllToDos());
            objeto = mvcModel.listaPlacaResult();
            Log.v("result contenido: ", objeto);
        }catch (Exception e){
            //mvcView.showErrorToast(e.getMessage());
        }
        Log.v("contenido final: ", objeto);
        return objeto;
    }
}
