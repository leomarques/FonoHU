package com.leonardo.fonohu;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais)
public class ApresentaAnimais extends Fragment {

    @ViewById
    ImageView dog, cat, bird, texto;

    @ViewById
    Button btn;

    MediaPlayer mp;

    @Click
    public void dog() {
        tocar(R.raw.dog);
    }

    @Click
    public void cat() {
        tocar(R.raw.cat);
    }

    @Click
    public void bird() {
        tocar(R.raw.bird);
    }

    private void tocar(int som) {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

        mp = MediaPlayer.create(getActivity(), som);
        mp.start();
    }

    @Click
    public void btn() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais_()).addToBackStack(null).commit();
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
