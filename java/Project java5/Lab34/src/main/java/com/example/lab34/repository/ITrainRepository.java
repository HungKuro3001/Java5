package com.example.lab34.repository;

import com.example.lab34.entities.Train;
import com.example.lab34.entities.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrainRepository extends JpaRepository<Train,Integer> {
    List<Train> findByNameLike(String name);
    List<Train> findByType(TrainType type);
    List<Train> findTrainById(Integer id);






}
