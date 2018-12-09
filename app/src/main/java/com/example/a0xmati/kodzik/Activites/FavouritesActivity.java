package com.example.a0xmati.kodzik.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a0xmati.kodzik.DatabaseManager;
import com.example.a0xmati.kodzik.R;

public class FavouritesActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        listView = findViewById(R.id.fav_list);
        databaseManager = DatabaseManager.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseManager.reloadFavorites(this, listView);
    }

}
