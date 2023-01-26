package com.example;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;

public class PetController {
    PetService petService;
    Javalin app;
    public PetController(){
        petService = new PetService();
        app = Javalin.create();
    }
    public void startAPI(){
        // an endpoint is a dynamic pattern/method/formatting for a way to contact 
        // this server on a particular URL 
        // a developer can write a single enpoint that is able to service an entire API/Application

        // get(String path, Handler handler, RouteRole... roles) : Javalin
        // -> this a Lambda expression and it is used to pass methods that define
        // dynamic behavior with this syntax 
        app.get("/pet/", ctx -> 
        {
            System.out.println("contacting endpoint /pet");
            //ctx.result("something");
            List<Pet> pets = petService.getAllPets();
            ctx.json(pets);
        }
        );
        app.post("/pet/", ctx -> 
        {
           // Pet pet = new Pet();
            // pet.setName("Fido");
            //pet.setSpecies("dog");

            // for debuggging - let's see what the request body looks like
            System.out.println(ctx.body());
            // create something called an object mapper from Jackson databind (from maven)
            ObjectMapper om = new ObjectMapper();
            // use the objectmapper to convert the request body's JSON into a usable java object
            Pet pet = om.readValue(ctx.body(), Pet.class);
            petService.insertPet(pet);

        }
        );
        app.get("/pet/{name}", ctx -> {
            String petName = ctx.pathParam("name");
            Pet pet =petService.getPetByName(petName);
            ctx.json(pet);

        }
        );

        app.start(9001);

    }
    
}
