package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais4)
public class ApresentaAnimais4 extends Fragment {

    @ViewById
    ImageView elefante, cobra, leao, texto;

    @Click
    public void elefante() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void cobra() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void leao() {
        App.inst().tocar(R.raw.bird);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais4_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
