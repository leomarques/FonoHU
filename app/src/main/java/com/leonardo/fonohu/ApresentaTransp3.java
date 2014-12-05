package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_transp3)
public class ApresentaTransp3 extends Fragment {

    @Click
    public void helicoptero() {
        App.inst().tocar(R.raw.helicoptero);
    }

    @Click
    public void aviao() {
        App.inst().tocar(R.raw.aviao);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaTransp3_()).commit();
    }
}
