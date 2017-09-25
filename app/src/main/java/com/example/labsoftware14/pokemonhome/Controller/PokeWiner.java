package com.example.labsoftware14.pokemonhome.Controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.labsoftware14.pokemonhome.R;

/**
 * Created by kevin_000 on 24/09/2017.
 */

public class PokeWiner extends Activity{

    String name,image;
    Context contexto = this;
    ImageView img1;
    TextView nam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winer);

        Bundle bundle = getIntent().getExtras();

        // traemos los datos de la actividad anterior
        name = bundle.getString("name");
        image =  bundle.getString("imageFront");

        img1 = findViewById(R.id.pokeImage);
        nam = (TextView) findViewById(R.id.textname);
        nam.setText(name); // mostramos el nombre en pantalla
        Glide.with(contexto).load(image).into(img1);// mostramos la imagen en pantalla



            }

    }
