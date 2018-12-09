package com.example.a0xmati.kodzik.Tables;

import android.database.sqlite.SQLiteDatabase;

public class Cheatcode {
    public static final String TABLE_NAME = "kod";
    public static final String ID_COLUMN = "id_kod";
    public static final String ID_GAME_COLUMN = "id_gra";
    public static final String ID_PLATFORM_COLUMN = "id_platforma";
    public static final String CHEATCODE_COLUMN = "kod";
    public static final String DESCRIPTION_COLUMN = "opis";

    private int id;
    private int id_game;
    private int id_platform;
    private String cheatcode;
    private String desc;

    public Cheatcode(int id, int id_game, int id_platform, String cheatcode, String desc) {
        this.id = id;
        this.id_game = id_game;
        this.id_platform = id_platform;
        this.cheatcode = cheatcode;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public int getId_platform() {
        return id_platform;
    }

    public void setId_platform(int id_platform) {
        this.id_platform = id_platform;
    }

    public String getCheatcode() {
        return cheatcode;
    }

    public void setCheatcode(String cheatcode) {
        this.cheatcode = cheatcode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ID_GAME_COLUMN + " INTEGER, "
                + ID_PLATFORM_COLUMN + " INTEGER, "
                + CHEATCODE_COLUMN + " TEXT,"
                + DESCRIPTION_COLUMN + " TEXT, "
                + "CONSTRAINT FK_Game FOREIGN KEY (" + ID_GAME_COLUMN + ") REFERENCES " + Game.TABLE_NAME + "(" + Game.ID_COLUMN + ") ON DELETE CASCADE,"
                + "CONSTRAINT FK_Platform FOREIGN KEY (" + ID_PLATFORM_COLUMN + ") REFERENCES " + Platform.TABLE_NAME + "(" + Platform.ID_COLUMN + ") ON DELETE CASCADE)");

    }

    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}


