package com.example.a0xmati.kodzik.Activites;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a0xmati.kodzik.DatabaseManager;
import com.example.a0xmati.kodzik.Fragments.PCFragment;
import com.example.a0xmati.kodzik.Fragments.PS4Fragment;
import com.example.a0xmati.kodzik.Fragments.XBOXFragment;
import com.example.a0xmati.kodzik.R;
import com.example.a0xmati.kodzik.Tables.Game;

import java.io.InputStream;
import java.net.URL;

public class GameActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    int id;
    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        databaseManager = DatabaseManager.getInstance();



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        id = extras.getInt("ID");
        String game_name = extras.getString("Name");
        String prod = extras.getString("Producer");
        String date = extras.getString("release_date");
        int id_genre = extras.getInt("id_genre");
        String desc = extras.getString("Desc");
        String img = extras.getString("Img");

        game = new Game(id, game_name, prod, date, id_genre, desc, img);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Game added to favourites", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                databaseManager.addToFav(game);
            }
        });

        setTitle(game_name);
        ImageView iv = findViewById(R.id.imageViewGame);
        new DownLoadImageTask(iv).execute(img);

        databaseManager.setCurrentID(id);
        Fragment frag = new PCFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_place, frag);
        ft.commit();


    }

    public void changeFragment(View view) {
        Fragment frag;
        if (view == findViewById(R.id.button_pc)) {
            frag = new PCFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();

        }

        if (view == findViewById(R.id.button_ps)) {
            frag = new PS4Fragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();

        }

        if (view == findViewById(R.id.button_xbox)) {
            frag = new XBOXFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();

        }
    }

    //Class for download IMAGE
    private class DownLoadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String... urls) {
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try {
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            } catch (Exception e) { // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}



