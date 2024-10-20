package com.example.reproductortabs;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class TabMusica extends Fragment {

    Button btnAtras, btnPlay, btnSiguiente;
    ImageView imgvPortada;

    //Creo un array de canciones
    MediaPlayer canciones [] = new MediaPlayer[3];
    int posCancion = 0;

    public TabMusica() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab_musica, container, false);

        //Hay que buscar los botones luego de inflar el fragment, sino devuelve null
        btnAtras = view.findViewById(R.id.btnAtras);
        btnPlay = view.findViewById(R.id.btnPlay);
        btnSiguiente = view.findViewById(R.id.btnSiguiente);
        imgvPortada = view.findViewById(R.id.imgvPortada);

        cargarCanciones();

        //Hay que crear el onclick desde aca porque sino no lo encuentra

        //Boton de play y pausa
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               play();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atras();
            }
        });

        return view;
    }


    public void play(){
        if(canciones[posCancion].isPlaying()){
            canciones[posCancion].pause();
            btnPlay.setBackgroundResource(R.drawable.play);
        }else{
            canciones[posCancion].start();
            btnPlay.setBackgroundResource(R.drawable.pausa);
        }
    }

    public void siguiente(){
        canciones[posCancion].stop();
        if(posCancion < canciones.length-1){
            posCancion++;
        }else{
            posCancion = 0;
        }
        //Cuando se usa .stop(), hay que cargar nuevamente las canciones
        cargarCanciones();

        canciones[posCancion].start();
        btnPlay.setBackgroundResource(R.drawable.pausa);
        switch (posCancion){
            case 0:
                imgvPortada.setImageResource(R.drawable.album_cosculluela);
            break;
            case 1:
                imgvPortada.setImageResource(R.drawable.album_ysy);
            break;
            case 2:
                imgvPortada.setImageResource(R.drawable.album_tuduofavorito);
            break;
        }
    }

    public void atras(){
        canciones[posCancion].stop();
        if(posCancion > 0){
            posCancion--;
        }else{
            posCancion = 2;
        }

        cargarCanciones();

        canciones[posCancion].start();
        btnPlay.setBackgroundResource(R.drawable.pausa);
        switch (posCancion){
            case 0:
                imgvPortada.setImageResource(R.drawable.album_cosculluela);
                break;
            case 1:
                imgvPortada.setImageResource(R.drawable.album_ysy);
                break;
            case 2:
                imgvPortada.setImageResource(R.drawable.album_tuduofavorito);
                break;
        }
    }

    public void cargarCanciones(){
        //Cargo las canciones
        canciones[0] = MediaPlayer.create(getContext(),R.raw.manicomio);
        canciones[1] = MediaPlayer.create(getContext(),R.raw.copenhague);
        canciones[2] = MediaPlayer.create(getContext(),R.raw.mi_ciudad);
    }

}