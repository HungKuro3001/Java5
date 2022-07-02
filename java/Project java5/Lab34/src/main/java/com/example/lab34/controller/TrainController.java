package com.example.lab34.controller;

import com.example.lab34.entities.Train;
import com.example.lab34.entities.TrainType;
import com.example.lab34.repository.ITrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainController {
    @Autowired
    private ITrainRepository trainRepository;

    @PostMapping("/train")
    public Train create(Train train) {
        return trainRepository.save(train);
    }

    //update train by id
    @PutMapping("/train/{id}")
    public Train update(Train train) {
        return trainRepository.save(train);
    }

    // Get train by id
    @GetMapping("/train/{id}")
    public List<Train> getById(@PathVariable int id) {
        return trainRepository.findTrainById(id);
    }

    // delete train by id
    @DeleteMapping("/train/{id}")
    public void delete(@PathVariable int id) {
        trainRepository.deleteById(id);
    }

    // get train by name with request param
    @GetMapping("/train")
    public List<Train> getByName(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "type", required = false) TrainType type) {
        if (type == null && name == null) {
            return trainRepository.findAll();
        } else {
            if (type == null) {
                return trainRepository.findByNameLike("%" + name + "%");
            } else {
                return trainRepository.findByType(type);
            }
        }

        // get train by type with request para
    }

}
