package com.leonardo.fonohu;

import android.app.Fragment;
import android.content.SharedPreferences;
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
        imagens[4] = R.drawable.porco_amarelo_acerto;
        imagens[5] = R.drawable.porco_azul_acerto;
        imagens[6] = R.drawable.porco_verde_acerto;
        imagens[7] = R.drawable.porco_vermelho_acerto;
        imagens[8] = R.drawable.porco_amarelo_erro;
        imagens[9] = R.drawable.porco_azul_erro;
        imagens[10] = R.drawable.porco_verde_erro;
        imagens[11] = R.drawable.porco_vermelho_erro;

        h = new Handler();

        r = new Random().nextInt(4);

        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        boolean s = pref.getBoolean("sexo", true);

        if (s) {
            switch (r) {
                case 0:
                    App.inst().tocar(R.raw.aponte_o, R.raw.o_o, R.raw.porco_o, R.raw.amarelo_o);
                    break;
                case 1:
                    App.inst().tocar(R.raw.aponte_o, R.raw.o_o, R.raw.porco_o, R.raw.azul_o);
                    break;
                case 2:
                    App.inst().tocar(R.raw.aponte_o, R.raw.o_o, R.raw.porco_o, R.raw.verde_o);
                    break;
                case 3:
                    App.inst().tocar(R.raw.aponte_o, R.raw.o_o, R.raw.porco_o, R.raw.vermelho_o);
                    break;

            }
        } else {
            switch (r) {
                case 0:
                    App.inst().tocar(R.raw.aponte_a, R.raw.o_a, R.raw.porco_a, R.raw.amarelo_a);
                    break;
                case 1:
                    App.inst().tocar(R.raw.aponte_a, R.raw.o_a, R.raw.porco_a, R.raw.azul_a);
                    break;
                case 2:
                    App.inst().tocar(R.raw.aponte_a, R.raw.o_a, R.raw.porco_a, R.raw.verde_a);
                    break;
                case 3:
                    App.inst().tocar(R.raw.aponte_a, R.raw.o_a, R.raw.porco_a, R.raw.vermelho_a);
                    break;

            }
        }
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
