package com.petstore.demo.api;

import com.petstore.demo.model.Pet;
import com.petstore.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/pet")
@RestController
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }
    @PostMapping
    public void addPet(@RequestBody Pet pet){
        petService.addPet(pet);
    }

    @GetMapping
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }
    @GetMapping (path = "{id}")
    public Pet getPetById(@PathVariable("id") UUID id){
        return petService.getPetById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePetById(@PathVariable("id") UUID id) {
        petService.deletePet(id);
    }

    @PutMapping(path = "{id}")
    public void updatePet(@PathVariable("id") UUID id,  @RequestBody Pet petToUpdate) {
        petService.updatePet(id, petToUpdate);
    }
}



