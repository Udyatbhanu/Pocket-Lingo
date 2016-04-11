package com.home.ubbs.pocketlingo.fragment.dutch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.home.ubbs.pocketlingo.fragment.LingoBaseFragment;
import com.home.ubbs.pocketlingo.view.LingoBaseAdapter;

/**
 * Created by udyatbhanu-mac on 4/2/16.
 */
public class DutchFragment extends LingoBaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view  = super.onCreateView(inflater,container,savedInstanceState);
        setGridAdapter(new LingoBaseAdapter(container.getContext()));
        return view;
    }
}
