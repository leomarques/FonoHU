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

@EFragment(R.layout.frag_acerta_animais5)
public class AcertaAnimais5 extends Fragment {

    public static final int TEMPO_CONTORNO = 2000;
    public static final int QOBJETOS = 3;

    @ViewById
    ImageView macaco, sapo, lobo;

    @ViewById
    ImageView btnSeguir;

    int[] sons, imagens;
    ImageView[] imgViews;
    int somAtual;
    private Handler h;

    @AfterViews
    public void aoCriar() {
        sons = new int[QOBJETOS];
        sons[0] = R.raw.dog;
        sons[1] = R.raw.cat;
        sons[2] = R.raw.bird;

        imgViews = new ImageView[QOBJETOS];
        imgViews[0] = macaco;
        imgViews[1] = sapo;
        imgViews[2] = lobo;

        imagens = new int[QOBJETOS * 3];
        imagens[0] = R.drawable.macaco;
        imagens[1] = R.drawable.sapo;
        imagens[2] = R.drawable.lobo;
        imagens[3] = R.drawable.macaco_acerto;
        imagens[4] = R.drawable.sapo_acerto;
        imagens[5] = R.drawable.lobo_acerto;
        imagens[6] = R.drawable.macaco_erro;
        imagens[7] = R.drawable.sapo_erro;
        imagens[8] = R.drawable.lobo_erro;

        h = new Handler();
        somAtual = 0;
        App.inst().tocar(sons[somAtual]);
        Toast.makeText(getActivity(), R.string.qualanimal, Toast.LENGTH_SHORT).show();
    }

    @Click
    public void macaco() {
        clicado(0);
    }

    @Click
    public void sapo() {
        clicado(1);
    }

    @Click
    public void lobo() {
        clicado(2);
    }

    public void clicado(final int objeto) {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgViews[objeto].setImageResource(imagens[objeto]);
            }
        }, TEMPO_CONTORNO);

        if (objeto == somAtual) {
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS]);

            if (somAtual == QOBJETOS - 1) {
                Toast.makeText(getActivity(), R.string.parabens, Toast.LENGTH_SHORT).show();
                App.inst().tocar(R.raw.win);

                for (int i = 0; i < QOBJETOS; i++)
                    imgViews[i].setVisibility(View.INVISIBLE);

                btnSeguir.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
                App.inst().tocar(R.raw.win, sons[++somAtual]);
            }
        } else {
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS * 2]);
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
            App.inst().tocar(R.raw.lose, sons[somAtual]);
        }
    }

    @Click
    public void btnSeguir() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        h.removeCallbacksAndMessages(null);
    }
}
