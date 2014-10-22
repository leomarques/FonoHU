package com.leonardo.fonohu;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Random;

@EFragment(R.layout.fragment_jogo_animais)
public class JogoAnimais extends Fragment {

    @ViewById
    ImageView animal1, animal2, animal3;

    ArrayList<Integer> ld;
    int a;
    MediaPlayer mpa, mpw, mpl;

    @AfterViews
    public void aoCriar() {
        ld = new ArrayList<Integer>();
        ld.add(R.drawable.dog);
        ld.add(R.drawable.cat);
        ld.add(R.drawable.bird);

        Random r = new Random();
        a = r.nextInt(3);
        animal1.setImageResource(ld.get(a));
        animal1.setTag(ld.get(a));
        ld.remove(a);

        a = r.nextInt(2);
        animal2.setImageResource(ld.get(a));
        animal2.setTag(ld.get(a));
        ld.remove(a);

        animal3.setImageResource(ld.get(0));
        animal3.setTag(ld.get(0));

        a = r.nextInt(3);

        int som = 0;
        switch (a) {
            case 0:
                som =  R.raw.dog;
                break;
            case 1:
                som =  R.raw.cat;
                break;
            case 2:
                som =  R.raw.bird;
                break;
        }
        mpa = MediaPlayer.create(getActivity(), som);
        mpw = MediaPlayer.create(getActivity(), R.raw.win);
        mpl = MediaPlayer.create(getActivity(), R.raw.lose);
        mpa.start();
    }

    @Click
    public void animal1() {
        if (acertou(animal1)) {
            mpw.start();
            Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
        } else {
            mpl.start();
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
        }
    }

    @Click
    public void animal2() {
        if (acertou(animal2)) {
            mpw.start();
            Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
        } else {
            mpl.start();
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
        }
    }

    @Click
    public void animal3() {
        if (acertou(animal3)) {
            mpw.start();
            Toast.makeText(getActivity(), R.string.acertou, Toast.LENGTH_SHORT).show();
        } else {
            mpl.start();
            Toast.makeText(getActivity(), R.string.errou, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean acertou(ImageView imageView) {
        return (Integer) (imageView.getTag()) == R.drawable.dog && a == 0 ||
                (Integer) (imageView.getTag()) == R.drawable.cat && a == 1 ||
                (Integer) (imageView.getTag()) == R.drawable.bird && a == 2;

    }

    @Override
    public void onPause() {
        super.onPause();

        mpa.stop();
        mpw.stop();
        mpl.stop();
        mpa.release();
        mpw.release();
        mpl.release();
        mpa = mpw = mpl = null;
    }
}
