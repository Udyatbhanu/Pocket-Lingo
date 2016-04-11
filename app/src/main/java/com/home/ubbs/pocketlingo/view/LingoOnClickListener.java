package com.home.ubbs.pocketlingo.view;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

import com.home.ubbs.pocketlingo.config.LingoConfigurationManager;
import com.home.ubbs.pocketlingo.util.Utils;

import java.io.IOException;

/**
 * Created by udyatbhanu-mac on 4/1/16.
 */
public class LingoOnClickListener implements View.OnClickListener{
    private int position;
    private String fileName;

    private MediaPlayer mplayer;

    public LingoOnClickListener() {
    }

    public LingoOnClickListener(Context context, int position, String fileName) {
        this.position = position;
        this.fileName = fileName;

        try{
            StringBuffer filePath = new StringBuffer();

            filePath.append(LingoConfigurationManager.getCurrentLingo());
            filePath.append("/");
            filePath.append(Utils.getFileName(fileName) +".m4a");


//            AssetFileDescriptor afd = context.getAssets().openFd("french/pardon_me.m4a");
            AssetFileDescriptor afd = context.getAssets().openFd(filePath.toString());
            mplayer = new MediaPlayer();
            mplayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mplayer.prepare();
        }catch(IOException e){
            Log.e("Error","Unable to find audio file");
        }

    }
    @Override
    public void onClick(View v) {

        mplayer.start();

    }
}
