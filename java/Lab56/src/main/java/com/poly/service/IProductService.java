package com.poly.service;

import java.util.List;

import com.poly.entity.Train;
import com.poly.entity.TrainType;

public interface IProductService extends IGenaralService<Train> {
	int pagecount();
	int count();
	List<Train> deletes(List<Integer> ids);
	List<Train> findByType(TrainType type,Integer page);
	int pagecountByType(TrainType type);
	int countByType(TrainType type);
}
