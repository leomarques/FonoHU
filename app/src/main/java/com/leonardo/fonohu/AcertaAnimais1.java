package com.leonardo.fonohu;

import android.app.Fragment;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_acerta_animais1)
public class AcertaAnimais1 extends Fragment {

    private static final int TEMPO_CONTORNO = 2000;
    private static final int QOBJETOS = 3;

    @ViewById
    ImageView cachorro, gato, passaro, btnSeguir, joinha;

    private int[] sons, imagens;
    private ImageView[] imgViews;
    private int somAtual;
    private Handler h;

    @AfterViews
    public void aoCriar() {
        sons = new int[QOBJETOS];
        sons[0] = R.raw.dog;
        sons[1] = R.raw.cat;
        sons[2] = R.raw.bird;

        imgViews = new ImageView[QOBJETOS];
        imgViews[0] = cachorro;
        imgViews[1] = gato;
        imgViews[2] = passaro;

        imagens = new int[QOBJETOS * 3];
        imagens[0] = R.drawable.cachorro;
        imagens[1] = R.drawable.gato;
        imagens[2] = R.drawable.passaro;
        imagens[3] = R.drawable.cachorro_acerto;
        imagens[4] = R.drawable.gato_acerto;
        imagens[5] = R.drawable.passaro_acerto;
        imagens[6] = R.drawable.cachorro_erro;
        imagens[7] = R.drawable.gato_erro;
        imagens[8] = R.drawable.passaro_erro;

        h = new Handler();
        somAtual = 0;
        App.inst().tocar(sons[somAtual]);
        Toast.makeText(getActivity(), R.string.qualanimal, Toast.LENGTH_SHORT).show();
    }

    @Click
    public void cachorro() {
        clicado(0);
    }

    @Click
    public void gato() {
        clicado(1);
    }

    @Click
    public void passaro() {
        clicado(2);
    }

    void clicado(final int objeto) {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                joinha.setVisibility(View.GONE);
            }
        }, TEMPO_CONTORNO);

        if (objeto == somAtual) {
            joinha.setImageResource(R.drawable.like);
            joinha.setVisibility(View.VISIBLE);

            if (somAtual == QOBJETOS - 1) {
                Toast.makeText(getActivity(), R.string.parabens, Toast.LENGTH_SHORT).show();
                App.inst().tocar(R.raw.win);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < QOBJETOS; i++)
                            imgViews[i].setVisibility(View.INVISIBLE);

                        btnSeguir.setVisibility(View.VISIBLE);
                    }
                }, TEMPO_CONTORNO);

            } else {
                Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
                App.inst().tocar(R.raw.win, sons[++somAtual]);
            }
        } else {
            joinha.setImageResource(R.drawable.dislike);
            joinha.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
            App.inst().tocar(R.raw.lose, sons[somAtual]);
        }
    }

    @Click
    public void btnSeguir() {
        btnSeguir.setImageResource(R.drawable.btn_seguir_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais2_()).commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        h.removeCallbacksAndMessages(null);
    }

    @Click
    public void repetir() {
        App.inst().tocar(sons[somAtual]);
    }
}
