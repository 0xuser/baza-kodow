package com.example.a0xmati.kodzik.Tables;

import android.database.sqlite.SQLiteDatabase;

public class Genre {
    public static final String TABLE_NAME = "gatunek";
    public static final String ID_COLUMN = "id_gatunek";
    public static final String NAME_COLUMN = "nazwa";

    private int id;
    private String name;

    public Genre(int id, String name, String shortname) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return getName();
    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN + " TEXT)");
    }


    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}
