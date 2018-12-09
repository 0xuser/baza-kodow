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
import com.example.a0xmati.kodzik.Tables.Game;

import java.util.ArrayList;

public class GameAdapter extends ArrayAdapter<Game> {

    public GameAdapter(Context context, ArrayList<Game> groups) {
        super(context, 0, groups);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Game game = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_game, parent, false);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GameActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("ID",game.getId());
                extras.putString("Name", game.getName());
                extras.putString("Img", game.getImg());
                intent.putExtras(extras);
                getContext().startActivity(intent);
            }
        });

        TextView textView = convertView.findViewById(R.id.title);
        textView.setText(game.toString());

        return convertView;
    }
}
