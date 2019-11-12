package com.epis.miplaca.view;

import com.epis.miplaca.model.bean.Placa;

import java.util.List;

public interface MVCMainActivityView extends MVCView {
    public void bindDataToView();
    public void showErrorToast(String errorMessage);
    public void updateViewOnRegister(List<Placa> placa);
}
