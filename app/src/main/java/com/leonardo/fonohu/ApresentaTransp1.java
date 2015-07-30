package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_transp1)
public class ApresentaTransp1 extends Fragment {

    @Click
    public void carro() {
        App.inst().tocar(R.raw.carro);
    }

    @Click
    public void moto() {
        App.inst().tocar(R.raw.moto);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaTransp1_()).commit();
    }

    @Click
    public void btnPassar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaTransp2_()).commit();
    }
}
