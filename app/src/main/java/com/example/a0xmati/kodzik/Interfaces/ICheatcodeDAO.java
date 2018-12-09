package com.example.a0xmati.kodzik.Interfaces;

import android.database.sqlite.SQLiteDatabase;

import com.example.a0xmati.kodzik.Tables.Cheatcode;


import java.util.ArrayList;

public interface ICheatcodeDAO {
    public ArrayList<Cheatcode> selectAll(SQLiteDatabase db);

    public Cheatcode selectById(SQLiteDatabase db, int id);

    public int insert(SQLiteDatabase db, Cheatcode cheat);

    public boolean update(SQLiteDatabase db, Cheatcode cheat);

    public boolean delete(SQLiteDatabase db, Cheatcode cheat);
}
