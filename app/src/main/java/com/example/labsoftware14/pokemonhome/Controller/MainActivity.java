package com.example.labsoftware14.pokemonhome.Controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.labsoftware14.pokemonhome.Model.PokeData;
import com.example.labsoftware14.pokemonhome.Model.PokeSingleton;
import com.example.labsoftware14.pokemonhome.Model.Pokemon;
import com.example.labsoftware14.pokemonhome.R;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnGRandom;
    String image, name;
    Context contexto=this;
    PokeData pd = new PokeData();
    Pokemon pk = new Pokemon();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGRandom = (Button) findViewById(R.id.btnRandom);
        btnGRandom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int indicePokemon = (int) (Math.random()*200);
                int indicePokemon2 = (int) (Math.random()*200);
                String url = ("http://pokeapi.co/api/v2/pokemon/"+indicePokemon);
                String url2 = ("http://pokeapi.co/api/v2/pokemon/"+indicePokemon2);
                getJson(url);
                //getJson2(url2);
            }




        });

    }





    /*

        final TextView mTextView = (TextView) findViewById(R.id.text);

        String url ="http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        PokeSingleton.getInstance(this).addToRequestQueue(stringRequest); */


    public void metodo(){

        System.out.println("Aqui: "+pk.getFront_default_url());

    }



    public void getJson(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {



                    @Override
                    public void onResponse(JSONObject response) {

                        pd.getImage_Front(response);


                        //name = pk.getName();
                        image = pk.getFront_default_url();
                        ImageView img = (ImageView) findViewById(R.id.imagePoke1) ;


                        System.out.println("Aqui: "+ image);

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



