package com.proyectofinal.picoplaca.Interactors.bean;

import androidx.annotation.NonNull;

public class Placa {
    private String placa;
    private String alias;

    public Placa(String placa, String alias) {
        this.placa = placa;
        this.alias = alias;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @NonNull
    @Override
    public String toString() {
        return placa+" "+alias;
    }
}
