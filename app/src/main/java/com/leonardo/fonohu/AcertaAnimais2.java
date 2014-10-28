package com.leonardo.fonohu;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_acerta_animais1)
public class AcertaAnimais2 extends Fragment {

    @ViewById
    ImageView dog, cat, bird;

    @ViewById
    ImageView btnSeguir;

    MediaPlayer mp;

    int[] sons;
    int somAtual;

    @AfterViews
    public void aoCriar() {
        sons = new int[3];
        sons[0] = R.raw.dog;
        sons[1] = R.raw.cat;
        sons[2] = R.raw.bird;

        somAtual = 0;
        tocar(sons[somAtual]);
        Toast.makeText(getActivity(), R.string.qualanimal, Toast.LENGTH_SHORT).show();
    }

    @Click
    public void dog() {
        clicado(0);
    }

    @Click
    public void cat() {
        clicado(1);
    }

    @Click
    public void bird() {
        clicado(2);
    }

    @Click
    public void btnSeguir() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }

    public void clicado(int animal) {
        if (animal == somAtual) {
            if (somAtual == 2) {
                Toast.makeText(getActivity(), R.string.parabens, Toast.LENGTH_SHORT).show();
                tocar(R.raw.win);

                dog.setVisibility(View.INVISIBLE);
                cat.setVisibility(View.INVISIBLE);
                bird.setVisibility(View.INVISIBLE);

                btnSeguir.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
                tocar(sons[++somAtual]);
            }
        } else {
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
            tocar(sons[somAtual]);
        }
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
