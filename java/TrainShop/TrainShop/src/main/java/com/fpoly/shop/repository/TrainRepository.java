package com.fpoly.shop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.fpoly.shop.entities.Train;



public interface TrainRepository extends JpaRepository<Train, Long>, QuerydslPredicateExecutor<Train>{

	
	List<Train> findFirst12ByDanhMucTenDanhMucContainingIgnoreCaseOrderByIdDesc(String category);
	List<Train> findByIdIn(Set<Long> idList);
}
