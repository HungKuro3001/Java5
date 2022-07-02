package com.fpoly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.shop.entities.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByNameRole(String roleName);
}
