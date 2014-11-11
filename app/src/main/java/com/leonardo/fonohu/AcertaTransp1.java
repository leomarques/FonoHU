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

@EFragment(R.layout.frag_acerta_transp1)
public class AcertaTransp1 extends Fragment {

    public static final int TEMPO_CONTORNO = 2000;
    public static final int QOBJETOS = 2;

    @ViewById
    ImageView carro, moto;

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

        imgViews = new ImageView[QOBJETOS];
        imgViews[0] = carro;
        imgViews[1] = moto;

        imagens = new int[QOBJETOS * 3];
        imagens[0] = R.drawable.carro;
        imagens[1] = R.drawable.moto;
        imagens[2] = R.drawable.carro_acerto;
        imagens[3] = R.drawable.moto_acerto;
        imagens[4] = R.drawable.carro_erro;
        imagens[5] = R.drawable.moto_erro;

        h = new Handler();
        somAtual = 0;
        App.inst().tocar(sons[somAtual]);
        Toast.makeText(getActivity(), R.string.qual_transp, Toast.LENGTH_SHORT).show();
    }

    @Click
    public void carro() {
        clicado(0);
    }

    @Click
    public void moto() {
        clicado(1);
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
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS * 2]);
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
            App.inst().tocar(R.raw.lose, sons[somAtual]);
        }
    }

    @Click
    public void btnSeguir() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaTransp2_()).commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        h.removeCallbacksAndMessages(null);
    }
}
