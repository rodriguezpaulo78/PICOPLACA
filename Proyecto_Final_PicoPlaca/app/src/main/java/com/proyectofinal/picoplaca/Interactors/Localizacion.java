package com.proyectofinal.picoplaca.Interactors;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

import com.proyectofinal.picoplaca.Views.HomeActivity;

public class Localizacion implements LocationListener {

    //Se pone con la clase que se va trabajar HOMEACTIVITY POR EL MOMENTO
    HomeActivity homeActivity;
    public boolean alertaX = false;
    public HomeActivity getMainActivity() {
        return homeActivity;
    }
    public void setHomeActivity(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Override
    public void onLocationChanged(Location loc) {
        // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
        // debido a la deteccion de un cambio de ubicacion
        loc.getLatitude();
        loc.getLongitude();
        if (alertaG(loc.getLatitude(), loc.getLongitude()) == true) {
            alertaX = true;
        } else {
            alertaX = false;
        }

    }
    public boolean alertaActiva() {
        return alertaX;
    }

    public boolean alertaG(double latitude, double longitude) {
        Poligono plazaArm = new Poligono(-16.405879, -71.547012, -16.398160, -71.523065);
        if (plazaArm.contains(latitude, longitude)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Este metodo se ejecuta cuando el GPS es desactivad
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Este metodo se ejecuta cuando el GPS es activad
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d("debug", "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
    }
}