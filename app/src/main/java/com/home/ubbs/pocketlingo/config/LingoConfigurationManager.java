package com.home.ubbs.pocketlingo.config;

import android.content.Context;

import com.home.ubbs.pocketlingo.R;
import com.home.ubbs.pocketlingo.util.Utils;

/**
 * Created by udyatbhanu-mac on 4/1/16.
 */
public class LingoConfigurationManager {


    private static String[] wordsArray;
    private static LingoConfigurationManager instance;
    private static String config;

    private LingoConfigurationManager(){

    }

    public static LingoConfigurationManager getInstance()
    {
        // Return the instance
        return instance;
    }



    public static void init(Context context){
        wordsArray = Utils.getWords(R.raw.words,context);
        setCurrentLingo("french");
    }

    public static String[] getWordsArray(){
        return wordsArray;
    }

    public static String getCurrentLingo(){
        return config;
    }
    public static  void setCurrentLingo(String language){
        config = language;
    }
}
