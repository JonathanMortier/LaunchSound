package com.patapin.djmojo.soundbox.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.patapin.djmojo.soundbox.R;
import com.patapin.djmojo.soundbox.model.ButtonInfos;

import java.util.List;

public class StatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        List<ButtonInfos> mainSoundList = MainActivity.getMainSoundList();
        List<ButtonInfos> moviesSoundList = MainActivity.getMoviesSoundList();
        List<ButtonInfos> southparkSoundList = MainActivity.getSouthParkSoundList();

        for (ButtonInfos buttonInfos : mainSoundList) {

            TextView textView = (TextView) findViewById(buttonInfos.getStatTextId());
            String text = String.valueOf(buttonInfos.getClick().getCounter());
            textView.setText(text);
        }

        for (ButtonInfos buttonInfos : moviesSoundList) {

            TextView textView = (TextView) findViewById(buttonInfos.getStatTextId());
            String text = String.valueOf(buttonInfos.getClick().getCounter());
            textView.setText(text);
        }

        for (ButtonInfos buttonInfos : southparkSoundList) {

            TextView textView = (TextView) findViewById(buttonInfos.getStatTextId());
            String text = String.valueOf(buttonInfos.getClick().getCounter());
            textView.setText(text);
        }

    }
}
