package com.epis.miplaca.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.epis.miplaca.MainActivity;
import com.epis.miplaca.R;
import com.epis.miplaca.controller.MVCController;

public class ListarPlacas extends AppCompatActivity {
    ImageView img;
    String result = "";
    MVCController controlador = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_placas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        controlador = MVCController.getControlador();
        //controlador.setListarPlacas(this);


        img = (ImageView) findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("vista 2 click: ", result);
                result = controlador.pruebaController(ListarPlacas.this);

                listarPlacas();
                //controlador.getListarPlacas().listarPlacas();
            }
        });




    }
    public String listarPlacas() {
        Log.v("vista 2 final", result);
        Toast.makeText(this,result, Toast.LENGTH_LONG).show();
        return "ListarPlaca";
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
