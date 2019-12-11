package com.epis.miplaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import com.epis.miplaca.controller.MVCController;
import com.epis.miplaca.view.CopiaSeguridad;
import com.epis.miplaca.view.ListarPlacas;
import com.epis.miplaca.view.MainActivityViewImplementor;

public class MainActivity extends AppCompatActivity {
    MainActivityViewImplementor mvcView;
    MVCController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mvcView = new MainActivityViewImplementor(MainActivity.this,null);


        setContentView(mvcView.getRootView());
        controller = mvcView.getMvcController();

        mvcView.initViews(this);


    }
    @Override
    protected void onResume() {
        super.onResume();
        mvcView.bindDataToView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.listar:

                Intent intent = new Intent(MainActivity.this, ListarPlacas.class);

                startActivityForResult(intent,0);
                Toast.makeText(this,R.string.listar, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.copia:
                Intent intent_copia = new Intent(MainActivity.this, CopiaSeguridad.class);
                startActivityForResult(intent_copia,0);

                return(true);
            case R.id.cargar:

                Toast.makeText(this, R.string.cargar, Toast.LENGTH_LONG).show();
                return(true);

        }
        return super.onOptionsItemSelected(item);
    }
}
