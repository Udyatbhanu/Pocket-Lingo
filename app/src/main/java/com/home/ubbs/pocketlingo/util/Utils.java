package com.home.ubbs.pocketlingo.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by udyatbhanu-mac on 4/1/16.
 */
public class Utils {

    private static final String TAG = Utils.class.getSimpleName();

    /**
     *
     * @param wordsResource
     * @param context
     * @return
     */

    public static String[] getWords(int wordsResource, Context context){
        InputStream inputStream = context.getResources().openRawResource(wordsResource);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder text = new StringBuilder();
        String[] wordsArray =null;


        try {
            while (( line = bufferedReader.readLine()) != null) {
                text.append(line);

            }
            JSONObject jObject = new JSONObject(text.toString());
            JSONObject jObjectResult = jObject.getJSONObject("BaseConfig");
            wordsArray = new String[jObjectResult.length()];
            JSONArray jsonArray = jObjectResult.getJSONArray("Words");
            wordsArray = new String[jsonArray.length()];
            for(int i=0; i<jsonArray.length();i++){
                wordsArray[i] = jsonArray.getString(i);
            }



        }catch (JSONException ex) {
            Log.e(TAG,"Exception");
        }
        catch (IOException e) {
            Log.e(TAG,"Exception");
        }
        return wordsArray;
    }


    /**
     *
     * @return
     */
    public static String getFileName(String word){

        return word.toLowerCase().replaceAll(" ","_");
//        String []wordsArray = LingoConfigurationManager.getWordsArray();
//        String []fileArray =  new String[wordsArray.length];
//        for(int i=0; i<wordsArray.length;i++){
//            fileArray[i] = word.toLowerCase().replaceAll(" ","_");
//        }
//        return fileArray;


    }


}
