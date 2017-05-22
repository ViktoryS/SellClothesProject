package com.clothes.model;

public class ClothBuilder {

    private Cloth cloth;
    private static long clothIds = 1;

    public ClothBuilder() {
        cloth = new Cloth();
        //cloth.setId(clothIds++);
    }

    public ClothBuilder buildName(String name) {
        cloth.setName(name);
        return this;
    }

    public ClothBuilder buildSize(Character size) {
        cloth.setSize(size);
        return this;
    }

    public ClothBuilder buildPrice(Double price) {
        cloth.setPrice(price);
        return this;
    }

    public Cloth buildCloth() {
        return this.cloth;
    }

    public static void setClothId(long id){
        clothIds = id;
    }
}

