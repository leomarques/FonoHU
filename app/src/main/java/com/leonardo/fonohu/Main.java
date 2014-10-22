package com.leonardo.fonohu;

import android.app.Activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class Main extends Activity {

    @AfterViews
    void aoCriar() {
        getFragmentManager().beginTransaction().add(R.id.mainLayout, new MenuPrincipal_()).commit();
    }
}
