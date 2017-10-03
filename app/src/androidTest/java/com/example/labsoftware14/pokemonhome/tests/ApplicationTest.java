package com.example.labsoftware14.pokemonhome.tests;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by kevin_000 on 03/10/2017.
 */

public class ApplicationTest extends ApplicationTestCase<Application>{
    public ApplicationTest(){super(Application.class);}

    public void test_esto_siempre_pasa(){

        assertTrue(5<1);

    }


}
