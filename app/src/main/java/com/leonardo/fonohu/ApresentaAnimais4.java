package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_animais4)
public class ApresentaAnimais4 extends Fragment {

    @Click
    public void elefante() {
        App.inst().tocar(R.raw.elefante);
    }

    @Click
    public void cobra() {
        App.inst().tocar(R.raw.cobra);
    }

    @Click
    public void leao() {
        App.inst().tocar(R.raw.leao);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais4_()).commit();
    }

    @Click
    public void btnVoltar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais3_()).commit();
    }

    @Click
    public void btnPassar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais5_()).commit();
    }
}
