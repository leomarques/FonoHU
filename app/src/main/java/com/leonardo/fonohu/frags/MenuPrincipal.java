package com.leonardo.fonohu.frags;

import android.app.Fragment;

import com.leonardo.fonohu.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_menu_principal)
public class MenuPrincipal extends Fragment {

    @Click
    void btnAnimais() {
        getFragmentManager().beginTransaction().replace(getId(), new comecaAnimais_()).addToBackStack(null).commit();
    }

}
