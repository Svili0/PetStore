package com.petstore.demo.service;

import com.petstore.demo.dao.PetDao;
import com.petstore.demo.model.Pet;
import com.petstore.demo.repository.PetRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    private final PetDao petDao;
    @Autowired
    private final PetRepositoryInterface petInterface;

//    @Autowired
//    public PetService(@Qualifier("fakeDao") PetDao petDao) {
//        this.petDao = petDao;
//    }
//
    public int addPet(Pet pet){
        return petDao.insertPet(pet);
    }

    public List<Pet> getAllPets(){
        return petDao.selectAllPets();
    }

    public Optional<Pet> getPetById(UUID id) {
        return petDao.selectPetById(id);
    }

    public int deletePet(UUID id){
        return petDao.deletePetById(id);
    }

    public int updatePet(UUID id, Pet newPet){
        return petDao.updatePetById(id, newPet);
    }

}
