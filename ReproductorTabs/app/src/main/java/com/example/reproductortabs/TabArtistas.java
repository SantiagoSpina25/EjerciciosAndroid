package com.example.reproductortabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TabArtistas extends Fragment {

    Spinner spinner;
    TextView tvDescripcion;
    ImageView imgvArtista;


    public TabArtistas() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab_artistas, container, false);

        tvDescripcion = view.findViewById(R.id.tvDescripcion);
        imgvArtista = view.findViewById(R.id.imgvArtista);

        tvDescripcion.setText(getString(R.string.descripcion2pac));
        imgvArtista.setImageResource(R.drawable.foto2pac);

        spinner = view.findViewById(R.id.spinnerArtistas);

        //Creamos un array con los valores (cada artista) y lo pasamos a un ArrayAdapter
        ArrayList<String> itemsSpinner = new ArrayList<>();
        itemsSpinner.add("2pac");
        itemsSpinner.add("ysy a");
        itemsSpinner.add("bhavi");
        itemsSpinner.add("Cosculluela");
        itemsSpinner.add("Rodrigo");

        //El ArrayAdapter en Android es una clase que actúa como un "puente" entre una fuente de datos
        // (como un array o una lista) y un componente de interfaz de usuario (UI),
        // como un Spinner o un ListView, que necesita mostrar esos datos.

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getContext(), R.layout.spinner_item, itemsSpinner);
        adaptador.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adaptador);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String artistaSeleccionado = adapterView.getItemAtPosition(i).toString();

                switch (artistaSeleccionado) {
                    case "2pac":
                        tvDescripcion.setText(getString(R.string.descripcion2pac));
                        imgvArtista.setImageResource(R.drawable.foto2pac);
                        break;
                    case "ysy a":
                        tvDescripcion.setText(getString(R.string.descripcionYsya));
                        imgvArtista.setImageResource(R.drawable.ysya);
                        break;
                    case "bhavi":
                        tvDescripcion.setText(getString(R.string.descripcionBhavi));
                        imgvArtista.setImageResource(R.drawable.bhavi);
                        break;
                    case "Cosculluela":
                        tvDescripcion.setText(getString(R.string.descripcionCosculluela));
                        imgvArtista.setImageResource(R.drawable.cosculluela);
                        break;
                    case "Rodrigo":
                        tvDescripcion.setText(getString(R.string.descripcionCosculluela));
                        imgvArtista.setImageResource(R.drawable.rodrigo);
                        break;
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







        return view;
    }
}