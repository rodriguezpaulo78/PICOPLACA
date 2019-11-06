package com.epis.miplaca;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ListarPlacas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_placas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.caminar:
                Toast.makeText(this,R.string.caminar, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.agregar:
                Intent intent = new Intent(ListarPlacas.this, MainActivity.class);
                startActivityForResult(intent,0);
                Toast.makeText(this,R.string.agregar, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.buscar:
                return(true);
            case R.id.borrar:
                /*SOlo esta para probar la alerta luego debe ser automatico*/
                Intent intent_alerta = new Intent(ListarPlacas.this, Alerta.class);
                startActivityForResult(intent_alerta,0);
                Toast.makeText(this, R.string.borrar, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.copia:
                Toast.makeText(this, R.string.copia, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.cargar:
                Toast.makeText(this, R.string.cargar, Toast.LENGTH_LONG).show();
                return(true);

        }
        return super.onOptionsItemSelected(item);
    }

}
