package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais3)
public class ApresentaAnimais3 extends Fragment {

    @ViewById
    ImageView bode, porco, pato;

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
}
