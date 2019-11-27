package com.epis.miplaca.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epis.miplaca.MyApplication;
import com.epis.miplaca.R;
import com.epis.miplaca.controller.MVCController;
import com.epis.miplaca.model.MVCModelImplementor;
import com.epis.miplaca.model.bean.Placa;

import java.util.List;

public class MainActivityViewImplementor implements MVCMainActivityView {
    private static final String TAG = "MainActivityViewImplementor";

    View rootView;
    MVCController mvcController;
    private MVCModelImplementor mvcModel;

    private EditText placa, alias;
    private Button registrar;

    public MainActivityViewImplementor(Context context, ViewGroup viewGroup){
        rootView = LayoutInflater.from(context).inflate(R.layout.activity_main,viewGroup);
        mvcModel = new MVCModelImplementor(MyApplication.getToDoListDBAdapter());
        mvcController = MVCController.getControlador(mvcModel,this);
    }
    @Override
    public void initViews() {
        placa = (EditText)rootView.findViewById(R.id.placa);
        alias = (EditText)rootView.findViewById(R.id.alias);
        registrar = (Button)rootView.findViewById(R.id.registrar);

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v("MainActivityViewImplem", "View click en Button Register");
                mvcController.onRegisterButtonClicked(placa.getText().toString(),alias.getText().toString());
            }
        });
    }
    @Override
    public View getRootView() {

        return rootView ;
    }

    @Override
    public void bindDataToView() {
        mvcController.onViewLoaded();
    }

    @Override
    public void showErrorToast(String errorMessage) {
        Toast.makeText(rootView.getContext(),errorMessage, Toast.LENGTH_LONG).show();
        if(errorMessage.equals("Empty To Do List")){

        }
    }

    @Override
    public void updateViewOnRegister(List<Placa> placa) {
        Log.v("MainActivityViewImplem", "View Button Register addPlaca exitosa");
        int size = placa.size();
        Log.v("MainActivityViewImplem", placa.get(size-1).toString());
        //this.showAllToDos(misPlacas);
        clearEditTexts();

    }
    private void clearEditTexts(){
        alias.setText("");
        placa.setText("");
    }

    public MVCController getMvcController() {
        return mvcController;
    }
}
