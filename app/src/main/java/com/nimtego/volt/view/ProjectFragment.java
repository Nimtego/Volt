package com.nimtego.volt.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nimtego.volt.R;

/**
 * Created by nimtego_loc on 26.03.2018.
 */

public class ProjectFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_project_fragment, null);
    }
}
