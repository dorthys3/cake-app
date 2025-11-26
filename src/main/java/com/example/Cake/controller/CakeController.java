package com.example.Cake.controller;

import com.example.Cake.model.Cake;
import com.example.Cake.service.CakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/cakes")
public class CakeController {

    private final CakeService service;

    public CakeController(CakeService service) {
        this.service = service;
    }

    // Get all cakes
    @GetMapping
    public List<Cake> getAllCakes() {
        return service.getAll();
    }

    // Search cakes by name
    @GetMapping("/search")
    public List<Cake> searchCakes(@RequestParam String name) {
        return service.searchByName(name);
    }
}
