package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_animais2)
public class ApresentaAnimais2 extends Fragment {

    @Click
    public void vaca() {
        App.inst().tocar(R.raw.vaca);
    }

    @Click
    public void cavalo() {
        App.inst().tocar(R.raw.cavalo);
    }

    @Click
    public void galinha() {
        App.inst().tocar(R.raw.galinha);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais2_()).commit();
    }

    @Click
    public void btnVoltar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais1_()).commit();
    }

    @Click
    public void btnPassar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais3_()).commit();
    }
}
