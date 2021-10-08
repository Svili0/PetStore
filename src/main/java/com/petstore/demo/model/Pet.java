package com.petstore.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Pet {
    private final UUID id;
    private final String name;
    private final double price;
    private final String category;
    private final int age;
    private final String breed;

    public Pet(@JsonProperty("id") UUID id,
               @JsonProperty("name") String name,
               @JsonProperty("price") double price,
               @JsonProperty("category") String category,
               @JsonProperty("age") int age,
               @JsonProperty("breed") String breed) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.age = age;
        this.breed = breed;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }
}
