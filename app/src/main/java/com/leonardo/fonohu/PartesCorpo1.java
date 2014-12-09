package com.leonardo.fonohu;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment
public class PartesCorpo1 extends Fragment {

    private boolean s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        s = pref.getBoolean("sexo", true);

        return inflater.inflate(s ? R.layout.frag_partes_corpo1 : R.layout.frag_partes_corpo1_a, container, false);
    }

    @Click
    public void cabeca() {
        App.inst().tocar(s ? R.raw.cabeca_o : R.raw.cabeca_a);
    }

    @Click
    public void braco_esq() {
        App.inst().tocar(s ? R.raw.braco : R.raw.braci_a);
    }

    @Click
    public void braco_dir() {
        App.inst().tocar(s ? R.raw.braco : R.raw.braci_a);
    }

    @Click
    public void perna() {
        App.inst().tocar(s ? R.raw.perna : R.raw.perna_a);
    }

    @Click
    public void pe() {
        App.inst().tocar(s ? R.raw.pe_o : R.raw.pe_a);
    }

    @Click
    public void mao_esq() {
        App.inst().tocar(s ? R.raw.mao_o : R.raw.mao_a);
    }

    @Click
    public void mao_dir() {
        App.inst().tocar(s ? R.raw.mao_o : R.raw.mao_a);
    }

    @Click
    public void corpo() {
        App.inst().tocar(s ? R.raw.barriga_o : R.raw.barriga_a);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new PartesCorpo2_()).commit();
    }
}
