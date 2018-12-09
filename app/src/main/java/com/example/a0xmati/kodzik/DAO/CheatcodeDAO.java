package com.example.a0xmati.kodzik.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a0xmati.kodzik.Interfaces.ICheatcodeDAO;
import com.example.a0xmati.kodzik.Tables.Cheatcode;

import java.util.ArrayList;

public class CheatcodeDAO implements ICheatcodeDAO {
    @Override
    public ArrayList<Cheatcode> selectAll(SQLiteDatabase db,int id,  int platform) {
        String rawQuery = "SELECT * FROM kod WHERE id_gra = "+ id +" AND id_platforma = "+ platform +";";
        Cursor cursor = db.rawQuery(
                rawQuery,
                null
        );

        ArrayList<Cheatcode> cheats = new ArrayList<Cheatcode>();

        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Cheatcode.ID_COLUMN));
            long itemGameId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Cheatcode.ID_GAME_COLUMN));
            long itemPlatformId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Cheatcode.ID_PLATFORM_COLUMN));
            String itemCheat = cursor.getString(
                    cursor.getColumnIndexOrThrow(Cheatcode.CHEATCODE_COLUMN));
            String itemDesc = cursor.getString(
                    cursor.getColumnIndexOrThrow(Cheatcode.DESCRIPTION_COLUMN));

            cheats.add(new Cheatcode((int) itemId, (int) itemGameId, (int) itemPlatformId, itemCheat, itemDesc ));
        }
        cursor.close();

        return cheats;
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
