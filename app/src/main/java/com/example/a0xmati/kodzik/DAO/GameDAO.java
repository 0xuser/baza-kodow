package com.example.a0xmati.kodzik.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a0xmati.kodzik.Interfaces.IGameDAO;
import com.example.a0xmati.kodzik.Tables.Game;

import java.util.ArrayList;

public class GameDAO implements IGameDAO {

    String tableName = Game.TABLE_NAME;
    String[] projection;

    @Override
    public ArrayList<Game> selectAll(SQLiteDatabase db) {
        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
        );

        ArrayList<Game> games = new ArrayList<Game>();

        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Game.ID_COLUMN));
            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Game.NAME_COLUMN));
            String itemProducer = cursor.getString(
                    cursor.getColumnIndexOrThrow(Game.PRODUCER_COLUMN));
            String itemReleaseDate = cursor.getString(
                    cursor.getColumnIndexOrThrow(Game.RELEASE_DATE_COLUMN));
            long itemIdGenre = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Game.ID_GENRE_COLUMN));
            String itemDesc = cursor.getString(
                    cursor.getColumnIndexOrThrow(Game.DESCRIPTION_COLUMN));
            String itemImg = cursor.getString(
                    cursor.getColumnIndexOrThrow(Game.IMAGE_COLUMN));

            games.add(new Game((int) itemId, itemName, itemProducer, itemReleaseDate, (int) itemIdGenre, itemDesc, itemImg));
        }
        cursor.close();

        return games;
    }

    @Override
    public Game selectById(SQLiteDatabase db, int id) {
        return null;
    }



    @Override
    public int insert(SQLiteDatabase db, Game game) {
        ContentValues values = new ContentValues();

        values.put(Game.NAME_COLUMN, game.getName());
        values.put(Game.PRODUCER_COLUMN, game.getProducer());
        values.put(Game.RELEASE_DATE_COLUMN, game.getRelease_date());
        values.put(Game.ID_GENRE_COLUMN, game.getId_genre());
        values.put(Game.DESCRIPTION_COLUMN, game.getDesc());
        values.put(Game.IMAGE_COLUMN, game.getImg());

        return (int) db.insert(this.tableName, null, values);

    }

    @Override
    public boolean update(SQLiteDatabase db, Game game) {
        return false;
    }

    @Override
    public boolean delete(SQLiteDatabase db, Game game) {
        return false;
    }
}
