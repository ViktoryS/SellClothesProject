package com.clothes.model;

public class ClothBuilder {
    private Cloth cloth;

    public ClothBuilder(){
        cloth = new Cloth();
    }

    public ClothBuilder buildName(String name){
        cloth.setName(name);
        return this;
    }

    public ClothBuilder buildSize(Character size){
        cloth.setSize(size);
        return this;
    }

    public ClothBuilder buildPrice(Double price){
        cloth.setPrice(price);
        return this;
    }

    public Cloth buildCloth(){
        return this.cloth;
    }
}

