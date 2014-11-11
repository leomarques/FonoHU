package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_transp3)
public class ApresentaTransp3 extends Fragment {

    @ViewById
    ImageView helicoptero, aviao;

    @Click
    public void helicoptero() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void aviao() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaTransp3_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
