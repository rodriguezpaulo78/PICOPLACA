package com.epis.miplaca.view;

import android.content.Context;
import android.view.View;

public interface MVCView {
    public View getRootView();
    public void initViews(Context context);
}
