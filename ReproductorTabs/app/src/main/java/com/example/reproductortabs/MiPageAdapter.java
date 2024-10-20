package com.example.reproductortabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiPageAdapter extends FragmentStateAdapter {
    public MiPageAdapter(MainActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TabHome();
            case 1:
                return new TabFavoritos();
            case 2:
                return new TabMusica();
            default:
                return new TabVideo();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
