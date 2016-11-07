package com.clothes.entities.clothbuilder;

public class ClothBuilder {
    private Cloth cloth;

    public void buildNewCloth(){
        cloth = new Cloth();
    }

    public void buildNewCloth(String name, Character size, Double price){
        cloth = new Cloth(name, size, price);
    }

    public void buildName(String name){
        cloth.setName(name);
    }

    public void buildSize(Character size){
        cloth.setSize(size);
    }

    public void buildPrice(Double price){
        cloth.setPrice(price);
    }
}

