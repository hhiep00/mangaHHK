package com.pro.manga.controller.web;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.manga.domain.Account;
import com.pro.manga.domain.User;
import com.pro.manga.model.UserDto;
import com.pro.manga.service.AccountService;
import com.pro.manga.service.UserService;

@Controller
@RequestMapping("register")
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("")
	public String register(ModelMap model) {
		model.addAttribute("user", new UserDto());
		return "web/account/register";
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("user") UserDto dto
			) {
		
		
		User entity=new User();
		BeanUtils.copyProperties(dto, entity);
		
		entity.setIsAdmin(false);
		entity.setSex(false);
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodeP=encoder.encode(entity.getPassword());
		entity.setPassword(encodeP);
		
		Account account =new Account();
		account.setIsAdmin(false);
		account.setUsername(entity.getUsername());
		account.setPassword(entity.getPassword());
		
		accountService.save(account);
		userService.save(entity);
		model.addAttribute("message", "User is saved");
		return new ModelAndView("forward:/login", model);
	}
}
