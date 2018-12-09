package com.example.a0xmati.kodzik.Interfaces;

import android.database.sqlite.SQLiteDatabase;

import com.example.a0xmati.kodzik.Tables.Game;

import java.util.ArrayList;

public interface IGameDAO {
    public ArrayList<Game> selectAll(SQLiteDatabase db);

    public Game selectById(SQLiteDatabase db, int id);

    public int insert(SQLiteDatabase db, Game game);

    public boolean update(SQLiteDatabase db, Game game);

    public boolean delete(SQLiteDatabase db, Game game);
}
