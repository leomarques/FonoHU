package com.leonardo.fonohu;

import android.app.Activity;
import android.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.act_main)
public class Main extends Activity {

    @AfterViews
    void aoCriar() {
        getFragmentManager().beginTransaction().replace(R.id.mainLayout, new MenuPrincipal_(), "menu").commit();
    }

    @Override
    public void onBackPressed() {
        Fragment f = getFragmentManager().findFragmentByTag("menu");
        if (f != null && f.isVisible()) {
            super.onBackPressed();
        }
        else {
            getFragmentManager().beginTransaction().replace(R.id.mainLayout, new MenuPrincipal_(), "menu").commit();
        }
    }
}
