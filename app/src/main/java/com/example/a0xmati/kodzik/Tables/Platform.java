package com.example.a0xmati.kodzik.Tables;

import android.database.sqlite.SQLiteDatabase;

public class Platform {
    public static final String TABLE_NAME = "platforma";
    public static final String ID_COLUMN = "id_platforma";
    public static final String NAME_COLUMN = "nazwa";
    public static final String SHORTNAME_COLUMN = "skrot";

    private int id;
    private String name;
    private String shortname;

    public Platform(int id, String name, String shortname) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return getShortname();
    }


    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "
                + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN + "TEXT,"
                + SHORTNAME_COLUMN + " TEXT)");
    }

    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }


}
