package com.fpoly.shop.service;

import java.util.List;

import com.fpoly.shop.entities.Role;


public interface RoleService {

	Role findByNameRole(String nameRole);
	List<Role> findAllVaiTro();
}
