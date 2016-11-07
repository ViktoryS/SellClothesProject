package com.clothes.dao;

import com.clothes.entities.clothbuilder.Cloth;

import java.util.ArrayList;
import java.util.List;

public class ClothesStorage {

    private static List<Cloth> clothes = new ArrayList<Cloth>();

    private ClothesStorage(){}

    public static List<Cloth> getAllClothes(){
        return clothes;
    }

    public static Cloth getCloth(int i){
        return clothes.get(i);
    }

    //TODO: Use Cloth in method input parameter
    public static boolean addCloth(String name, char size, double price){
        return clothes.add(new Cloth(name, size, price));
    }

    //TODO: Create isEmpty method or smth like that
    public static int getCountOfClothes(){
        return clothes.size();
    }

}
