package com.proyectofinal.picoplaca.Presenters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.proyectofinal.picoplaca.Interfaces.Usuario;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    UsuarioImpl u;
    ArrayList<UsuarioImpl> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, mail text)";

    public daoUsuario(Context c){
        this.c = c;
        //se crea la BD
        sql = c.openOrCreateDatabase(bd,c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new UsuarioImpl();
    }

    public boolean insertUsuario(UsuarioImpl u){
        if(buscar(u.getUsuario())==0){
            ContentValues cv = new ContentValues();
            cv.put("usuario",u.getUsuario());
            cv.put("pass",u.getPassword());
            cv.put("nombre",u.getNombre());
            cv.put("mail",u.getCorreo());
            return (sql.insert("usuario",null,cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String u){
        int x = 0;
        lista = selectUsuarios();
        for (Usuario us:lista) {
            if(us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<UsuarioImpl> selectUsuarios(){
        ArrayList<UsuarioImpl> lista = new ArrayList<UsuarioImpl>();
        Cursor cr= sql.rawQuery("select * from usuario", null);
        lista.clear();
        if(cr!=null&&cr.moveToFirst()){
            do{
                UsuarioImpl u = new UsuarioImpl();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setCorreo(cr.getString(4));
                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }

    //Busca en la bd el usuario registrado para logearse
    public int login(String u, String p){
        int a = 0;
        Cursor cr= sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while(cr.moveToNext());
        }
        return a;
    }
    
    public UsuarioImpl getUsuario(String u, String p){
        lista = selectUsuarios();
        for (UsuarioImpl us:lista) {
            if(us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }

    public UsuarioImpl getUsuarioById(int id){
        lista = selectUsuarios();
        for (UsuarioImpl us:lista) {
            if(us.getId()==id){
                return us;
            }
        }
        return null;
    }


}

