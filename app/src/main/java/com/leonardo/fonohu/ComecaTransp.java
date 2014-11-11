package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_comeca_transp)
public class ComecaTransp extends Fragment {

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new ApresentaTransp1_()).commit();
    }

    @Click
    public void btnNo() {
        getFragmentManager().beginTransaction().replace(getId(), new MenuPrincipal_()).commit();
    }

}
