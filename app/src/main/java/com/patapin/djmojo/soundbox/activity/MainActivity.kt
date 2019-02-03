package com.patapin.djmojo.soundbox.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ImageButton
import com.patapin.djmojo.soundbox.R
import com.patapin.djmojo.soundbox.model.ButtonInfos
import java.util.*


class MainActivity : SoundButtonActivity() {
    private var dirMovies: ImageButton? = null
    private var dirSouthPark: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("onCreate", "create MAinActivity ")

        dirMovies = findViewById<View>(R.id.btn_dir_movies) as ImageButton

        dirMovies!!.setOnClickListener {
            val intent = Intent(this@MainActivity, MoviesActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.appearfromright, R.anim.disappearleft)
        }

        dirSouthPark = findViewById<View>(R.id.btn_dir_southpark) as ImageButton

        dirSouthPark!!.setOnClickListener {
            val intent = Intent(this@MainActivity, SouthParkActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.appearfromright, R.anim.disappearleft)
        }

        initializeButtons()

        for (buttonInfos in mainSoundList!!) {

            val button = findViewById<View>(buttonInfos.buttonId) as ImageButton

            button.setOnClickListener(buttonInfos.click)
        }

    }

    private fun initializeButtons() {

        mainSoundList = ArrayList()

        mainSoundList!!.add(ButtonInfos(R.id.btn_balladur, R.raw.jevousdemande, R.id.counter_balladur, PREF_COUNTER_BALLADUR))
        mainSoundList!!.add(ButtonInfos(R.id.btn_captainbastard, R.raw.captainbastard, R.id.counter_captainBastard, PREF_COUNTER_CAPTAIN_BASTARD))
        mainSoundList!!.add(ButtonInfos(R.id.btn_coin, R.raw.coin, R.id.counter_coin, PREF_COUNTER_COIN))
        mainSoundList!!.add(ButtonInfos(R.id.btn_hou, R.raw.hou, R.id.counter_hou, PREF_COUNTER_HOU))
        mainSoundList!!.add(ButtonInfos(R.id.btn_meuh, R.raw.meuh, R.id.counter_meuh, PREF_COUNTER_MEUH))
        mainSoundList!!.add(ButtonInfos(R.id.btn_singe, R.raw.singe, R.id.counter_singe, PREF_COUNTER_SINGE))
        mainSoundList!!.add(ButtonInfos(R.id.btn_hodor, R.raw.hodor, R.id.counter_hodor, PREF_COUNTER_HODOR))

        moviesSoundList = ArrayList()

        moviesSoundList!!.add(ButtonInfos(R.id.btn_chewbacca, R.raw.chewbacca, R.id.counter_chewbacca, PREF_COUNTER_CHEWBACCA))
        moviesSoundList!!.add(ButtonInfos(R.id.btn_chuck, R.raw.chucknorris, R.id.counter_chuck, PREF_COUNTER_CHUCK))
        moviesSoundList!!.add(ButtonInfos(R.id.btn_groot, R.raw.groot, R.id.counter_groot, PREF_COUNTER_GROOT))
        moviesSoundList!!.add(ButtonInfos(R.id.btn_r2d2, R.raw.r2d2, R.id.counter_r2d2, PREF_COUNTER_R2D2))
        moviesSoundList!!.add(ButtonInfos(R.id.btn_doc_savage, R.raw.docsavage, R.id.counter_doc_savage, PREF_COUNTER_DOC_SAVAGE))

        southParkSoundList = ArrayList()

        southParkSoundList!!.add(ButtonInfos(R.id.btn_timmy, R.raw.timmy, R.id.counter_timmy, PREF_COUNTER_TIMMY))
        southParkSoundList!!.add(ButtonInfos(R.id.btn_mresclave, R.raw.mresclave, R.id.counter_mresclave, PREF_COUNTER_MR_ESCLAVE))
        southParkSoundList!!.add(ButtonInfos(R.id.btn_garrison, R.raw.mrgarrisson, R.id.counter_garrison, PREF_COUNTER_GARRISSON))
        southParkSoundList!!.add(ButtonInfos(R.id.btn_lorde, R.raw.lorde, R.id.counter_lorde, PREF_COUNTER_LORDE))

        val settings = getSharedPreferences(MainActivity.PREFS_COUNTER, Context.MODE_PRIVATE)

        for (triplet in mainSoundList!!) {

            associateSoundNImageButton(triplet, settings)
        }

        for (triplet in southParkSoundList!!) {

            associateSoundNImageButton(triplet, settings)
        }

        for (triplet in moviesSoundList!!) {

            associateSoundNImageButton(triplet, settings)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onPause() {
        super.onPause()

        val settings = getSharedPreferences(PREFS_COUNTER, Context.MODE_PRIVATE)

        val editor = settings.edit()

        Log.i("onPause", "Stockage des stats")

        editor.clear()
        for (button in mainSoundList!!) {

            Log.d("onPause", button.prefCounter + " = " + button.click?.counter)
            editor.putInt(button.prefCounter, button.click!!.counter)
        }

        for (button in MainActivity.getSouthParkSoundList()!!) {

            Log.d("onPause", button.prefCounter + " = " + button.click?.counter)
            editor.putInt(button.prefCounter, button.click!!.counter)
        }

        for (button in MainActivity.getMoviesSoundList()!!) {

            Log.d("onPause", button.prefCounter + " = " + button.click?.counter)
            editor.putInt(button.prefCounter, button.click!!.counter)
        }
        editor.apply()
    }

    companion object {

        const val PREFS_COUNTER = "PrefCounter"

        const val PREF_COUNTER_BALLADUR = "CounterBalladur"
        const val PREF_COUNTER_CAPTAIN_BASTARD = "CounterCaptainBastard"
        const val PREF_COUNTER_COIN = "CounterCoin"
        const val PREF_COUNTER_HOU = "CounterHou"
        const val PREF_COUNTER_MEUH = "CounterMeuh"
        const val PREF_COUNTER_SINGE = "CounterSinge"
        const val PREF_COUNTER_HODOR = "CounterHodor"

        // South Park
        const val PREF_COUNTER_TIMMY = "CounterTimmy"
        const val PREF_COUNTER_MR_ESCLAVE = "CounterLordJesus"
        const val PREF_COUNTER_GARRISSON = "CounterGarrisson"
        const val PREF_COUNTER_LORDE = "CounterLorde"

        // Movies
        const val PREF_COUNTER_CHEWBACCA = "CounterChewbacca"
        const val PREF_COUNTER_CHUCK = "CounterChuck"
        const val PREF_COUNTER_GROOT = "CounterGroot"
        const val PREF_COUNTER_R2D2 = "CounterR2D2"
        const val PREF_COUNTER_DOC_SAVAGE = "CounterDocSavage"


        private var mainSoundList: MutableList<ButtonInfos>? = null
        private var moviesSoundList: MutableList<ButtonInfos>? = null
        private var southParkSoundList: MutableList<ButtonInfos>? = null

        fun getMainSoundList(): List<ButtonInfos>? {
            return mainSoundList
        }

        fun getMoviesSoundList(): List<ButtonInfos>? {
            return moviesSoundList
        }

        fun getSouthParkSoundList(): List<ButtonInfos>? {
            return southParkSoundList
        }
    }
}
