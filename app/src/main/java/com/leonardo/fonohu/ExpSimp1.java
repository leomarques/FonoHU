package com.leonardo.fonohu;


import android.app.Fragment;
import android.os.Handler;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_exps)
public class ExpSimp1 extends Fragment {
    public static final int TEMPO_ANIMACAO = 500;

    @ViewById
    ImageView btnMaoCabeca, btnPegaPe, btnDarTchau, btnMandaBeijo, menino, btnOk;

    private Handler h;

    @AfterViews
    public void aoCriar() {
        h = new Handler();
    }

    @Click
    public void btnMaoCabeca() {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                menino.setImageResource(R.drawable.menino_mao_cabeca);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(R.drawable.menino_normal);
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
                menino.setImageResource(R.drawable.menino_pega_pe);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(R.drawable.menino_normal);
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
                menino.setImageResource(R.drawable.menino_dar_tchau);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(R.drawable.menino_normal);
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
                menino.setImageResource(R.drawable.menino_beijo);

                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        menino.setImageResource(R.drawable.menino_normal);
                    }
                }, TEMPO_ANIMACAO);
            }
        }, TEMPO_ANIMACAO);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        h.removeCallbacksAndMessages(null);
    }
}
