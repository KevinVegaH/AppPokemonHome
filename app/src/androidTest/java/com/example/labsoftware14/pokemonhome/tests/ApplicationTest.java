package com.example.labsoftware14.pokemonhome.tests;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.labsoftware14.pokemonhome.*;
import com.example.labsoftware14.pokemonhome.Model.PokeData;
import com.example.labsoftware14.pokemonhome.Model.PokeSingleton;
import com.example.labsoftware14.pokemonhome.Model.Pokemon;

import org.json.JSONObject;


/**
 * Created by kevin_000 on 03/10/2017.
 */

public class ApplicationTest extends ApplicationTestCase<Application>{

    public ApplicationTest(){super(Application.class);}

    PokeData pd = new PokeData();
    Pokemon pk = new Pokemon();


    public void test_esto_siempre_pasa(){

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, "https://pokeapi.co/api/v2/pokemon/3/", null, new Response.Listener<JSONObject>() {



                    @Override
                    public void onResponse(JSONObject response) {


                        pd.getImage_Front(response);
                        assertTrue(pd.pk.getFront_default_url().contains(".png"));

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        // Access the RequestQueue through your singleton class.
        PokeSingleton.getInstance(getContext()).addToRequestQueue(jsObjRequest);





    }


}
