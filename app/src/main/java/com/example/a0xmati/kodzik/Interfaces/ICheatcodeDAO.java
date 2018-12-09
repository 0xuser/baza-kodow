package com.example.a0xmati.kodzik.Interfaces;

import com.example.a0xmati.kodzik.Tables.Cheatcode;


import java.util.ArrayList;

public interface ICheatcodeDAO {
    public ArrayList<Cheatcode> selectAll();

    public Cheatcode selectById(int id);

    public int insert(Cheatcode cheat);

    public boolean update(Cheatcode cheat);

    public boolean delete(Cheatcode cheat);
}
