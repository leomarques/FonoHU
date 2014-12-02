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

import java.util.Random;

@EFragment(R.layout.frag_cor_animal)
public class CorPorco extends Fragment {

    public static final int TEMPO_CONTORNO = 2000;
    public static final int QOBJETOS = 4;

    @ViewById
    ImageView imageView, imageView2, imageView3, imageView4, btnSeguir;

    int[] sons, imagens;
    ImageView[] imgViews;
    int r;
    private Handler h;

    @AfterViews
    public void aoCriar() {
        imageView.setImageResource(R.drawable.porco_amarelo);
        imageView2.setImageResource(R.drawable.porco_azul);
        imageView3.setImageResource(R.drawable.porco_verde);
        imageView4.setImageResource(R.drawable.porco_vermelho);

        imgViews = new ImageView[QOBJETOS];
        imgViews[0] = imageView;
        imgViews[1] = imageView2;
        imgViews[2] = imageView3;
        imgViews[3] = imageView4;

        imagens = new int[QOBJETOS * 3];
        imagens[0] = R.drawable.porco_amarelo;
        imagens[1] = R.drawable.porco_azul;
        imagens[2] = R.drawable.porco_verde;
        imagens[3] = R.drawable.porco_vermelho;
        imagens[4] = R.drawable.porco_amarelo;
        imagens[5] = R.drawable.porco_azul;
        imagens[6] = R.drawable.porco_verde;
        imagens[7] = R.drawable.porco_vermelho;
        imagens[8] = R.drawable.porco_amarelo;
        imagens[9] = R.drawable.porco_azul;
        imagens[10] = R.drawable.porco_verde;
        imagens[11] = R.drawable.porco_vermelho;

        h = new Handler();

        r = new Random().nextInt(4);
    }

    @Click
    public void imageView() {
        clicado(0);
    }

    @Click
    public void imageView2() {
        clicado(1);
    }

    @Click
    public void imageView3() {
        clicado(2);
    }

    @Click
    public void imageView4() {
        clicado(3);
    }

    private void clicado(final int objeto) {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgViews[objeto].setImageResource(imagens[objeto]);
            }
        }, TEMPO_CONTORNO);

        if (objeto == r) {
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS]);

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
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS * 2]);
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
            App.inst().tocar(R.raw.lose);
        }
    }

    @Click
    public void btnSeguir() {
        btnSeguir.setImageResource(R.drawable.btn_seguir_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        h.removeCallbacksAndMessages(null);
    }
}
