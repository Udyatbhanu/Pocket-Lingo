package com.home.ubbs.pocketlingo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.home.ubbs.pocketlingo.R;
import com.home.ubbs.pocketlingo.config.LingoConfigurationManager;

/**
 * Created by udyatbhanu-mac on 4/1/16.
 */
public class LingoBaseAdapter extends BaseAdapter {

    Context context;

    public LingoBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return LingoConfigurationManager.getWordsArray().length;
    }

    @Override
    public Object getItem(int position) {
        return LingoConfigurationManager.getWordsArray()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public Button button;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(context);


        if (convertView == null) {

            convertView = inflater.inflate(R.layout.grid_item, parent, false);
            viewHolder.button = (Button)convertView.findViewById(R.id.button);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        String []wordsArray = LingoConfigurationManager.getWordsArray();
        viewHolder.button.setText(wordsArray[position]);
        viewHolder.button.setOnClickListener(new LingoOnClickListener(context,position,wordsArray[position]));



        return convertView;
    }
}
