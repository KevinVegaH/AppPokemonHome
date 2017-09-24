package com.example.labsoftware14.pokemonhome.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.labsoftware14.pokemonhome.Model.PokeData;
import com.example.labsoftware14.pokemonhome.Model.PokeSingleton;
import com.example.labsoftware14.pokemonhome.R;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView nam, ty;
    Button btnGRandom, btnPelea;
    ImageView img;
    String image, name, type;
    Context contexto = this;

    PokeData pd = new PokeData();
    PokeData pd2 = new PokeData();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGRandom = (Button) findViewById(R.id.Random);
        btnPelea = (Button) findViewById(R.id.pelea);


        btnGRandom.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Random de pokemones, entre 500 //
                int pokePut = (int) (Math.random()*500);
                int pokePut2 = (int) (Math.random()*500);
                String url = ("http://pokeapi.co/api/v2/pokemon/"+pokePut);
                String url2 = ("http://pokeapi.co/api/v2/pokemon/"+pokePut2);
                get(url);
                get2(url2);
                btnPelea.setEnabled(true); // habilita el boton de pelea //



            }

        });

        btnPelea.setEnabled(false); // el boton de pelea esta desactivado //

        btnPelea.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PokeBattle.class);
                intent.putExtra("name", pd.pk.getName());
                intent.putExtra("name2", pd2.pk.getName());
                System.out.println("Aca1 : " +pd.pk.getName());
                System.out.println("Aca2 :"+ pd2.pk.getName());
                startActivity(intent);
            }
        });


    }




    public void get(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {



                    @Override
                    public void onResponse(JSONObject response) {

                        img = (ImageView) findViewById(R.id.imagePoke1) ;
                        nam = (TextView) findViewById(R.id.PokeName2);
                        ty = (TextView) findViewById(R.id.pokeTipo2);

                        pd.getName(response);
                        pd.GetType(response);
                        pd.getImage_Front(response);

                        name = pd.pk.getName();
                        type = pd.pk.getType();
                        image = pd.pk.getFront_default_url();


                        nam.setText(name);
                        ty.setText(type);
                        Glide.with(contexto).load(image).into(img);

                        System.out.println("Aqui: "+ type);



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        // Access the RequestQueue through your singleton class.
        PokeSingleton.getInstance(this).addToRequestQueue(jsObjRequest);


    }

    public void get2(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {



                    @Override
                    public void onResponse(JSONObject response) {

                        img = (ImageView) findViewById(R.id.imagePoke2) ;
                        nam = (TextView) findViewById(R.id.PokeName);
                        ty = (TextView) findViewById(R.id.pokeTipo);

                        pd2.getName(response);
                        pd2.getImage_Front(response);
                        pd2.GetType(response);

                        name = pd2.pk.getName();
                        type = pd2.pk.getType();
                        image = pd2.pk.getFront_default_url();

                        nam.setText(name);
                        ty.setText(type);
                        Glide.with(contexto).load(image).into(img);

                        System.out.println("Aqui: "+ name);


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        // Access the RequestQueue through your singleton class.
        PokeSingleton.getInstance(this).addToRequestQueue(jsObjRequest);


    }


}



