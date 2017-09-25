package com.example.labsoftware14.pokemonhome.Controller;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.labsoftware14.pokemonhome.R;

import java.util.Random;

/**
 * Created by kevin_000 on 23/09/2017.
 */

public class PokeBattle extends  Activity{

    TextView nam1, nam2,life1,life2, info;
    Button boton1, boton2, boton3, boton4;
    String Name1,Name2, image1,image2, imageBack1,imageBack2,power1,power2,power3,power4, experiencia1, experiencia2,vid1,vid2;
    Context contexto = this;
    ImageView img1, img2;
    ProgressBar vida1,vida2;
    int exp1, exp2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        // con esto traemos los datos que necesitamos de la actividad anterior
        Bundle bundle = getIntent().getExtras();

        Name1 = bundle.getString("name");
        Name2 = bundle.getString("name2");
        image1 = bundle.getString("imageFront");
        image2 = bundle.getString("imageFront2");
        imageBack2 = bundle.getString("imagenBack2");
        power1 = bundle.getString("namePower1");
        power2 = bundle.getString("namePower2");
        power3 = bundle.getString("namePower3");
        power4 = bundle.getString("namePower4");
        experiencia1 = bundle.getString("exp");
        experiencia2 = bundle.getString("exp2");

        nam1 = findViewById(R.id.pokeName2);
        nam1.setText(Name1);

        nam2 = findViewById(R.id.PokeName1);
        nam2.setText(Name2);

        // traemos la imagen del pokemon de espaldas
        img1 = findViewById(R.id.imageBack);
        Glide.with(contexto).load(imageBack2).into(img1);

        //traemos la imagen del pokemon de frente
        img2 = findViewById(R.id.imageFront);
        Glide.with(contexto).load(image1).into(img2);

        // gracias a esto vamos a poder ver de forma numerica la vida en pantalla
        life1 = findViewById(R.id.Life1);
        life2 = findViewById(R.id.Life2);

        vid1 =life1.getText().toString();
        vid2 = life2.getText().toString();

        // definimos la vida de los pokemones en batalla
        vida1 = findViewById(R.id.Vida1);
        vida2 = findViewById(R.id.Vida2);
        vida1.setProgress(100);
        vida2.setProgress(100);

        // si no existe una habilidad para el campo este no se mostrara en pantalla, de lo contraio
        // existira el boton con  un poder a utilizar
        if (power1 == null) {

            boton1 = findViewById(R.id.Power3);
            boton1.setVisibility(View.INVISIBLE);

        } else {

            boton1 = findViewById(R.id.Power3);
            boton1.setText(power1);

        }
        if (power2 == null) {

            boton2 = findViewById(R.id.Power4);
            boton2.setVisibility(View.INVISIBLE);

        } else {
            boton2 = findViewById(R.id.Power4);
            boton2.setText(power2);

        }
        if (power3 == null) {

            boton3 = findViewById(R.id.Power1);
            boton3.setVisibility(View.INVISIBLE);

        } else {

            boton3 = findViewById(R.id.Power1);
            boton3.setText(power3);

        }
        if (power4 == null) {

            boton4 = findViewById(R.id.Power2);
            boton4.setVisibility(View.INVISIBLE);

        } else {

            boton4 = findViewById(R.id.Power2);
            boton4.setText(power4);

        }

        exp1 = Integer.parseInt(experiencia1);
        exp2 = Integer.parseInt(experiencia2);

        boton3.setEnabled(false);
        boton4.setEnabled(false);
        boton1.setEnabled(false);
        boton2.setEnabled(false);

        info = findViewById(R.id.PokeInfo);

        // El pokemon con mas experiencia inicia la partida

        if (exp1 > exp2) {

            boton3.setEnabled(true);
            boton4.setEnabled(true);
            info.setText("El pokemon "+ Name2 +" comenzó la partida!");

        } else {

            boton1.setEnabled(true);
            boton2.setEnabled(true);
            info.setText("El pokemon "+Name1 +" comenzó la partida!");
        }
         // Estos son los botones con su respectivo funcionamiento, al hacer uso de alguno de estos
         // sale la informacion en pantalla con el pokemon que la haya utilizado.
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Hit(vida1, life2);
                result(vida1, vida2);

                boton1.setEnabled(false);
                boton2.setEnabled(false);

                boton3.setEnabled(true);
                boton4.setEnabled(true);

                info.setText("El pokemon "+Name1 +" usó "+ power1+".\n Es el turno de "+Name2);

            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Hit(vida1, life2);
                result(vida1, vida2);

                boton1.setEnabled(false);
                boton2.setEnabled(false);

                boton3.setEnabled(true);
                boton4.setEnabled(true);

                info.setText("El pokemon "+Name1 +" usó "+ power2+".\n Es el turno de "+Name2);
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Hit(vida2, life1);
               result(vida1, vida2);

                boton1.setEnabled(true);
                boton2.setEnabled(true);

                boton3.setEnabled(false);
                boton4.setEnabled(false);

                info.setText("El pokemon "+Name2 +" usó "+ power4+".\n Es el turno de "+Name1);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Hit(vida2, life1);
               result(vida1, vida2);

                boton1.setEnabled(true);
                boton2.setEnabled(true);

                boton3.setEnabled(false);
                boton4.setEnabled(false);

                info.setText("El pokemon "+Name2 +" usó "+ power3+".\n Es el turno de "+Name1);
            }
        });
    }





        // este metodo es para el ataque de los pokemones //
    public void Hit(ProgressBar afect, TextView vida){

        Random rd = new Random();
        int attack = rd.nextInt(afect.getProgress()) + 1;
        afect.setProgress(afect.getProgress() - attack);
        int res = (Integer.parseInt(vida.getText().toString()) - attack);
        vida.setText(res + "");
    }


    public void result(ProgressBar a, ProgressBar b) {

        // coloca la barra en roja cuando esta se esta agotando y salta un mensaje //
        if (a.getProgress() < 20 ) {
            a.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);


        }else{}

        // coloca la barra en roja cuando esta se esta agotando y salta un mensaje //
        if (b.getProgress() < 20 ) {
                b.getProgressDrawable().setColorFilter(
                        Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);


        }else{}

        // se define que el pokemon Name1 ganó y salta a la siguiente actividad //
        if (a.getProgress() < 1) {
            Toast.makeText(this,  Name1 + " ha ganado!",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(PokeBattle.this, PokeWiner.class);

            intent.putExtra("imageFront",image1);
            intent.putExtra("name", Name1);

            startActivity(intent);

        }else{}

        // se define que el pokemon Name2 ganó y salta a la siguiente actividad //
        if (b.getProgress() < 1) {
            Toast.makeText(this,  Name2 + " ha ganado!",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(PokeBattle.this, PokeWiner.class);

            intent.putExtra("imageFront",image2);
            intent.putExtra("name", Name2);

            startActivity(intent);

        }else{}

        }
    }


