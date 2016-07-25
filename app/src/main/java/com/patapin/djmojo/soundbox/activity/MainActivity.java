package com.patapin.djmojo.soundbox.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.patapin.djmojo.soundbox.R;
import com.patapin.djmojo.soundbox.model.ButtonInfos;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SoundButtonActivity {

    public static final String PREFS_COUNTER = "PrefCounter";

    public static final String PREF_COUNTER_BALLADUR = "CounterBalladur";
    public static final String PREF_COUNTER_CAPTAIN_BASTARD = "CounterCaptainBastard";
    public static final String PREF_COUNTER_COIN = "CounterCoin";
    public static final String PREF_COUNTER_HOU = "CounterHou";
    public static final String PREF_COUNTER_MEUH = "CounterMeuh";
    public static final String PREF_COUNTER_SINGE = "CounterSinge";
    public static final String PREF_COUNTER_HODOR = "CounterHodor";

    // South Park
    public static final String PREF_COUNTER_TIMMY = "CounterTimmy";
    public static final String PREF_COUNTER_MR_ESCLAVE = "CounterLordJesus";
    public static final String PREF_COUNTER_GARRISSON = "CounterGarrisson";
    public static final String PREF_COUNTER_LORDE = "CounterLorde";

    // Movies
    public static final String PREF_COUNTER_CHEWBACCA = "CounterChewbacca";
    public static final String PREF_COUNTER_CHUCK = "CounterChuck";
    public static final String PREF_COUNTER_GROOT = "CounterGroot";
    public static final String PREF_COUNTER_R2D2 = "CounterR2D2";
    public static final String PREF_COUNTER_DOC_SAVAGE = "CounterDocSavage";


    private static List<ButtonInfos> mainSoundList, moviesSoundList, southParkSoundList;
    private ImageButton dirMovies, dirSouthPark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("onCreate","create MAinActivity ");

        dirMovies = (ImageButton) findViewById(R.id.btn_dir_movies);

        dirMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.appearfromright, R.anim.disappearleft);
            }
        });

        dirSouthPark = (ImageButton) findViewById(R.id.btn_dir_southpark);

        dirSouthPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SouthParkActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.appearfromright, R.anim.disappearleft);
            }
        });

        initializeButtons();

        for (ButtonInfos buttonInfos : mainSoundList) {

            ImageButton button = (ImageButton) findViewById(buttonInfos.getButtonId());

            button.setOnClickListener(buttonInfos.getClick());
        }

    }

    private void initializeButtons() {

        mainSoundList = new ArrayList<ButtonInfos>();

        mainSoundList.add(new ButtonInfos(R.id.btn_balladur, R.raw.jevousdemande, R.id.counter_balladur, PREF_COUNTER_BALLADUR));
        mainSoundList.add(new ButtonInfos(R.id.btn_captainbastard, R.raw.captainbastard, R.id.counter_captainBastard, PREF_COUNTER_CAPTAIN_BASTARD));
        mainSoundList.add(new ButtonInfos(R.id.btn_coin, R.raw.coin, R.id.counter_coin, PREF_COUNTER_COIN));
        mainSoundList.add(new ButtonInfos(R.id.btn_hou, R.raw.hou, R.id.counter_hou, PREF_COUNTER_HOU));
        mainSoundList.add(new ButtonInfos(R.id.btn_meuh, R.raw.meuh, R.id.counter_meuh, PREF_COUNTER_MEUH));
        mainSoundList.add(new ButtonInfos(R.id.btn_singe, R.raw.singe, R.id.counter_singe, PREF_COUNTER_SINGE));
        mainSoundList.add(new ButtonInfos(R.id.btn_hodor, R.raw.hodor, R.id.counter_hodor, PREF_COUNTER_HODOR));

        moviesSoundList = new ArrayList<ButtonInfos>();

        moviesSoundList.add(new ButtonInfos(R.id.btn_chewbacca, R.raw.chewbacca, R.id.counter_chewbacca, PREF_COUNTER_CHEWBACCA));
        moviesSoundList.add(new ButtonInfos(R.id.btn_chuck, R.raw.chucknorris, R.id.counter_chuck, PREF_COUNTER_CHUCK));
        moviesSoundList.add(new ButtonInfos(R.id.btn_groot, R.raw.groot, R.id.counter_groot, PREF_COUNTER_GROOT));
        moviesSoundList.add(new ButtonInfos(R.id.btn_r2d2, R.raw.r2d2, R.id.counter_r2d2, PREF_COUNTER_R2D2));
        moviesSoundList.add(new ButtonInfos(R.id.btn_doc_savage, R.raw.docsavage, R.id.counter_doc_savage, PREF_COUNTER_DOC_SAVAGE));

        southParkSoundList = new ArrayList<ButtonInfos>();

        southParkSoundList.add(new ButtonInfos(R.id.btn_timmy, R.raw.timmy, R.id.counter_timmy, PREF_COUNTER_TIMMY));
        southParkSoundList.add(new ButtonInfos(R.id.btn_mresclave, R.raw.mresclave, R.id.counter_mresclave, PREF_COUNTER_MR_ESCLAVE));
        southParkSoundList.add(new ButtonInfos(R.id.btn_garrison, R.raw.mrgarrisson, R.id.counter_garrison, PREF_COUNTER_GARRISSON));
        southParkSoundList.add(new ButtonInfos(R.id.btn_lorde, R.raw.lorde, R.id.counter_lorde, PREF_COUNTER_LORDE));

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_COUNTER, MODE_PRIVATE);

        for (ButtonInfos triplet : mainSoundList) {

            associateSoundNImageButton(triplet, settings);
        }

        for (ButtonInfos triplet : southParkSoundList) {

            associateSoundNImageButton(triplet, settings);
        }

        for (ButtonInfos triplet : moviesSoundList) {

            associateSoundNImageButton(triplet, settings);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(PREFS_COUNTER, MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();

        Log.i("onPause","Stockage des stats");

        editor.clear();
        for (ButtonInfos button : mainSoundList){

            Log.d("onPause", button.getPrefCounter() + " = " + button.getClick().getCounter());
            editor.putInt(button.getPrefCounter(), button.getClick().getCounter());
        }

        for (ButtonInfos button : MainActivity.getSouthParkSoundList()){

            Log.d("onPause", button.getPrefCounter() + " = " + button.getClick().getCounter());
            editor.putInt(button.getPrefCounter(), button.getClick().getCounter());
        }

        for (ButtonInfos button : MainActivity.getMoviesSoundList()){

            Log.d("onPause", button.getPrefCounter() + " = " + button.getClick().getCounter());
            editor.putInt(button.getPrefCounter(), button.getClick().getCounter());
        }
        editor.commit();
    }

    public static List<ButtonInfos> getMainSoundList() {
        return mainSoundList;
    }

    public static List<ButtonInfos> getMoviesSoundList() {
        return moviesSoundList;
    }

    public static List<ButtonInfos> getSouthParkSoundList() {
        return southParkSoundList;
    }
}
