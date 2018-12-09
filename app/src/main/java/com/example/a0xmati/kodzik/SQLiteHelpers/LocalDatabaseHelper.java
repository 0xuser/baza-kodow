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
        insertTestData(db);
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

    private void insertTestData(SQLiteDatabase db) {
        db.execSQL("INSERT INTO `gatunek` (`id_gatunek`, `nazwa`) VALUES " +
                "(1, 'Bijatyka'), " +
                "(2, 'Strzelanka'), " +
                "(3, 'Platformowa'), " +
                "(4, 'Akcji'), " +
                "(5, 'Skradanka'), " +
                "(6, 'Muzyczna'), " +
                "(7, 'Przygodowa'), " +
                "(8, 'Hack and slash'), " +
                "(9, 'MMORPG'), " +
                "(10, 'jRPG'), " +
                "(11, 'Roguelike'), " +
                "(12, 'Symulator'), " +
                "(13, 'Sportowa'), " +
                "(14, 'Taktyczna'), " +
                "(15, 'Ekonomiczna'), " +
                "(16, 'Tower defense'), " +
                "(17, 'Logiczna'), " +
                "(18, 'Edukacyjna'), " +
                "(19, 'Wyścigowa');");

        db.execSQL("INSERT INTO `platforma` (`id_platforma`, `nazwa`, `skrot`) VALUES " +
                "(1, 'Komputer Osobisty', 'PC'), " +
                "(2, 'PlayStation 4', 'PS4'), " +
                "(3, 'Microsoft Xbox One', 'XBOX ONE');");

        db.execSQL("INSERT INTO `gra` (`id_gra`, `nazwa`, `producent`, `rok_wydania`, `id_gatunek`, `opis`, `img`) VALUES " +
                "(1, 'The Sims 4', 'EA Maxis / Maxis Software', 2014, 12, 'Czwarta część bestsellerowego cyklu symulacji życia – The Sims. Za deweloping The Sims 4 odpowiedzialne jest studio Maxis znane również z takich produkcji jak SimCity oraz Spore. Gracze ponownie mają okazję pokierować życiem wirtualnej rodziny.', 'https://cdn.gracza.pl/galeria/gry13/grupy/14028.jpg'), " +
                "(2, 'Grand Theft Auto V', 'Rockstar Games', 2013, 4, 'Piąta, pełnoprawna odsłona niezwykle popularnej serii gier akcji, nad której rozwojem pieczę sprawuje studio Rockstar North we współpracy z koncernem Take Two Interactive.', 'https://cdn.gracza.pl/galeria/gry13/grupy/11862.jpg'), " +
                "(3, 'Need For Speed 2', 'Electronic Arts Inc.', 1997, 19, 'Jest to druga część słynnej gry Need for Speed, która swym wykonaniem i grywalnością podbiła serca milionów miłośników wyścigów samochodowych na świecie.', 'https://cdn.gracza.pl/galeria/gry13/1059321109.jpg'), " +
                "(4, 'Gothic 3', 'Piranha Bytes', 2006, 7, 'Fabularna gra akcji, bezpośrednia kontynuacja pierwszej i drugiej części serii Gothic.', 'https://cdn.gracza.pl/galeria/gry13/180633796.jpg'), " +
                "(5, 'Tomb Raider: Legenda', 'Crystal Dynamics', 2006, 7, 'Siódma pełnoprawna odsłona cyklu Tomb Raider.', 'https://cdn.gracza.pl/galeria/gry13/grupy/1711.jpg'); ");

        db.execSQL("INSERT INTO `kod` (`id_kod`, `id_gra`, `id_platforma`, `kod`, `opis`) VALUES " +
                "(1, 1, 1, 'motherlode', 'dodaje 50 000 simoleonów'), " +
                "(2, 1, 1, 'rosebud', 'dodaje 1 000 simoleonów'), " +
                "(3, 1, 1, 'kaching', 'tak jak rosebud - dodaje 1 000 simoleonów'), " +
                "(4, 1, 1, 'resetSim [imię] [nazwisko]', ' resetuje wybranego Sima'), " +
                "(5, 1, 1, 'headlineeffects [on/off]', 'włącza lub wyłącza efekty nad głowami Simów'), " +
                "(6, 1, 1, 'FreeRealEstate [on/off]', 'używany podczas podglądu mapy, umożliwia zakup wybranego domu za darmo'), " +
                "(7, 2, 1, 'Zadzwoń pod 1-999-887-853 (TURTLE) na telefonie', 'Pełne życie oraz pancerz'), " +
                "(8, 2, 1, 'Zadzwoń pod 1-999-228-2463 (CATCH ME) na telefonie', 'Szybsze bieganie'), " +
                "(9, 2, 1, 'Zadzwoń pod 1-999-766-9329 (SNOW DAY) na telefonie', 'Ślizgające się auta'), " +
                "(10, 2, 1, 'Zadzwoń pod 1-999-226-348 (BANDIT) na telefonie', 'Otrzymujesz BMX'), " +
                "(11, 2, 1, 'Zadzwoń pod 1-999-266-38 (COMET) na telefonie', 'Otrzymujesz samochód Comet'), " +
                "(12, 2, 1, 'Zadzwoń pod 1-999-872-433 (TRASHED) na telefonie', 'Otrzymujesz Śmieciarkę'), " +
                "(13, 2, 1, 'Zadzwoń pod 1-999-547867 (LIQUOR) na telefonie', 'Tryb pijaka'), " +
                "(14, 2, 1, 'Zadzwoń pod 1-999-462-363-4279 (INCENDIARY) na telefonie', 'Płonące kule'), " +
                "(15, 2, 2, 'R1 R1 > R2 > < > < > <', 'Obniż poziom bycia poszukiwanym (Wanted)'), " +
                "(16, 2, 2, 'R1 R1 > R2 < > < > < >', 'Podnieś poziom bycia poszukiwanym (Wanted)'), " +
                "(17, 2, 2, 'T < > > L2 L1 K', 'Szybsze bieganie'), " +
                "(18, 2, 2, 'T R1 R1 < R1 L1 R2 L1', 'Pływające samochody'), " +
                "(19, 3, 1, 'landcruiser', 'Otrzymujesz toyota landcruiser'), " +
                "(20, 3, 1, 'vanagon ', 'Otrzymujesz volkswagen van'), " +
                "(21, 3, 1, 'semi', 'Otrzymujesz traktor'), " +
                "(22, 3, 1, 'drive31', 'Otrzymujesz  citroen 2cv'), " +
                "(23, 3, 1, 'hollywood ', 'dostęp do sekretnej trasy'), " +
                "(24, 3, 1, 'pioneer', 'wszystkie samochody mają lepsze silniki i hamulce'), " +
                "(25, 4, 1, 'fullhealth ', 'przywraca całą energię życiową'), " +
                "(26, 4, 1, 'give all', 'dostajesz wszystkie możliwe przedmioty'), " +
                "(27, 4, 1, 'ExplosiveArrow', 'Wybuchowa strzała'), " +
                "(28, 4, 1, 'FireArrow ', 'Ognista strzała'), " +
                "(29, 4, 1, 'give Cat_Armor', 'dostajesz wszystkie zbroje'), " +
                "(30, 4, 1, 'give Cat_Artefact', 'dostajesz wszystkie artefakty'), " +
                "(31, 4, 1, 'give Cat_Weapon', 'dostajesz wszystkie bronie'), " +
                "(32, 5, 3, 'L B A B A Y R', 'tryb bez tekstur'), " +
                "(33, 5, 3, 'L A R Y R X B', 'kuloodporna Lara'), " +
                "(34, 5, 3, 'L Y A Y X B B', 'jeden strzał zabija przeciwnika'), " +
                "(35, 5, 3, 'B B Y L R A B', 'nieograniczona amunicja do SMG');");

    }
}
