package com.leonardo.fonohu;

import android.app.Application;
import android.media.MediaPlayer;

public class App extends Application {

    private static App inst;

    MediaPlayer mp;

    public App() {
        inst = this;
    }

    public static App inst() {
        return inst;
    }

    public void tocar(final int som1, final int som2) {
        if (mp != null) {
            mp.stop();
            mp.release();
        }

        mp = MediaPlayer.create(inst(), som1);

        if (som2 != -1) {
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                    mp = MediaPlayer.create(inst(), som2);
                    mp.start();
                }
            });
        }

        mp.start();
    }

    public void tocar(final int som) {
        tocar(som, -1);
    }
}
