package com.fpoly.shop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.shop.entities.Role;
import com.fpoly.shop.entities.User;



public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	Page<User> findByRole(Set<Role> role, Pageable page);

	List<User> findByRole(Set<Role> vaiTro);
}
