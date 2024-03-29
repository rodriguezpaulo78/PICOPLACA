package com.epis.miplaca.controller;

import android.content.Context;
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
    public void onRegisterButtonClicked(Context context,String placa, String alias){
        try{
            Log.v(TAG, "Controller AddButtonRegister");
            boolean sucess = mvcModel.addPlaca(context,placa,alias);
            if(sucess){
                Log.v(TAG, "Regresando a Controller AddButtonRegister");
                mvcView.updateViewOnRegister(mvcModel.getAllPlaca());
            }
        }catch (Exception e){
            mvcView.showErrorToast(e.getMessage());
        }
    }
    //Screen Load
    public String pruebaController(Context context){
        String objeto = "hola";
        try{
            //mvcView.showAllToDos(mvcModel.getAllToDos());
            Log.v("vista 2 controlador: ", objeto);
            objeto = mvcModel.listaPlacaResult(context);

        }catch (Exception e){
            //mvcView.showErrorToast(e.getMessage());
        }
        Log.v("vista 2 controlador: ", objeto);
        return objeto;
    }

    public void fileListaPlaca(Context context) throws Exception {
        mvcModel.fileListaPlaca(context);
    }
}
