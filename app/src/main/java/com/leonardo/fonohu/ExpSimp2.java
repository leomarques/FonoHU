package com.leonardo.fonohu;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_exp_simp2)
public class ExpSimp2 extends Fragment {

    private static final int TEMPO_CONTORNO = 2000;
    private static final int QOBJETOS = 4;

    @ViewById
    ImageView btnDarTchau, btnAponta, btnPegaPe, btnMandaBeijo, btnSeguir;

    private int[] sons, imagens;
    private ImageView[] imgViews;
    private int somAtual;
    private Handler h;
    private boolean s;

    @AfterViews
    public void aoCriar() {
        sons = new int[QOBJETOS * 2];
        sons[0] = R.raw.dar_tchau_o;
        sons[1] = R.raw.aponte_cabeca_o;
        sons[2] = R.raw.pegue_pe_o;
        sons[3] = R.raw.mande_beijo_o;
        sons[4] = R.raw.dar_tchau_a;
        sons[5] = R.raw.aponte_cabeca_a;
        sons[6] = R.raw.pegue_pe_a;
        sons[7] = R.raw.mande_beijo_a;

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

        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        s = pref.getBoolean("sexo", true);

        somAtual = 0;
        App.inst().tocar(s ? sons[somAtual] : sons[somAtual + QOBJETOS]);
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

    private void clicado(final int objeto) {
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
                somAtual++;
                App.inst().tocar(R.raw.win, s ? sons[somAtual] : sons[somAtual + QOBJETOS]);
            }
        } else {
            imgViews[objeto].setImageResource(imagens[objeto + QOBJETOS * 2]);
            App.inst().tocar(R.raw.lose, s ? sons[somAtual] : sons[somAtual + QOBJETOS]);
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
