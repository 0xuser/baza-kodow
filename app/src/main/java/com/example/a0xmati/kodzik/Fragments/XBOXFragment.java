package com.example.a0xmati.kodzik.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.a0xmati.kodzik.DatabaseManager;
import com.example.a0xmati.kodzik.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class XBOXFragment extends Fragment {

    private DatabaseManager databaseManager;

    public XBOXFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xbox, container, false);
        // Inflate the layout for this fragment
        ListView listView = view.findViewById(R.id.xbox_list);
        databaseManager = DatabaseManager.getInstance();
        databaseManager.loadCheat(getActivity(), listView, 3);
        return view;
    }

}
