package com.example.labsoftware14.pokemonhome;

import com.example.labsoftware14.pokemonhome.Model.PokeData;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {



    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void name() throws Exception{

        PokeData pd = new PokeData();

        assertEquals("http://pokeapi.co/api/v2/pokemon/3",pd.getPokeUrl(3));


    }



}