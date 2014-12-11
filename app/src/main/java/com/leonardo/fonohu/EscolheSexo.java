package com.leonardo.fonohu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.os.Handler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_escolhe_sexo)
public class EscolheSexo extends Fragment {

    @ViewById
    ImageView menino, menina, entrada;

    @ViewById
    RelativeLayout escolha;

    @AfterViews
    void aoCriar() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fade();
            }
        }, 4000);
    }

    private void fade() {
        int mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_longAnimTime);
        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        escolha.setAlpha(0f);
        escolha.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        escolha.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        entrada.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        entrada.setVisibility(View.GONE);
                    }
                });
    }

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
