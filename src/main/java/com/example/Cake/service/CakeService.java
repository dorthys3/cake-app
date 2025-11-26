package com.example.Cake.service;


import com.example.Cake.model.Cake;
import com.example.Cake.repository.CakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {

    private final CakeRepository repo;

    public CakeService(CakeRepository repo){
        this.repo = repo;
    }
    public List<Cake> getAll(){
        return repo.findAll();
}

    public List<Cake> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}
