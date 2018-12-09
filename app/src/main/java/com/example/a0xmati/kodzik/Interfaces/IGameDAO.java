package com.example.a0xmati.kodzik.Interfaces;

import com.example.a0xmati.kodzik.Tables.Game;

import java.util.ArrayList;

public interface IGameDAO {
    public ArrayList<Game> selectAll();

    public Game selectById(int id);

    public int insert(Game game);

    public boolean update(Game game);

    public boolean delete(Game game);
}
