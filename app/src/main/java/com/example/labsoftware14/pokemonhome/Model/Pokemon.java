package com.example.labsoftware14.pokemonhome.Model;

import org.json.JSONObject;


public class Pokemon { // Objeto que contiene los datos del pokemon //

    private String name,weight,front_default_url, back_image_url, type, power1, power2, experiencia;
    private String[] name_Power;
    private JSONObject image;

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getPower2() {
        return power2;
    }

    public void setPower2(String power2) {
        this.power2 = power2;
    }

    public String getPower1() {
        return power1;
    }

    public void setPower1(String power1) {
        this.power1 = power1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getFront_default_url() {
        return front_default_url;
    }

    public void setFront_default_url(String front_default_url) {
        this.front_default_url = front_default_url;
    }

    public String getBack_image_url() {
        return back_image_url;
    }

    public void setBack_image_url(String back_image_url) {
        this.back_image_url = back_image_url;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Pokemon() {



    }

    public Pokemon(String name,String weight,String fdu, String bdu, String[] name_Power, JSONObject image, String type) {

        this.name = name;
        this.weight = weight;
        this.front_default_url = fdu;
        this.back_image_url = bdu;
        this.name_Power = name_Power;
        this.image = image;
        this.type = type;

    }
}
