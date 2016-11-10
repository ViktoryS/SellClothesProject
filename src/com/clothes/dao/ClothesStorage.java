package com.clothes.dao;

import com.clothes.model.Cloth;
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

    public static boolean addCloth(Cloth cloth){
        return clothes.add(cloth);
    }

    public static boolean isEmpty(){
        return clothes.isEmpty();
    }

}
