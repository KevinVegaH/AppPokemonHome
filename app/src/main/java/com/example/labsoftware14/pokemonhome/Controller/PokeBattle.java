package com.example.labsoftware14.pokemonhome.Controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.labsoftware14.pokemonhome.R;

/**
 * Created by kevin_000 on 23/09/2017.
 */

public class PokeBattle extends  Activity{

    String Name1,name2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);



        //COn esto iremos capturar los datos que fueron mandados desde la actividad anterior.
        Bundle bundle = getIntent().getExtras();

        Name1 = bundle.getString("name");
        name2 = bundle.getString("name2");
        // System.out.println(Nombre1);


    }

}
