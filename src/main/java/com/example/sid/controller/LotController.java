package com.example.sid.controller;

import com.example.sid.model.Lot;
import com.example.sid.repository.LotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lots")
public class LotController {

    private final LotRepository lotRepository;

    public LotController(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    @GetMapping
    public List<Lot> getAllLots() {
        return lotRepository.findAll();
    }

    @PostMapping
    public Lot createLot(@RequestBody Lot lot) {
        return lotRepository.save(lot);
    }
}
