package com.clothes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clothes")
public class Cloth implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clothes_id_seq")
    @SequenceGenerator(sequenceName = "clothes_id_seq", name = "clothes_id_seq")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private char size;

    @Column(name = "price")
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
