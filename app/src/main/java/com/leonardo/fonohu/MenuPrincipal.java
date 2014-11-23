package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_menu_principal)
public class MenuPrincipal extends Fragment {

    @ViewById
    ImageView btnAnimais, btnTransporte, btnParteCorpo;

    @Click
    void btnAnimais() {
        btnAnimais.setImageResource(R.drawable.btn_animais_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new ComecaAnimais_()).commit();
    }

    @Click
    void btnTransporte() {
        btnTransporte.setImageResource(R.drawable.btn_transporte_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new ComecaTransp_()).commit();
    }

    @Click
    void btnParteCorpo() {
        btnParteCorpo.setImageResource(R.drawable.btnpartecorpo_clicado);
        getFragmentManager().beginTransaction().replace(getId(), new PartesCorpo_()).addToBackStack(null).commit();
    }

}
