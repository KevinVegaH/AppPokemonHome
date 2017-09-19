package com.example.labsoftware14.pokemonhome.Model;

import org.json.JSONObject;
import org.json.JSONArray;


public class Pokemon {

    private String name;
    private String[] name_Power;
    private JSONObject image;
    private JSONArray abilities;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getName_Power() {
        return name_Power;
    }

    public void setName_Power(String[] name_Power) {
        this.name_Power = name_Power;
    }

    public JSONObject getImage() {
        return image;
    }

    public void setImage(JSONObject image) {
        this.image = image;
    }

    public JSONArray getAbilities() {
        return abilities;
    }

    public void setAbilities(JSONArray abilities) {
        this.abilities = abilities;
    }


    public Pokemon() {



    }

    public Pokemon(String name, String[] name_Power, JSONObject image, JSONArray abilities) {
        this.name = name;
        this.name_Power = name_Power;
        this.image = image;
        this.abilities = abilities;
    }
}
