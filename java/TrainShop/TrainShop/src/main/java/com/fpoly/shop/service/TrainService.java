package com.fpoly.shop.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.fpoly.shop.dto.SearchTrainObject;
import com.fpoly.shop.dto.TrainDTO;
import com.fpoly.shop.entities.Train;



public interface TrainService {
	
 List<Train> getLatestTrain();
 	Train save(TrainDTO sp);

 	Train update(TrainDTO sp);

	void deleteById(long id);

	Page<Train> getAllTrainByFilter(SearchTrainObject object, int page, int limit);

	Train getTrainById(long id);
	
	Iterable<Train> getTrainByTrainNameWithoutPaginate(SearchTrainObject object);
	
	Page<Train> getTrainByTrainName(SearchTrainObject object,int page, int resultPerPage);
	
	List<Train> getAllTrainByList(Set<Long> idList);
	
	Page<Train> getTrainByTrainNameForAdmin(String trainName, int page, int size);
	
	Iterable<Train> getTrainByNameCategory(String brand);
	
	public Page<Train> getTrainByBrand(SearchTrainObject object, int page, int resultPerPage);
}
