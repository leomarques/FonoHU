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

@EFragment(R.layout.frag_acerta_animais2)
public class AcertaAnimais2 extends Fragment {

    private final int TEMPO_CONTORNO = 2000;
    private final int QOBJETOS = 3;

    @ViewById
    ImageView vaca, cavalo, galinha, btnSeguir, joinha;

    private int[] sons, imagens;
    private ImageView[] imgViews;
    private int somAtual;
    private Handler h;

    @AfterViews
    public void aoCriar() {
        sons = new int[QOBJETOS];
        sons[0] = R.raw.vaca;
        sons[1] = R.raw.cavalo;
        sons[2] = R.raw.galinha;

        imgViews = new ImageView[QOBJETOS];
        imgViews[0] = vaca;
        imgViews[1] = cavalo;
        imgViews[2] = galinha;

        imagens = new int[QOBJETOS * 3];
        imagens[0] = R.drawable.vaca;
        imagens[1] = R.drawable.cavalo;
        imagens[2] = R.drawable.galo;
        imagens[3] = R.drawable.vaca_acerto;
        imagens[4] = R.drawable.cavalo_acerto;
        imagens[5] = R.drawable.galo_acerto;
        imagens[6] = R.drawable.vaca_erro;
        imagens[7] = R.drawable.cavalo_erro;
        imagens[8] = R.drawable.galo_erro;

        h = new Handler();
        somAtual = 0;
        App.inst().tocar(sons[somAtual]);
        Toast.makeText(getActivity(), R.string.qualanimal, Toast.LENGTH_SHORT).show();
    }

    @Click
    void vaca() {
        clicado(0);
    }

    @Click
    void cavalo() {
        clicado(1);
    }

    @Click
    void galinha() {
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
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais3_()).commit();
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
