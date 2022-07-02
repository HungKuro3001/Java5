package com.fpoly.shop.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.fpoly.shop.dto.AccountDTO;
import com.fpoly.shop.entities.Role;
import com.fpoly.shop.entities.User;



public interface UserService {

	User findByEmail(String email);

	User findByConfirmationToken(String confirmationToken);

	User saveUserForMember(User nd);

	User findById(Long id);

	User updateUser(User nd);

	void changePass(User nd, String newPass);

	Page<User> getUserByRole(Set<Role> role, int page);

	List<User> getUserByRole (Set<Role> vaiTro);
	
	User saveUserForAdmin(AccountDTO dto);

	void deleteById(long id);

}
