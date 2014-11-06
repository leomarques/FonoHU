package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais3)
public class ApresentaAnimais3 extends Fragment {

    @ViewById
    ImageView bode, porco, pato, texto;

    @Click
    public void bode() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void porco() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void pato() {
        App.inst().tocar(R.raw.bird);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais3_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
