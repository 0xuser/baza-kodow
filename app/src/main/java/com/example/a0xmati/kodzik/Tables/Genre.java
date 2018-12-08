package com.example.a0xmati.kodzik.Tables;

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
}
