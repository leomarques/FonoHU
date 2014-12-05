package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_transp2)
public class ApresentaTransp2 extends Fragment {

    @Click
    public void caminhao() {
        App.inst().tocar(R.raw.caminhao);
    }

    @Click
    public void onibus() {
        App.inst().tocar(R.raw.onibus);
    }

    @Click
    public void barco() {
        App.inst().tocar(R.raw.barco);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaTransp2_()).commit();
    }
}
