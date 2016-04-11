/**
 * Created by udyatbhanu-mac on 4/1/16.
 */
package com.home.ubbs.pocketlingo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.home.ubbs.pocketlingo.R;
import com.home.ubbs.pocketlingo.view.LingoBaseAdapter;

public class LingoBaseFragment extends Fragment {

    private GridView gridview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_base, container, false);
        gridview = (GridView)view.findViewById(R.id.gridview);
        setGridAdapter(new LingoBaseAdapter(container.getContext()));

        setRetainInstance(true);

        return view;
    }

    protected void setGridAdapter(LingoBaseAdapter adapter){
        gridview.setAdapter(adapter);
    }


}
