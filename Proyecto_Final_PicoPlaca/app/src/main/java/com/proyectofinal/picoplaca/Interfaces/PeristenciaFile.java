package com.proyectofinal.picoplaca.Interfaces;

import android.content.Context;

import com.proyectofinal.picoplaca.Interactors.bean.Placa;

import java.util.List;

public interface PeristenciaFile {
    public boolean addPlaca(Context context, String alias, String placa) throws Exception;
    public boolean removePlaca(int id) throws Exception;
    public boolean modifyPlaca(int id, String newToDoValuel) throws Exception;
    public List<Placa> getAllPlaca(Context context) throws Exception;
}
