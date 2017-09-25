package com.example.labsoftware14.pokemonhome.Controller;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.labsoftware14.pokemonhome.R;

/**
 * Created by kevin_000 on 23/09/2017.
 */

public class PokeBattle extends  Activity{

    TextView nam1, nam2;
    String Name1,Name2, image1,image2, imageBack1,imageBack2,power1,power2,power3,power4;
    Context contexto = this;
    ImageView img1, img2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        //COn esto iremos capturar los datos que fueron mandados desde la actividad anterior.
        Bundle bundle = getIntent().getExtras();

        Name1 = bundle.getString("name");
        Name2 = bundle.getString("name2");
        image1 = bundle.getString("imageFront");
        image2 = bundle.getString("imageFront2");
        imageBack1 = bundle.getString("imagenBack");
        imageBack2 = bundle.getString("imagenBack2");
        power1 = bundle.getString("namePower1");
        power2 = bundle.getString("namePower2");
        power3 = bundle.getString("namePower3");
        power4 = bundle.getString("namePower4");


         System.out.println(Name2);

        nam1 = findViewById(R.id.pokeName2);
        nam1.setText(Name1);

        nam2 = findViewById(R.id.PokeName1);
        nam2.setText(Name2);

        img1 = findViewById(R.id.imageBack) ;
        Glide.with(contexto).load(imageBack2).into(img1);

        img2 = findViewById(R.id.imageFront) ;
        Glide.with(contexto).load(image1).into(img2);

    }

}
