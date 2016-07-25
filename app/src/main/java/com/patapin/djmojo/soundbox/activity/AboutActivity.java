package com.patapin.djmojo.soundbox.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.patapin.djmojo.soundbox.BuildConfig;
import com.patapin.djmojo.soundbox.R;

/**
 * Created by DJMojo on 14/02/15.
 */
public class AboutActivity extends Activity {

    private TextView txtVersionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txtVersionCode = (TextView) findViewById(R.id.txtVersionCode);

        Log.d("About", "Version code : " + String.valueOf(BuildConfig.VERSION_CODE));
        Log.d("About", "Version number : " + String.valueOf(BuildConfig.VERSION_NAME));

        txtVersionCode.append(String.valueOf(BuildConfig.VERSION_CODE));


    }
}
