package com.leonardo.fonohu;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_cores)
public class Cores extends Fragment {

    @ViewById
    ImageView btnAmarelo, btnAzul, btnVerde, btnVermelho;

    private boolean s;

    @AfterViews
    public void aoCriar() {
        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        s = pref.getBoolean("sexo", true);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new CorCachorro_()).commit();
    }

    @Click
     public void btnAmarelo() {
        App.inst().tocar(s ? R.raw.amarelo_o : R.raw.amarelo_a);
    }

    @Click
     public void btnAzul() {
        App.inst().tocar(s ? R.raw.azul_o : R.raw.azul_a);
    }

    @Click
     public void btnVerde() {
        App.inst().tocar(s ? R.raw.verde_o : R.raw.verde_a);
    }

    @Click
     public void btnVermelho() {
        App.inst().tocar(s ? R.raw.vermelho_o : R.raw.vermelho_a);
    }
}
