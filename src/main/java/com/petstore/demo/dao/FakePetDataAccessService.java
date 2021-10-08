package com.petstore.demo.dao;

import com.petstore.demo.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePetDataAccessService implements PetDao {

    private static List<Pet> DB = new ArrayList<>();

    @Override
    public int insertPet(UUID id, Pet pet) {
        DB.add(new Pet(id, pet.getName(), pet.getPrice(), pet.getCategory(), pet.getAge(), pet.getBreed()));
        return 1;
    }

    @Override
    public List<Pet> selectAllPets() {
        return DB;
    }

    @Override
    public Optional<Pet> selectPetById(UUID id) {
        return DB.stream()
                .filter(pet -> pet.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePetById(UUID id) {
        Optional<Pet> petMaybe = selectPetById(id);
        if(petMaybe.isEmpty()){
            return 0;
        }
        DB.remove(petMaybe.get());
        return 1;
    }

    @Override
    public int updatePetById(UUID id, Pet update) {
        return selectPetById(id)
                .map(pet -> {
                    int indexOfPetToUpdate = DB.indexOf(pet);
                    if (indexOfPetToUpdate >= 0){
                        DB.set(indexOfPetToUpdate, new Pet(id,
                                update.getName(),
                                update.getPrice(),
                                update.getCategory(),
                                update.getAge(),
                                update.getBreed()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}







