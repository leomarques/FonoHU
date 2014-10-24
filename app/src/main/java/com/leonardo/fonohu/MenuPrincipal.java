package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_menu_principal)
public class MenuPrincipal extends Fragment {

    @Click
    void btnAnimais() {
        getFragmentManager().beginTransaction().replace(getId(), new ComecaAnimais_()).addToBackStack(null).commit();
    }

}
