package com.example.a0xmati.kodzik;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ListView;

import com.example.a0xmati.kodzik.Adapters.CheatcodeAdapter;
import com.example.a0xmati.kodzik.Adapters.GameAdapter;
import com.example.a0xmati.kodzik.DAO.CheatcodeDAO;
import com.example.a0xmati.kodzik.DAO.GameDAO;
import com.example.a0xmati.kodzik.SQLiteHelpers.FavouriteDatabaseHelper;
import com.example.a0xmati.kodzik.SQLiteHelpers.LocalDatabaseHelper;
import com.example.a0xmati.kodzik.Tables.Cheatcode;
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
    private int currentID;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

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

    public void setCurrentID(int id){
        this.currentID = id;
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

    public GameAdapter viewFavorites(Context context) {
        ArrayList<Game> games = gameDAO.selectAll(favouriteDatabaseHelper.getDb());
        GameAdapter adapter = new GameAdapter(context, games);
        return adapter;
    }

    public void reloadFavorites(Context context, ListView listView) {
        listView.setAdapter(null);
        listView.setAdapter(this.viewFavorites(context));
    }

    public CheatcodeAdapter viewCheatcodes(Context context, int id, int plat) {
        ArrayList<Cheatcode> cheats = cheatcodeDAO.selectAll(localDatabaseHelper.getDb(), id, plat);
        CheatcodeAdapter adapter = new CheatcodeAdapter(context, cheats);
        return adapter;
    }

    public void reloadGames(Context context, ListView listView) {
        listView.setAdapter(null);
        listView.setAdapter(this.viewAllGames(context));
    }

    public void loadCheat(Context context, ListView listView, int plat) {
        listView.setAdapter(null);
        listView.setAdapter(this.viewCheatcodes(context, currentID, plat));
    }

    public void addToFav(Game game){
        gameDAO.insert(favouriteDatabaseHelper.getDb(), game);
    }

    public void setmPreferences(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveGameToSharedPrefs(Game game){
        mEditor = mPreferences.edit();
        mEditor.putInt("key",game.getId());
        mEditor.commit();
    }


    public GameAdapter viewGameFromSharedPrefs(Context context){
        int id = mPreferences.getInt("key",0);
        Game game = gameDAO.selectById(localDatabaseHelper.getDb(), id);
        ArrayList<Game> games = new ArrayList<Game>();
        games.add(game);
        GameAdapter adapter = new GameAdapter(context, games);
        return adapter;
    }

    public  void loadShared(Context context, ListView listView){
        listView.setAdapter(null);
        listView.setAdapter(this.viewGameFromSharedPrefs(context));
    }
}
