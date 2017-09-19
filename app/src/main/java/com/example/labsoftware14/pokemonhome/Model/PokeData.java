package com.example.labsoftware14.pokemonhome.Model;

/**
 * Created by labsoftware14 on 18/09/17.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;

public class PokeData {

    private String name;
    private JSONArray abilities;
    private String[] namepower;

    Pokemon pk = new Pokemon();

    public void getName(JSONObject info){
        try {
            name = info.getString("name");
            pk.setName(name);

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }
    public void getName_Power(JSONObject info){

            abilities = null;
        try {
            abilities = info.getJSONArray("abilities");

            for (int i = 0; i < abilities.length(); i++){
                JSONObject c = abilities.getJSONObject(i);

                JSONObject ability = c.getJSONObject("ability");
                namepower[i] = ability.getString("name");
                pk.setName_Power(namepower);

            }



        } catch (JSONException e) {

            e.printStackTrace();

        }


    }



}
