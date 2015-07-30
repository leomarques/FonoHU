package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_animais3)
public class ApresentaAnimais3 extends Fragment {

    @Click
    public void bode() {
        App.inst().tocar(R.raw.bode);
    }

    @Click
    public void porco() {
        App.inst().tocar(R.raw.porco);
    }

    @Click
    public void pato() {
        App.inst().tocar(R.raw.pato);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais3_()).commit();
    }

    @Click
    public void btnVoltar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais2_()).commit();
    }

    @Click
    public void btnPassar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais4_()).commit();
    }
}
