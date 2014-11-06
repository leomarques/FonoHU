package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais5)
public class ApresentaAnimais5 extends Fragment {

    @ViewById
    ImageView macaco, sapo, lobo, texto;

    @Click
    public void macaco() {
        App.inst().tocar(R.raw.dog);
    }

    @Click
    public void sapo() {
        App.inst().tocar(R.raw.cat);
    }

    @Click
    public void lobo() {
        App.inst().tocar(R.raw.bird);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais5_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }
}
