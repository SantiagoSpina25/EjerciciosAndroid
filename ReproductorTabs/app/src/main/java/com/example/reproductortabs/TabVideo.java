package com.example.reproductortabs;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class TabVideo extends Fragment {

    public TabVideo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        cargarVideo(getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab_video, container, false);
        cargarVideo(view);

        return view;
    }


    public void cargarVideo(View view){
        VideoView video = view.findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.nugget;
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);
        video.setMediaController(new MediaController(view.getContext()));
        video.start();


        //Controlo si el video tira un error
        video.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(view.getContext(), "Error al cargar el vídeo", Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
}