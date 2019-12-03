package com.epis.miplaca.model;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.epis.miplaca.model.bean.Placa;
import com.epis.miplaca.model.db.ToDoListDBAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MVCModelImplementor implements MVCModel {
    private static final String TAG = "MVCModelImplementor";
    ToDoListDBAdapter toDoListDBAdapter;
    List<Placa> listaPlaca = new ArrayList<>();
    Gson gson = new Gson();

    public MVCModelImplementor(ToDoListDBAdapter toDoListDBAdapter){
        this.toDoListDBAdapter = toDoListDBAdapter;
        //toDoItems = this.toDoListDBAdapter.getAllToDos();
    }

    public void fileListaPlaca(Context context) throws Exception {
        File dirPics = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(dirPics,"listaPlacasJson.txt");
        String jsonArray =IOHelper.stringFromFile(f);


        /////interno
        //String jsonArray = IOHelper.readToFile(context,"listaPlacasJson.txt");
        Type listType = new TypeToken<ArrayList<Placa>>(){}.getType();
        listaPlaca = gson.fromJson(jsonArray, listType);
        return;
    }
    @Override
    public boolean addPlaca(Context context, String placa, String alias) throws Exception {
        Log.v(TAG, "Model addPlaca exitosa");
        Placa nuevaPlaca = new Placa(placa,alias);
        this.listaPlaca.add(nuevaPlaca);
        String jsonString = gson.toJson(listaPlaca);
        ////externoPrivado////
        File dirPics = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(dirPics,"listaPlacasJson.txt");
        IOHelper.writeToFile(f,jsonString);

        //IOHelper.writeToFile(context,"listaPlacasJson.txt",jsonString);

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
    public String listaPlacaResult(Context context) throws Exception {
        Log.v("vista 2 modelo: ","listaPlaca");
        /////externoPrivado
        File dirPics = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(dirPics,"listaPlacasJson.txt");
        String jsonArray =IOHelper.stringFromFile(f);


        /////interno
        //String jsonArray = IOHelper.readToFile(context,"listaPlacasJson.txt");
        Type listType = new TypeToken<ArrayList<Placa>>(){}.getType();
        ArrayList<Placa> listaPlaca2 = gson.fromJson(jsonArray, listType);
        String result = "\nPlaca: "+listaPlaca2.get(listaPlaca2.size()-1).getPlaca()+"\n"+
        "Alias: "+listaPlaca2.get(listaPlaca2.size()-1).getAlias();

        Log.v("vista 2 modelo: ",result);

        return "Correcta Lista Placas";
    }


    @Override
    public List<Placa> getAllPlaca() throws Exception {
        return listaPlaca;
    }

    private void refresh(){
        listaPlaca.clear();
        //toDoItems = this.toDoListDBAdapter.getAllToDos();
    }
}
