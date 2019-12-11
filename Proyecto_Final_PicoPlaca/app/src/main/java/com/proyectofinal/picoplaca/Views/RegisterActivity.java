package com.proyectofinal.picoplaca.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyectofinal.picoplaca.Presenters.UsuarioImpl;
import com.proyectofinal.picoplaca.Presenters.daoUsuario;
import com.proyectofinal.picoplaca.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText us,pas,nom,mail;
    Button reg,can;
    daoUsuario dao;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        us = (EditText) findViewById(R.id.reg_user);
        pas = (EditText) findViewById(R.id.reg_pass);
        nom = (EditText) findViewById(R.id.reg_nom);
        mail = (EditText) findViewById(R.id.reg_mail);

        reg = (Button) findViewById(R.id.buttonRegRegistrar);
        can = (Button) findViewById(R.id.buttonCancelar);;
        //Inicio de sesion
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao = new daoUsuario(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonRegRegistrar:
                UsuarioImpl u = new UsuarioImpl();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setCorreo(mail.getText().toString());

                //Validar los valores
                if(!u.isNull()){
                    Toast.makeText(this,"ERROR, CAMPOS VACIOS",Toast.LENGTH_LONG).show();

                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.buttonCancelar:
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
