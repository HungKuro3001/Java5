package com.example.lab56.services;

import com.example.lab56.entities.Train;
import com.example.lab56.entities.TrainType;
import com.example.lab56.repositories.ITrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
    @Autowired
    private ITrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }



    public void saveTrain(Train train) {
        //set created date now dd/MM/yyyy
        train.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
        trainRepository.save(train);
    }

    public Optional<Train> getTrainById(int id) {
         return trainRepository.findById(id);
    }

    public void delete(Integer id){
        trainRepository.deleteById(id);
    }
    public void deleteById(Integer[] ids){
        trainRepository.findAllById(Arrays.asList(ids));
    }
    public void deleteAll(List<Integer> ids){
        List<Train> trains = trainRepository.findAllById(ids);
        trainRepository.deleteAll(trains);
    }
    // get all train with pagable
    // create a method get train by type
    public List<Train> getTrainByType(TrainType type){
        return trainRepository.findByType(type);
    }

}
