package com.example.labsoftware14.pokemonhome.Model;

/**
 * Created by labsoftware14 on 18/09/17.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;

public class PokeData {

    private String name,weight, front_default_url, back_image_url;
    private JSONArray abilities;
    private String[] name_Power;
    private JSONObject image;
    private static  JSONObject info_Sprites;

    Pokemon pk = new Pokemon();
    //PokeData Pd = new PokeData();

    public void getName(JSONObject info){
        try {
            name = info.getString("name");
            pk.setName(name);

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }

    public static JSONObject getSprites(JSONObject info){
        info_Sprites = null;
        try {
            info_Sprites = info.getJSONObject("sprites");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return info_Sprites;
    }

    public void getImage_Front(JSONObject info){

        image = null;
        image = PokeData.getSprites(info);

        try{

            front_default_url  = image.getString("front_default");
            pk.setFront_default_url(front_default_url);

            System.out.println("Aqui" + pk.getFront_default_url());


        }catch(JSONException e){

            e.printStackTrace();

        }


    }

    public void getImage_Back(JSONObject info){

        image = null;
        image = PokeData.getSprites(info);
        try {
            back_image_url = image.getString("back_default");
            pk.setBack_image_url(back_image_url);

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
                name_Power[i] = ability.getString("name");
                pk.setName_Power(name_Power);

            }



        } catch (JSONException e) {

            e.printStackTrace();

        }

    }

    public void getWeight(JSONObject info){

        try {
            weight = info.getString("weight");
            pk.setWeight(weight);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }





}
