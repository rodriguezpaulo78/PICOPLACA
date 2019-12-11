package com.proyectofinal.picoplaca.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.proyectofinal.picoplaca.Presenters.UsuarioImpl;
import com.proyectofinal.picoplaca.R;

import java.util.ArrayList;

public class ConPlacasHomeFragment extends Fragment {
    @Nullable


    //Listview
    private ListView listview;
    private ArrayList<UsuarioImpl> usuarios;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_conplacas, container, false);
        listview = (ListView) view.findViewById(R.id.ListPlacas);
        return view;
    }
}


