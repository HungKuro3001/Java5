package com.example.lab56.repositories;

import com.example.lab56.entities.Train;
import com.example.lab56.entities.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;


public interface ITrainRepository extends JpaRepository <Train, Integer> {
    List<Train> findByType(TrainType type);
}
