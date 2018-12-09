package com.example.a0xmati.kodzik.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a0xmati.kodzik.Activites.GameActivity;
import com.example.a0xmati.kodzik.R;
import com.example.a0xmati.kodzik.Tables.Cheatcode;

import java.util.ArrayList;


public class CheatcodeAdapter extends ArrayAdapter<Cheatcode> {
    public CheatcodeAdapter(Context context, ArrayList<Cheatcode> groups) {
        super(context, 0, groups);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Cheatcode cheatcode = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cheatcode_row, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.cheatitem);
        textView.setText(cheatcode.toString());

        return convertView;
    }

}
