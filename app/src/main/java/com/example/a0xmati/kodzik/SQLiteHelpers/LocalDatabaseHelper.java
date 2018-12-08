package com.example.a0xmati.kodzik.SQLiteHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a0xmati.kodzik.Tables.Cheatcode;
import com.example.a0xmati.kodzik.Tables.Game;
import com.example.a0xmati.kodzik.Tables.Genre;
import com.example.a0xmati.kodzik.Tables.Platform;

public class LocalDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database.db";
    private SQLiteDatabase db;

    public LocalDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, version);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
        Genre.onCreate(db);
        Platform.onCreate(db);
        Game.onCreate(db);
        Cheatcode.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Genre.onUpgrade(db);
        Platform.onUpgrade(db);
        Game.onUpgrade(db);
        Cheatcode.onUpgrade(db);
        this.onCreate(db);
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
