package com.leonardo.fonohu;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_exp_simp1)
public class ExpSimp1 extends Fragment {
    public static final int TEMPO_ANIMACAO = 500;

    @ViewById
    ImageView btnMaoCabeca, btnPegaPe, btnDarTchau, btnMandaBeijo, menino, btnOk;

    private Handler h;
    boolean s;

    @AfterViews
    public void aoCriar() {
        h = new Handler();

        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        s = pref.getBoolean("sexo", true);
        Log.i("jabaliano", "" + s);

        menino.setImageResource(s ? R.drawable.menino_normal : R.drawable.menina_normal);
    }

    @Click
    public void btnMaoCabeca() {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.menino_mao_cabeca : R.drawable.menina_aponta);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino_normal : R.drawable.menina_normal);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnPegaPe() {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.menino_pega_pe : R.drawable.menina_pega_pe);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino_normal : R.drawable.menina_normal);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnDarTchau() {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.menino_dar_tchau : R.drawable.menina_dar_tchau);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino_normal : R.drawable.menina_normal);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnMandaBeijo() {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(s ? R.drawable.menino_beijo : R.drawable.menina_manda_beijo);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(s ? R.drawable.menino_normal : R.drawable.menina_normal);
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
