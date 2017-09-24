package com.example.labsoftware14.pokemonhome.Model;

/**
 * Created by labsoftware14 on 18/09/17.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;

public class PokeData {

    private String name,weight, front_default_url, back_image_url,typ, typ2, typp;
    private JSONArray abilities;
    private  static JSONArray types;
    private String[] name_Power;
    private static String[] type;
    private JSONObject image;
    private static  JSONObject info_Sprites;

    public Pokemon pk = new Pokemon(); //--> instancia del objeto Pokemon

    public void getName(JSONObject info){
        try {
            name = info.getString("name");
            pk.setName(name);

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }// --> Un metodo que para obtener el nombre del pokemon
    //  tomandolo del Json y los mandolo al objeto pokemon.

    public static JSONObject getSprites(JSONObject info){
        info_Sprites = null;
        try {
            info_Sprites = info.getJSONObject("sprites");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return info_Sprites;
    } // --> un metodo estatico
    // que trae toda la informacion del Sprites del pokemon en la API y lo almacena en un JSONObject llamado info_Sprites.

    public void getImage_Front(JSONObject info){

        image = PokeData.getSprites(info);

        try{

            front_default_url  = image.getString("front_default");
            pk.setFront_default_url(front_default_url);




        }catch(JSONException e){

            e.printStackTrace();

        }


    }// --> Un metodo para obtener la imagen de frente
    // de un pokemon tomandola del Json y la manda al objeto pokemon.

    public void getImage_Back(JSONObject info){

        image = PokeData.getSprites(info);
        try {
            back_image_url = image.getString("back_default");
            pk.setBack_image_url(back_image_url);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }// --> Un metodo para obtener la imagen de espaldas
    // de un pokemon tomandola del Json y la manda al objeto pokemon.

    public void getName_Power(JSONObject info){

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

    }// -->  Un metodo que almacena en un vector los
    // poderes de un pokemon  tomandolos del Json y los manda al objeto pokemon.

    public void getWeight(JSONObject info){

        try {
            weight = info.getString("weight");
            pk.setWeight(weight);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    } // -->  Un metodo que almacena el peso del pokemon tomandolo
    // del Json y lo manda al objeto pokemon.

    public static  String getTypes(JSONObject info, int num) {

        type = new String [2];

        try {
            types = info.getJSONArray("types");

            for (int i = 0; i < 2; i++) {
                JSONObject c = types.getJSONObject(i);
                // Ability node is JSON Object
                JSONObject ability = c.getJSONObject("type");
                type[i] = ability.getString("name");

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return type[num];
    } // ---> // un metodo estatico
    // que trae toda la informacion del tipo del pokemon en la API y lo almacena en un vector llamado type.

    public void GetType(JSONObject info){

        typ = PokeData.getTypes(info,0);
        typ2 = PokeData.getTypes(info,1);

        if( typ == null){

            typp = "tipo: \n"+ typ2;

        }else if(typ2 == null){

            typp = "tipo: \n"+ typ;

        }else{

            typp = "tipo: \n"+  typ + ", " +typ2;

        }

        pk.setType(typp);

    } // -->  Este metodo obtiene Tipo del Vector Type
    // y lo envia al objeto pokemon.






}