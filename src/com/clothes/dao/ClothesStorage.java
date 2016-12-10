package com.clothes.dao;

import com.clothes.model.Cloth;

import java.util.ArrayList;
import java.util.List;

public class ClothesStorage {

    private static List<Cloth> clothes = new ArrayList<Cloth>();

    private ClothesStorage() {
    }

    public static List<Cloth> getAllClothes() {
        return clothes;
    }

    public static Cloth getCloth(int i) {
        return clothes.get(i);
    }

    public static Cloth getCloth(String name) {
        for (Cloth cloth: ClothesStorage.getAllClothes())
            if(name.equals(cloth.getName()))
                return cloth;
        return null;
    }

    public static boolean addCloth(Cloth cloth) {
        return clothes.add(cloth);
    }

    public static boolean isEmpty() {
        return clothes.isEmpty();
    }

    public static boolean removeCloth(Cloth cloth){
        return clothes.remove(cloth);
    }

    public static List<Cloth> getClohesByName(String param){
        List<Cloth> listClothes = new ArrayList<>();
        for (Cloth cloth: ClothesStorage.getAllClothes()){
            if(cloth.getName().equalsIgnoreCase(param) || cloth.getName().contains(param))
                listClothes.add(cloth);
        }
        return listClothes;
    }
}
