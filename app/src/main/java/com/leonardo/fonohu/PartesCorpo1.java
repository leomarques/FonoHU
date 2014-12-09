package com.leonardo.fonohu;

import android.app.Fragment;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.frag_partes_corpo1)
public class PartesCorpo1 extends Fragment {

    @ViewById
    ImageView cabeca, braco_esq, braco_dir, perna, pe, mao_esq, mao_dir, corpo, btnOk;

    @Click
    public void cabeca() {
        App.inst().tocar(R.raw.cabeca_o);
    }

    @Click
    public void braco_esq() {
        App.inst().tocar(R.raw.braco);
    }

    @Click
    public void braco_dir() {
        App.inst().tocar(R.raw.braco);
    }

    @Click
    public void perna() {
        App.inst().tocar(R.raw.perna);
    }

    @Click
    public void pe() {
        App.inst().tocar(R.raw.pe_o);
    }

    @Click
    public void mao_esq() {
        App.inst().tocar(R.raw.mao_o);
    }

    @Click
    public void mao_dir() {
        App.inst().tocar(R.raw.mao_o);
    }

    @Click
    public void corpo() {
        App.inst().tocar(R.raw.barriga_o);
    }

    @Click
    public void btnOk() {
        getFragmentManager().beginTransaction().replace(getId(), new PartesCorpo2_()).commit();
    }
}
