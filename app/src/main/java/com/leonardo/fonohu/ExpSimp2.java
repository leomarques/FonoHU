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

@EFragment(R.layout.frag_exp_simp2)
public class ExpSimp2 extends Fragment {

    public static final int TEMPO_CONTORNO = 2000;
    public static final int QOBJETOS = 4;

    @ViewById
    public ImageView btnDarTchau, btnAponta, btnPegaPe, btnMandaBeijo, btnSeguir;

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
        sons[3] = R.raw.bird;

        imgViews = new ImageView[QOBJETOS];
        imgViews[0] = btnDarTchau;
        imgViews[1] = btnAponta;
        imgViews[2] = btnPegaPe;
        imgViews[3] = btnMandaBeijo;

        imagens = new int[QOBJETOS * 3];
        imagens[0] = R.drawable.dar_tchau;
        imagens[1] = R.drawable.aponta;
        imagens[2] = R.drawable.pega_pe;
        imagens[3] = R.drawable.manda_beijo;
        imagens[4] = R.drawable.dar_tchau_acerto;
        imagens[5] = R.drawable.aponta_acerto;
        imagens[6] = R.drawable.pega_pe_acerto;
        imagens[7] = R.drawable.beijo_acerto;
        imagens[8] = R.drawable.dar_tchau_erro;
        imagens[9] = R.drawable.aponta_erro;
        imagens[10] = R.drawable.pega_pe_erro;
        imagens[11] = R.drawable.beijo_erro;

        h = new Handler();
        somAtual = 0;
        App.inst().tocar(sons[somAtual]);
    }

    @Click
    public void btnDarTchau() {
        clicado(0);
    }

    @Click
    public void btnAponta() {
        clicado(1);
    }

    @Click
    public void btnPegaPe() {
        clicado(2);
    }

    @Click
    public void btnMandaBeijo() {
        clicado(3);
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
                App.inst().tocar(R.raw.win);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < QOBJETOS; i++)
                            imgViews[i].setVisibility(View.GONE);

                        btnSeguir.setVisibility(View.VISIBLE);
                    }
                }, TEMPO_CONTORNO);

            } else {
                Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
                App.inst().tocar(R.raw.win, sons[++somAtual]);
            }
        } else {
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS * 2]);
            App.inst().tocar(R.raw.lose, sons[somAtual]);
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
