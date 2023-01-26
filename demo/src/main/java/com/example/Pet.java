package com.example;

public class Pet {
    String name;
    String species;
    // the tools we'll be using today require no-args default constructor
    // it's needed to automatically convert to/from JSON
    public Pet(){

    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species){
        this.species = species;
    }
}
