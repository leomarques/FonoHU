package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_transp1)
public class ApresentaTransp1 extends Fragment {

    @ViewById
    ImageView carro, moto;

    @Click
    public void carro() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void moto() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaTransp1_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
