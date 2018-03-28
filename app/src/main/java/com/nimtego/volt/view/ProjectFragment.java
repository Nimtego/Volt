package com.nimtego.volt.view;



import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**
 * Created by nimtego_loc on 26.03.2018.
 */

public class ProjectFragment extends ListFragment {
    // определяем массив типа String
    final String[] catNames = new String[]{"Р", "Б", "М",
            "М23", "FG", "Т", "Кр", "П", "Д",
            "К", "К", "МL", "Са"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListAdapter adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, catNames);
        setListAdapter(adapter);
    }
}
