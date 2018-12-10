package com.example.a0xmati.kodzik.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a0xmati.kodzik.Activites.GameActivity;
import com.example.a0xmati.kodzik.DatabaseManager;
import com.example.a0xmati.kodzik.R;
import com.example.a0xmati.kodzik.Tables.Game;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                DatabaseManager databaseManager = DatabaseManager.getInstance();
                databaseManager.saveGameToSharedPrefs(game);
                Intent intent = new Intent(getContext(), GameActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("ID", game.getId());
                extras.putString("Name", game.getName());
                extras.putString("Producer", game.getProducer());
                extras.putString("release_date", game.getRelease_date());
                extras.putInt("id_genre", game.getId_genre());
                extras.putString("Desc", game.getDesc());
                extras.putString("Img", game.getImg());
                intent.putExtras(extras);
                getContext().startActivity(intent);
            }
        });


        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Pattern p = Pattern.compile(".*FavouritesActivity.*");
                Matcher m = p.matcher(getContext().toString());
                boolean b = m.matches();
                final DatabaseManager databaseManager = DatabaseManager.getInstance();
                if (b) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Do you want to delete " + game.toString() + " from Favourites");
                    builder.setMessage("Are you sure?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            databaseManager.removeFromFav(game);
                            dialog.dismiss();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                    return true;
                }
                return true;
            }
        });


        TextView textView = convertView.findViewById(R.id.title);
        textView.setText(game.toString());

        return convertView;
    }


}
