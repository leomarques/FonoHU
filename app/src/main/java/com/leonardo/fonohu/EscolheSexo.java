package com.leonardo.fonohu;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_escolhe_sexo)
public class EscolheSexo extends Fragment {

    @ViewById
    ImageView menino, menina;

    @Click
    public void menino() {
        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("sexo", true);
        editor.apply();

        menino.setImageResource(R.drawable.icone_menino_escolhido);

        getFragmentManager().beginTransaction().replace(R.id.mainLayout, new MenuPrincipal_(), "menu").commit();
    }

    @Click
    public void menina() {
        SharedPreferences pref = App.inst().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("sexo", false);
        editor.apply();

        menina.setImageResource(R.drawable.icone_menina_escolhido);

        getFragmentManager().beginTransaction().replace(R.id.mainLayout, new MenuPrincipal_(), "menu").commit();
    }
}
