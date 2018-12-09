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
public class PCFragment extends Fragment {

    private DatabaseManager databaseManager;

    public PCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pc, container, false);
        // Inflate the layout for this fragment
        ListView listView = view.findViewById(R.id.pc_list);
        databaseManager = DatabaseManager.getInstance();
        databaseManager.loadCheat(getActivity(), listView, 1);
        return view;
    }

}
