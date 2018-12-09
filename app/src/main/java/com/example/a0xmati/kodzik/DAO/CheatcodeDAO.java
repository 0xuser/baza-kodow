package com.example.a0xmati.kodzik.DAO;

import android.database.sqlite.SQLiteDatabase;

import com.example.a0xmati.kodzik.Interfaces.ICheatcodeDAO;
import com.example.a0xmati.kodzik.Tables.Cheatcode;

import java.util.ArrayList;

public class CheatcodeDAO implements ICheatcodeDAO {
    @Override
    public ArrayList<Cheatcode> selectAll(SQLiteDatabase db) {
        return null;
    }

    @Override
    public Cheatcode selectById(SQLiteDatabase db, int id) {
        return null;
    }

    @Override
    public int insert(SQLiteDatabase db, Cheatcode cheat) {
        return 0;
    }

    @Override
    public boolean update(SQLiteDatabase db, Cheatcode cheat) {
        return false;
    }

    @Override
    public boolean delete(SQLiteDatabase db, Cheatcode cheat) {
        return false;
    }
}
