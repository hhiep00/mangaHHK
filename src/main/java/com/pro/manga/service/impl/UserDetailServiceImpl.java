package com.pro.manga.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pro.manga.domain.Account;
import com.pro.manga.domain.User;
import com.pro.manga.service.AccountService;
import com.pro.manga.service.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user=userService.findByUsername(username).get();
//		System.out.println(user);
//		
//		if(user==null) {
//			throw new UsernameNotFoundException("khong thay");
//		}
//		return new MyUserDetail(user);
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user=userService.findByUsername(username).get();
		Account account=accountService.findByUsername(username).get();
//		System.out.println(user);
		System.out.println(account);
		String role="";
		if(account.getIsAdmin()) {
			role="ADMIN";
		}else {
			role="USER";
		}
		List<SimpleGrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		
		UserDetails userDetails= new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), authorities);
		
		return userDetails;
	}

}
