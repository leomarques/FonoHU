package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_partes_corpo2)
public class PartesCorpo2 extends Fragment {

    @ViewById
    ImageView olhos, nariz, boca, btnOk;

    @Click
    public void olhos() {
        App.inst().tocar(R.raw.olhos);
    }

    @Click
    public void nariz() {
        App.inst().tocar(R.raw.nariz);
    }

    @Click
    public void boca() {
        App.inst().tocar(R.raw.boca);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
