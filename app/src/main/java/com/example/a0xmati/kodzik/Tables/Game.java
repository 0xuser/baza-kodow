package com.example.a0xmati.kodzik.Tables;

import android.database.sqlite.SQLiteDatabase;

public class Game {
    public static final String TABLE_NAME = "gra";
    public static final String ID_COLUMN = "id_gra";
    public static final String NAME_COLUMN = "nazwa";
    public static final String PRODUCER_COLUMN = "producent";
    public static final String RELEASE_DATE_COLUMN = "rok_wydania";
    public static final String ID_GENRE_COLUMN = "id_gatunek";
    public static final String DESCRIPTION_COLUMN = "opis";
    public static final String IMAGE_COLUMN = "img";

    private int id;
    private String name;
    private String producer;
    private String release_date;
    private int id_genre;
    private String desc;
    private String img;

    public Game(int id, String name, String producer, String release_date, int id_genre, String desc, String img) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.release_date = release_date;
        this.id_genre = id_genre;
        this.desc = desc;
        this.img = img;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return getName();
    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN + " TEXT, "
                + PRODUCER_COLUMN + " TEXT, "
                + RELEASE_DATE_COLUMN + " TEXT, "
                + ID_GENRE_COLUMN + " INTEGER, "
                + DESCRIPTION_COLUMN + " TEXT,"
                + IMAGE_COLUMN + " TEXT, "
                + "CONSTRAINT FK_Genre FOREIGN KEY (" + ID_GENRE_COLUMN + ") REFERENCES " + Genre.TABLE_NAME + "(" + Genre.ID_COLUMN + ") ON DELETE CASCADE)");

    }

    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}
