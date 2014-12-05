package com.leonardo.fonohu;

import android.app.Fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.frag_cores)
public class Cores extends Fragment {

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new CorCachorro_()).commit();
    }
}
