package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais1)
public class ApresentaAnimais1 extends Fragment {

    @ViewById
    ImageView cachorro, gato, passaro, texto;

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
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
