package com.fpoly.shop.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fpoly.shop.dto.AccountDTO;
import com.fpoly.shop.entities.Role;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.repository.RoleRepository;
import com.fpoly.shop.repository.UserRepository;
import com.fpoly.shop.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByConfirmationToken(String confirmationToken) {
		return null;
	}

	@Override
	public User saveUserForMember(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> setRole = new HashSet<>();
		setRole.add(roleRepository.findByNameRole("ROLE_MEMBER"));
		user.setRole(setRole);
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void changePass(User user, String newPass) {
		user.setPassword(bCryptPasswordEncoder.encode(newPass));
		userRepository.save(user);
	}

	@Override
	public Page<User> getUserByRole(Set<Role> role,  int page) {
		return userRepository.findByRole(role, PageRequest.of(page - 1, 6));
	}

	@Override
	public List<User> getUserByRole(Set<Role> role) {
		return userRepository.findByRole(role);
	}

	@Override
	public User saveUserForAdmin(AccountDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setAddress(dto.getAddress());
		user.setEmail(dto.getEmail());
		user.setSdt(dto.getSdt());
		user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		
		Set<Role> role  = new HashSet<>();
		role.add(roleRepository.findByNameRole(dto.getRoleName()));
		user.setRole(role);
		
		return userRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

}
