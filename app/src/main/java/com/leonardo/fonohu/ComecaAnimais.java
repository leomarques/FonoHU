package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_comeca_animais)
public class ComecaAnimais extends Fragment {

    @ViewById
    ImageView btnOk, btnNo;

    @Click
    public void btnOk() {
        btnOk.setImageResource(R.drawable.ok_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaAnimais1_()).commit();
    }

    @Click
    public void btnNo() {
        btnOk.setImageResource(R.drawable.no_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }

}
