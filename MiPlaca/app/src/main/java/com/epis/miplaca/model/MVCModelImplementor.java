package com.epis.miplaca.model;

import android.util.Log;

import com.epis.miplaca.model.bean.Placa;
import com.epis.miplaca.model.db.ToDoListDBAdapter;

import java.util.ArrayList;
import java.util.List;

public class MVCModelImplementor implements MVCModel {
    private static final String TAG = "MVCModelImplementor";

    ToDoListDBAdapter toDoListDBAdapter;
    List<Placa> placa = new ArrayList<>();



    public MVCModelImplementor(ToDoListDBAdapter toDoListDBAdapter){
        this.toDoListDBAdapter = toDoListDBAdapter;
        //toDoItems = this.toDoListDBAdapter.getAllToDos();
    }


    @Override
    public boolean addPlaca(String placa, String alias) throws Exception {
        Log.v(TAG, "Model addPlaca exitosa");
        Placa nuevaPlaca = new Placa(placa,alias);
        this.placa.add(nuevaPlaca);

         /*
       boolean addSuccess = toDoListDBAdapter.insert(toDoItem, place);
        if (addSuccess){
            refresh();
        }else{
            throw new Exception("Some thing went wrong!!!");
        }
        */
        return true;
    }

    @Override
    public boolean removePlaca(int id) throws Exception {
        return false;
    }

    @Override
    public boolean modifyPlaca(int id, String newToDoValuel) throws Exception {
        return false;
    }
    public String listaPlacaResult() throws Exception {
        return "Correcta Lista Placas";
    }


    @Override
    public List<Placa> getAllPlaca() throws Exception {
        return placa;
    }

    private void refresh(){
        placa.clear();
        //toDoItems = this.toDoListDBAdapter.getAllToDos();
    }
}
