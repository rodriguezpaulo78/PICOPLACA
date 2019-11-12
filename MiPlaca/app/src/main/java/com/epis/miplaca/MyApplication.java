package com.epis.miplaca;

import android.app.Application;

import com.epis.miplaca.model.db.ToDoListDBAdapter;

public class MyApplication extends Application {
    static ToDoListDBAdapter toDoListDBAdapter;

    @Override
    public void onCreate() {
        super.onCreate();
        toDoListDBAdapter = ToDoListDBAdapter.getToDoListDBAdapterInstance(this);
    }

    public static ToDoListDBAdapter getToDoListDBAdapter() {
        return toDoListDBAdapter;
    }
}
