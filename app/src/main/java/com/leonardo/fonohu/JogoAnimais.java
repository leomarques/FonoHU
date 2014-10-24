package com.leonardo.fonohu;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais)
public class JogoAnimais extends Fragment {

    @ViewById
    ImageView dog, cat, bird;

    MediaPlayer mp;

    @Click
    public void dog() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

        mp = MediaPlayer.create(getActivity(), R.raw.dog);
        mp.start();
    }

    @Click
    public void cat() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

        mp = MediaPlayer.create(getActivity(), R.raw.cat);
        mp.start();
    }

    @Click
    public void bird() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

        mp = MediaPlayer.create(getActivity(), R.raw.bird);
        mp.start();
    }

    @Override
    public void onDestroyView() {
        super.onPause();
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
