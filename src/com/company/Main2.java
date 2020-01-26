package com.company;

import com.company.patternstrategy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class Main2{

    public static void main(String[] args) {
        Soin cut = new Soin(){
            public void soigner(){
                System.out.println("Je cut des guiboles");
            }
        };

        Personnage pers = new Guerrier();
        pers.soigner();
        pers.setSoin(new Operation());
        pers.soigner();
        pers.setSoin(() -> System.out.println("Je cut des jambes de bix"));
        pers.soigner();

        //Utilisation d'une classe anonyme
        pers.setSoin(()->System.out.println("cool"));

        pers.soigner();

        List<String> l = new ArrayList<String>(Arrays.asList("lulu", "toto", "pupu",  "citi", "mutu"));

        Function<String, String> f =  s -> s;
        System.out.println("tzst");
        System.out.println("titi");






    }
}