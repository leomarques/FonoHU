package com.leonardo.fonohu;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_partes_corpo2)
public class PartesCorpo2 extends Fragment {

    private boolean s;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        s = pref.getBoolean("sexo", true);

        return inflater.inflate(s ? R.layout.frag_partes_corpo2 : R.layout.frag_partes_corpo2_a, container, false);
    }

    @Click
    public void olhos() {
        App.inst().tocar(s ? R.raw.olho_o : R.raw.olho_a);
    }

    @Click
    public void nariz() {
        App.inst().tocar(s ? R.raw.nariz_o : R.raw.nariz_a);
    }

    @Click
    public void boca() {
        App.inst().tocar(s ? R.raw.boca_o : R.raw.boca_a);
    }

    @Click
    public void orelha_esq() {
        App.inst().tocar(s ? R.raw.orelha_o : R.raw.orelha_a);
    }

    @Click
    public void orelha_dir() {
        App.inst().tocar(s ? R.raw.orelha_o : R.raw.orelha_a);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
