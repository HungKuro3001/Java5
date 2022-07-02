package com.example.lab56.services;

import com.example.lab56.entities.Train;
import org.springframework.data.domain.Page;

public interface ITrainService {
    Page<Train> getByPage(int pageNumber, int maxRecord);
}
