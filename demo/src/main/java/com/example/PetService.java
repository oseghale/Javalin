package com.example;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    List<Pet> allPets;
    public PetService() {
        allPets = new ArrayList<>();
    }
    public List<Pet> getAllPets(){
        return allPets;
    }
    public void insertPet(Pet pet){
        allPets.add(pet);
    }
    public Pet getPetByName(String petName) {
        Pet matchingPet = null;
        for(int i = 0; i < allPets.size(); i++){
            Pet currentPet = allPets.get(i);
            // if we find a pet that matches the intended name, we should mark it as a pet 
            // that should be returned
            if(currentPet.getName().equals(petName)){
                matchingPet = currentPet;
            }

        }
        return matchingPet;
    }
    
    
}
