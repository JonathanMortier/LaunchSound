package com.patapin.djmojo.soundbox.listener;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

/**
 * Created by DJMojo on 17/01/15.
 */
public class ClickButton implements View.OnClickListener {

    private int counter;
    private MediaPlayer mediaPlayer;

    public ClickButton(int counter, MediaPlayer mediaPlayer) {
        this.counter = counter;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void onClick(View v) {
        counter++;
        Log.d("ClickButton", "Current counter : " + String.valueOf(counter));
        mediaPlayer.start();

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
