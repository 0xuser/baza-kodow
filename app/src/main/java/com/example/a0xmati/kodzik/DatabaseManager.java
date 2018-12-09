package com.example.a0xmati.kodzik;

import android.content.Context;
import android.widget.ListView;

import com.example.a0xmati.kodzik.Adapters.GameAdapter;
import com.example.a0xmati.kodzik.DAO.CheatcodeDAO;
import com.example.a0xmati.kodzik.DAO.GameDAO;
import com.example.a0xmati.kodzik.SQLiteHelpers.FavouriteDatabaseHelper;
import com.example.a0xmati.kodzik.SQLiteHelpers.LocalDatabaseHelper;
import com.example.a0xmati.kodzik.Tables.Game;

import java.util.ArrayList;

public class DatabaseManager {

    private static DatabaseManager instance;
    private ListView mainListView;
    private Context mainContext;
    private LocalDatabaseHelper localDatabaseHelper;
    private FavouriteDatabaseHelper favouriteDatabaseHelper;
    private GameDAO gameDAO;
    private CheatcodeDAO cheatcodeDAO;
    private DatabaseManager() {
        gameDAO = new GameDAO();
        cheatcodeDAO = new CheatcodeDAO();
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }


    public void setMainDb(LocalDatabaseHelper localDatabaseHelper) {
        this.localDatabaseHelper = localDatabaseHelper;
    }

    public void setFavDb(FavouriteDatabaseHelper favouriteDatabaseHelper) {
        this.favouriteDatabaseHelper = favouriteDatabaseHelper;
    }

    public void setMainContext(Context context) {
        this.mainContext = context;
    }

    public void setMainListView(ListView listView) {
        this.mainListView = listView;
    }

    public GameAdapter viewAllGames(Context context) {
        ArrayList<Game> games = gameDAO.selectAll(localDatabaseHelper.getDb());
        GameAdapter adapter = new GameAdapter(context, games);
        return adapter;
    }

    public void reloadGames(Context mainContext, ListView mainListView) {
        mainListView.setAdapter(null);
        mainListView.setAdapter(this.viewAllGames(mainContext));
    }

}
