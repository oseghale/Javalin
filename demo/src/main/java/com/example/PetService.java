package com.example;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    List<Pet> allPets;
    public PetService() {
        allPets = new ArrayList();
    }
    public List<Pet> getAllPets(){
        return allPets;
    }
    public void insertPet(Pet pet){
        allPets.add(pet);
    }
    
    
}
