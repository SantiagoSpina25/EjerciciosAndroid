package com.example.reproductortabs;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class TabMusica extends Fragment {

    Button btnAtras, btnPlay, btnSiguiente;
    ImageView imgvPortada;
    SeekBar seekBar;
    TextView tvDuracionCancion, tvDuracionTotalCancion;
    private Handler handler = new Handler();
    //Creo un array de canciones
    MediaPlayer[] canciones = new MediaPlayer[5];
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
        seekBar = view.findViewById(R.id.seekBar);
        tvDuracionCancion = view.findViewById(R.id.duracionCancion);
        tvDuracionTotalCancion = view.findViewById(R.id.duracionTotalCancion);
        seekBar.setProgress(0);

        cargarCanciones();
        imgvPortada.setImageResource(R.drawable.album_2pac);

        //getDuration() devuelve la duración en milisegundos, por lo que dividimos entre 1000 para que coincida
        // con el valor del SeekBar, que maneja segundos.
        seekBar.setMax(canciones[posCancion].getDuration()/1000);
        tvDuracionTotalCancion.setText(formattedTime(seekBar.getMax()));
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

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //Este método se llama cada vez que cambia la posición del SeekBar.
            // Si el cambio lo hace el usuario (fromUser == true), el código actualiza la posición de la canción
            // al valor actual del SeekBar, multiplicado por 1000 para convertir a milisegundos.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean fromUser) {
                if(canciones[posCancion] != null && fromUser){
                    canciones[posCancion].seekTo(progreso * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Este bloque ejecuta un Runnable en el hilo principal que se encarga de actualizar el progreso del SeekBar cada segundo.
        getActivity().runOnUiThread(new Runnable() {
            //Runnable solo define la tarea a realizar
            @Override
            public void run() {
                if(canciones[posCancion] != null){
                    int posicionActual = canciones[posCancion].getCurrentPosition() / 1000;
                    seekBar.setProgress(posicionActual);
                    tvDuracionCancion.setText(formattedTime(posicionActual));
                }
                //Esta línea vuelve a llamar al Runnable después de un segundo, creando un bucle de actualización cada segundo.
                handler.postDelayed(this,1000);
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
        seekBar.setMax(canciones[posCancion].getDuration()/1000);
        tvDuracionTotalCancion.setText(formattedTime(seekBar.getMax()));
        switch (posCancion){
            case 0:
                imgvPortada.setImageResource(R.drawable.album_2pac);
                break;
            case 1:
                imgvPortada.setImageResource(R.drawable.album_ysy);
                break;
            case 2:
                imgvPortada.setImageResource(R.drawable.album_tuduofavorito);
                break;
            case 3:
                imgvPortada.setImageResource(R.drawable.album_cosculluela);
                break;
            case 4:
                imgvPortada.setImageResource(R.drawable.album_rodrigo);
                break;
        }
    }

    public void atras(){
        canciones[posCancion].stop();
        if(posCancion > 0){
            posCancion--;
        }else{
            posCancion = canciones.length - 1;
        }

        cargarCanciones();

        canciones[posCancion].start();
        btnPlay.setBackgroundResource(R.drawable.pausa);
        seekBar.setMax(canciones[posCancion].getDuration()/1000);
        tvDuracionTotalCancion.setText(formattedTime(seekBar.getMax()));
        switch (posCancion){
            case 0:
                imgvPortada.setImageResource(R.drawable.album_2pac);
                break;
            case 1:
                imgvPortada.setImageResource(R.drawable.album_ysy);
                break;
            case 2:
                imgvPortada.setImageResource(R.drawable.album_tuduofavorito);
                break;
            case 3:
                imgvPortada.setImageResource(R.drawable.album_cosculluela);
                break;
            case 4:
                imgvPortada.setImageResource(R.drawable.album_rodrigo);
                break;
        }
    }

    public void cargarCanciones(){
        //Cargo las canciones
        canciones[0] = MediaPlayer.create(getContext(),R.raw.ambitionz);
        canciones[1] = MediaPlayer.create(getContext(),R.raw.copenhague);
        canciones[2] = MediaPlayer.create(getContext(),R.raw.mi_ciudad);
        canciones[3] = MediaPlayer.create(getContext(),R.raw.manicomio);
        canciones[4] = MediaPlayer.create(getContext(),R.raw.la_mano_de_dios);
    }

    private String formattedTime(int posicionActual){
        String totalOut = "";
        String totalNew = "";
        String segundos = String.valueOf(posicionActual % 60);
        String minutos = String.valueOf(posicionActual / 60);
        totalOut = minutos + ":" + segundos;
        totalNew = minutos + ":0" + segundos;
        if(segundos.length() == 1){
            return totalNew;
        }else{
            return totalOut;
        }

    }

}