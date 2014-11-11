package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_transp2)
public class ApresentaTransp2 extends Fragment {

    @ViewById
    ImageView caminhao, onibus, barco;

    @Click
    public void caminhao() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void onibus() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void barco() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaTransp2_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
