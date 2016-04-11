package com.home.ubbs.pocketlingo.application;

import android.app.Application;

import com.home.ubbs.pocketlingo.config.LingoConfigurationManager;

/**
 * Created by udyatbhanu-mac on 4/1/16.
 */
public class LingoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LingoConfigurationManager.init(getApplicationContext());
    }
}
