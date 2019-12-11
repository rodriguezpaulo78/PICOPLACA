package com.proyectofinal.picoplaca.Interactors;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.proyectofinal.picoplaca.Interactors.bean.Placa;
import com.proyectofinal.picoplaca.Interfaces.PeristenciaFile;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaFile implements PeristenciaFile {
    private static final String TAG = "PersistenciaFile";
    List<Placa> listaPlaca = new ArrayList<>();
    Gson gson = new Gson();


    @Override
    public boolean addPlaca(Context context, String alias, String placa) throws Exception {
        Log.v(TAG, "Model addPlaca exitosa");
        Placa nuevaPlaca = new Placa(placa,alias);
        this.listaPlaca.add(nuevaPlaca);
        String jsonString = gson.toJson(listaPlaca);
        ////externoPrivado////
        File dirPics = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(dirPics,"listaPlacasJson.txt");
        IOHelper.writeToFile(f,jsonString);
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

    @Override
    public List<Placa> getAllPlaca(Context context) throws Exception {
        File dirPics = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(dirPics,"listaPlacasJson.txt");
        String jsonArray =IOHelper.stringFromFile(f);
        Type listType = new TypeToken<ArrayList<Placa>>(){}.getType();
        listaPlaca = gson.fromJson(jsonArray, listType);
        return listaPlaca;
    }
}
