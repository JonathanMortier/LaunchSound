package com.patapin.djmojo.soundbox.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageButton;

import com.patapin.djmojo.soundbox.R;
import com.patapin.djmojo.soundbox.model.ButtonInfos;

import java.util.List;

/**
 * Created by DJMojo on 01/03/15.
 */
public class SouthParkActivity extends SoundButtonActivity {

    private List<ButtonInfos> southParkSoundList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southpark);

        southParkSoundList = MainActivity.getSouthParkSoundList();

        for (ButtonInfos buttonInfos : southParkSoundList) {

            ImageButton button = (ImageButton) findViewById(buttonInfos.getButtonId());

            button.setOnClickListener(buttonInfos.getClick());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movies, menu);
        return true;
    }


    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_COUNTER, MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();

        Log.i("onPause", "Stockage des stats");

        editor.clear();
        for (ButtonInfos button : MainActivity.getSouthParkSoundList()){

            Log.d("onPause", button.getPrefCounter() + " = " + button.getClick().getCounter());
            editor.putInt(button.getPrefCounter(), button.getClick().getCounter());
        }
        editor.commit();

        overridePendingTransition(R.anim.appearfromleft, R.anim.disappearfromright);

    }

}
