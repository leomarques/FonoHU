package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais2)
public class ApresentaAnimais2 extends Fragment {

    @ViewById
    ImageView vaca, cavalo, galinha;

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
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
