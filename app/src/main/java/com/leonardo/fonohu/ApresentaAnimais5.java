package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_apresenta_animais5)
public class ApresentaAnimais5 extends Fragment {

    @ViewById
    ImageView macaco, sapo, lobo;

    @Click
    public void macaco() {
        App.inst().tocar(R.raw.macaco);
    }

    @Click
    public void sapo() {
        App.inst().tocar(R.raw.sapo);
    }

    @Click
    public void lobo() {
        App.inst().tocar(R.raw.lobo);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new AcertaAnimais5_()).commit();
    }
}
