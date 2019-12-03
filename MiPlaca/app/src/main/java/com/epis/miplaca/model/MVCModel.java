package com.epis.miplaca.model;

import android.content.Context;

import com.epis.miplaca.model.bean.Placa;

import java.util.List;

public interface MVCModel {
    public boolean addPlaca(Context context, String alias, String placa) throws Exception;
    public boolean removePlaca(int id) throws Exception;
    public boolean modifyPlaca(int id, String newToDoValuel) throws Exception;
    public List<Placa> getAllPlaca() throws Exception;
}
