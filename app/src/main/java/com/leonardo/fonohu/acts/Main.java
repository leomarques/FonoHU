package com.leonardo.fonohu.acts;

import android.app.Activity;

import com.leonardo.fonohu.R;
import com.leonardo.fonohu.frags.MenuPrincipal_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class Main extends Activity {

    @AfterViews
    void aoCriar() {
        getFragmentManager().beginTransaction().add(R.id.mainLayout, new MenuPrincipal_()).commit();
    }
}
