package com.fpoly.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fpoly.shop.entities.*;
import com.fpoly.shop.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.fpoly.shop.entities.User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User with email " + username + " was not be found");
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Role> role = user.getRole();
		for (Role roles : role) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roles.getNameRole()));
		}
		return new User(username, user.getPassword(), grantedAuthorities);
	}

}
