package com.proyectofinal.picoplaca.Interactors;

public class Poligono {
    double x1,y1, x2, y2;

    public Poligono(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public boolean contains(double x, double y){
        if (x > x2 && x < x1 && y > y2 && y < y1){
            return true;
        }else{
            return false;
        }
    }
}