package com.fpoly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.Role;
import com.fpoly.shop.repository.RoleRepository;
import com.fpoly.shop.service.RoleService;



@Service
public class RoleServiceImpl implements RoleService{
	

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByNameRole(String nameRole) {
		return roleRepository.findByNameRole(nameRole);
	}

	@Override
	public List<Role> findAllVaiTro() {
		return roleRepository.findAll();
	}


}
