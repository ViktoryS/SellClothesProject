package com.clothes.dao;

import java.util.ArrayList;
import java.util.List;

//TODO: Remove this one
public class MemoryStorage {

    private static List<Cloth> clothes = new ArrayList<Cloth>();

    private MemoryStorage(){}

    public static List<Cloth> getAllClothes(){
        return clothes;
    }

    public static Cloth getCloth(int i){
        return clothes.get(i);
    }

    public static boolean addCloth(String name, char size, double price){
        return clothes.add(new Cloth(name, size, price));
    }

    public static int getCountOfClothes(){
        return clothes.size();
    }

}
