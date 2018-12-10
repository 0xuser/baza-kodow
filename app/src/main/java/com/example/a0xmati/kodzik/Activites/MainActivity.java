package com.example.a0xmati.kodzik.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a0xmati.kodzik.DatabaseManager;
import com.example.a0xmati.kodzik.R;
import com.example.a0xmati.kodzik.SQLiteHelpers.FavouriteDatabaseHelper;
import com.example.a0xmati.kodzik.SQLiteHelpers.LocalDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private LocalDatabaseHelper localDatabaseHelper;
    private FavouriteDatabaseHelper favouriteDatabaseHelper;
    private DatabaseManager databaseManager;
    private ListView listView, recently;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.games_list);
        recently = findViewById(R.id.recent_title);
        searchView = findViewById(R.id.searchView);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        databaseManager = DatabaseManager.getInstance();
        localDatabaseHelper = new LocalDatabaseHelper(this, null, null, 2);
        favouriteDatabaseHelper = new FavouriteDatabaseHelper(this, null, null, 1);

        databaseManager.setMainDb(localDatabaseHelper);


        databaseManager.setFavDb(favouriteDatabaseHelper);
        databaseManager.setmPreferences(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                // your text view here
                //Toast.makeText(MainActivity.this, newText, Toast.LENGTH_LONG).show();
                databaseManager.reloadGames(MainActivity.this,listView);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                databaseManager.reloadGamesFilter(MainActivity.this,listView, query);

                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseManager.reloadGames(this, listView);
        databaseManager.loadShared(this,recently);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    Intent intentf = new Intent(MainActivity.this, FavouritesActivity.class);
                    startActivity(intentf);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };


}
