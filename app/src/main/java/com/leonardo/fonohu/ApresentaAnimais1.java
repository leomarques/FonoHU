package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_apresenta_animais1)
public class ApresentaAnimais1 extends Fragment {

    @Click
    public void cachorro() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void gato() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void passaro() {
        App.inst().tocar(R.raw.bird);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais1_()).commit();
    }

    @Click
    public void btnPassar() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais2_()).commit();
    }
}
