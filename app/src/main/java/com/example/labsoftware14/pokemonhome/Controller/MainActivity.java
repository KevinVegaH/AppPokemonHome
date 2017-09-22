package com.example.labsoftware14.pokemonhome.Controller;

import android.content.Context;
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

    Button btnGRandom;
    String image, name;
    Context contexto= this;
    PokeData pd = new PokeData();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGRandom = (Button) findViewById(R.id.Random);
        btnGRandom.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                int pokePut = (int) (Math.random()*500);
                int pokePut2 = (int) (Math.random()*500);

                String url = ("http://pokeapi.co/api/v2/pokemon/"+pokePut);

                String url2 = ("http://pokeapi.co/api/v2/pokemon/"+pokePut2);
                get(url);
                get2(url2);
            }




        });

    }

    public void get(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {



                    @Override
                    public void onResponse(JSONObject response) {



                        pd.getName(response);
                        pd.getImage_Front(response);


                        name = pd.pk.getName();
                        image = pd.pk.getFront_default_url();

                        ImageView img = (ImageView) findViewById(R.id.imagePoke1) ;
                        TextView nam = (TextView) findViewById(R.id.vs);


                        System.out.println("Aqui: "+ name);

                        Glide.with(contexto)
                                .load(image)
                                .into(img);



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



                        pd.getName(response);
                        pd.getImage_Front(response);


                        name = pd.pk.getName();
                        image = pd.pk.getFront_default_url();

                        ImageView img = (ImageView) findViewById(R.id.imagePoke2) ;
                        TextView nam = (TextView) findViewById(R.id.vs);


                        System.out.println("Aqui: "+ name);

                        Glide.with(contexto)
                                .load(image)
                                .into(img);



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



