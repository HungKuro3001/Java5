package com.fpoly.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.QTrain;
import com.fpoly.shop.dto.SearchTrainObject;
import com.fpoly.shop.dto.TrainDTO;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.repository.CategoryRepository;
import com.fpoly.shop.repository.ManufacturerRepository;
import com.fpoly.shop.repository.TrainRepository;
import com.fpoly.shop.service.TrainService;
import com.querydsl.core.BooleanBuilder;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository trainRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	// đổi từ SanPhamDto sang đối tượng SanPham để add vào db
	public Train convertFromSanPhamDto(TrainDTO dto) {
		Train train = new Train();
		if (!dto.getId().equals("")) {
			train.setId(dto.getId());
		}
		train.setName(dto.getName());
		train.setPrice(dto.getPrice());
		// set createdDate getDate now
		train.setCategory(categoryRepository.findById(dto.getIdCategory()).get());
		train.setManufacturer(manufacturerRepository.findById(dto.getIdManufacturer()).get());

		train.setCreatedDate(dto.getCreatedDate());
		train.setSeatNumber(dto.getSeatNumber());
		train.setQuantity(dto.getQuantity());
		train.setCarriageNumber(dto.getCarriageNumber());
		train.setLength(dto.getLength());
		
		train.setType(dto.getType());

		return train;
	}

	@Override
	public Train save(TrainDTO dto) {
		Train sp = convertFromSanPhamDto(dto);
		System.out.println(sp);
		return trainRepository.save(sp);
	}

	@Override
	public Train update(TrainDTO dto) {
		return trainRepository.save(convertFromSanPhamDto(dto));
	}

	@Override
	public void deleteById(long id) {
		trainRepository.deleteById(id);

	}

	@Override
	public Page<Train> getAllTrainByFilter(SearchTrainObject object, int page, int limit) {
		BooleanBuilder builder = new BooleanBuilder();
		String price = object.getPrice();

		// sắp xếp theo giás
		Sort sort = Sort.by(Direction.ASC, "price"); // mặc định tăng dần
		if (object.getSort().equals("desc")) { // giảm dần
			sort = Sort.by(Direction.DESC, "price");
		}

		if (!object.getIdCategory().equals("") && object.getIdCategory() != null) {
			builder.and(QTrain.train.category.eq(categoryRepository.findById(Long.parseLong(object.getIdCategory())).get()));
		}

		if (!object.getIdManufacturer().equals("") && object.getIdManufacturer() != null) {
			builder.and(QTrain.train.manufacturer
					.eq(manufacturerRepository.findById(Long.parseLong(object.getIdManufacturer())).get()));
		}

		// tim theo don gia
		switch (price) {
		case "duoi-200-trieu":
			builder.and(QTrain.train.price.lt(200000000));
			break;

		case "200-trieu-den-400-trieu":
			builder.and(QTrain.train.price.between(200000000, 400000000));
			break;

		case "400-trieu-den-600-trieu":
			builder.and(QTrain.train.price.between(400000000, 600000000));
			break;

		case "600-trieu-den-900-trieu":
			builder.and(QTrain.train.price.between(600000000, 900000000));
			break;

		case "tren-900-trieu":
			builder.and(QTrain.train.price.gt(900000000));
			break;

		default:
			break;
		}
		return trainRepository.findAll(builder, PageRequest.of(page, limit, sort));
	}

	@Override
	public List<Train> getLatestTrain() {
		return trainRepository.findFirst12ByDanhMucTenDanhMucContainingIgnoreCaseOrderByIdDesc("Train");
	}

	public Iterable<Train> getTrainByTrainNameWithoutPaginate(SearchTrainObject object) {
		BooleanBuilder builder = new BooleanBuilder();
		int resultPerPage = 12;
		String[] keywords = object.getKeyword();
		String sort = object.getSort();
		String price = object.getPrice();
		// Keyword
		builder.and(QTrain.train.name.like("%" + keywords[0] + "%"));
		if (keywords.length > 1) {
			for (int i = 1; i < keywords.length; i++) {
				builder.and(QTrain.train.name.like("%" + keywords[i] + "%"));
			}
		}
		// Muc gia
		switch (price) {
		case "duoi-200-trieu":
			builder.and(QTrain.train.price.lt(200000000));
			break;

		case "200-trieu-den-400-trieu":
			builder.and(QTrain.train.price.between(200000000, 400000000));
			break;

		case "400-trieu-den-600-trieu":
			builder.and(QTrain.train.price.between(400000000, 600000000));
			break;

		case "600-trieu-den-900-trieu":
			builder.and(QTrain.train.price.between(600000000, 900000000));
			break;

		case "tren-900-trieu":
			builder.and(QTrain.train.price.gt(900000000));
			break;

		default:
			break;
		}
		return trainRepository.findAll(builder);
	}

	@Override
	public Train getTrainById(long id) {
		return trainRepository.findById(id).get();
	}

	// Tim kiem san pham theo keyword, sap xep, phan trang, loc theo muc gia, lay 12
	// san pham moi trang
	@Override
	public Page<Train> getTrainByTrainName(SearchTrainObject object, int page, int resultPerPage) {
		BooleanBuilder builder = new BooleanBuilder();
//		int resultPerPage = 12;
		String[] keywords = object.getKeyword();
		String sort = object.getSort();
		String price = object.getPrice();
		String brand = object.getBrand();
		String manufactor = object.getManufactor();
		// Keyword
		builder.and(QTrain.train.name.like("%" + keywords[0] + "%"));
		if (keywords.length > 1) {
			for (int i = 1; i < keywords.length; i++) {
				builder.and(QTrain.train.name.like("%" + keywords[i] + "%"));
			}
		}
		// Muc gia
		switch (price) {
		case "duoi-200-trieu":
			builder.and(QTrain.train.price.lt(200000000));
			break;

		case "200-trieu-den-400-trieu":
			builder.and(QTrain.train.price.between(200000000, 400000000));
			break;

		case "400-trieu-den-600-trieu":
			builder.and(QTrain.train.price.between(400000000, 600000000));
			break;

		case "600-trieu-den-900-trieu":
			builder.and(QTrain.train.price.between(600000000, 900000000));
			break;

		case "tren-900-trieu":
			builder.and(QTrain.train.price.gt(900000000));
			break;

		default:
			break;
		}

		// Danh muc va hang san xuat
		if (brand.length()>1) {
			builder.and(QTrain.train.category.nameCategory.eq(brand));
		}
		if (manufactor.length()>1) {
			builder.and(QTrain.train.manufacturer.nameManufacturer.eq(manufactor));
		}

		// Sap xep
		if (sort.equals("newest")) {
			return trainRepository.findAll(builder, PageRequest.of(page - 1, resultPerPage, Sort.Direction.DESC, "id"));
		} else if (sort.equals("priceAsc")) {
			return trainRepository.findAll(builder, PageRequest.of(page - 1, resultPerPage, Sort.Direction.ASC, "donGia"));
		} else if (sort.equals("priceDes")) {
			return trainRepository.findAll(builder, PageRequest.of(page - 1, resultPerPage, Sort.Direction.DESC, "donGia"));
		}
		return trainRepository.findAll(builder, PageRequest.of(page - 1, resultPerPage));
	}

	public List<Train> getAllTrainByList(Set<Long> idList) {
		return trainRepository.findByIdIn(idList);
	}

	@Override
	public Page<Train> getTrainByTrainNameForAdmin(String name, int page, int size) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QTrain.train.name.like("%" + name + "%"));
		return trainRepository.findAll(builder, PageRequest.of(page, size));
	}
	
	
	@Override
	public Iterable<Train> getTrainByNameCategory(String brand) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QTrain.train.category.nameCategory.eq(brand));
		return trainRepository.findAll(builder);
	}
	
	@Override
	public Page<Train> getTrainByBrand(SearchTrainObject object, int page, int resultPerPage) {
		BooleanBuilder builder = new BooleanBuilder();
		String price = object.getPrice();
		String brand = object.getBrand();
		String manufactor = object.getManufactor();
		String seatNumber = object.getSeatNumber();
		String carrierNumber = object.getCarrierNumber();
		String length = object.getLength();
		// Muc gia
		switch (price) {
		case "duoi-200-trieu":
			builder.and(QTrain.train.price.lt(200000000));
			break;

		case "200-trieu-den-400-trieu":
			builder.and(QTrain.train.price.between(200000000, 400000000));
			break;

		case "400-trieu-den-600-trieu":
			builder.and(QTrain.train.price.between(400000000, 600000000));
			break;

		case "600-trieu-den-900-trieu":
			builder.and(QTrain.train.price.between(600000000, 900000000));
			break;

		case "tren-900-trieu":
			builder.and(QTrain.train.price.gt(900000000));
			break;

		default:
			break;
		}

		// Danh muc va hang san xuat
		if (brand.length()>1) {
			builder.and(QTrain.train.category.nameCategory.eq(brand));
		}
		if (manufactor.length()>1) {
			builder.and(QTrain.train.manufacturer.nameManufacturer.eq(manufactor));
		}
		

		return trainRepository.findAll(builder, PageRequest.of(page - 1, resultPerPage));
	}






}
