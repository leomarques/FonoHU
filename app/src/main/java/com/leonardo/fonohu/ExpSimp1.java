package com.leonardo.fonohu;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_exp_simp1)
public class ExpSimp1 extends Fragment {
    private static final int TEMPO_ANIMACAO = 500;

    @ViewById
    ImageView btnMaoCabeca, btnPegaPe, btnDarTchau, btnMandaBeijo, menino, btnOk;

    private boolean s;
    private Handler h;

    @AfterViews
    public void aoCriar() {
        h = new Handler();

        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        s = pref.getBoolean("sexo", true);

        menino.setImageResource(s ? R.drawable.menino : R.drawable.menina);
    }

    @Click
    public void btnMaoCabeca() {
        App.inst().tocar(s ? R.raw.aponte_cabeca_o : R.raw.aponte_cabeca_a);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.aponta_o : R.drawable.aponta_a);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino : R.drawable.menina);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnPegaPe() {
        App.inst().tocar(s ? R.raw.pegue_pe_o : R.raw.pegue_pe_a);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.pega_pe_o : R.drawable.pega_pe_a);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino : R.drawable.menina);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnDarTchau() {
        App.inst().tocar(s ? R.raw.dar_tchau_o : R.raw.dar_tchau_a);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.dar_tchau_o : R.drawable.dar_tchau_a);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino : R.drawable.menina);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnMandaBeijo() {
        App.inst().tocar(s ? R.raw.mande_beijo_o : R.raw.mande_beijo_a);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.manda_beijo_o : R.drawable.manda_beijo_a);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino : R.drawable.menina);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new ExpSimp2_()).commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        h.removeCallbacksAndMessages(null);
    }
}
