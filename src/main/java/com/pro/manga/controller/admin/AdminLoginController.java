package com.pro.manga.controller.admin;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.manga.domain.User;
import com.pro.manga.model.UserDto;
import com.pro.manga.service.UserService;

@Controller
@RequestMapping("admin/login")
public class AdminLoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("login")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("user") UserDto dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/web/home", model);
		}
		
//		User user = userService.login(dto.getUsername(), dto.getPassword());
//		if(user==null) {
//			model.addAttribute("message", "invalid username or password");
//			return new ModelAndView("/web/home", model);
//		}
//		
//		session.setAttribute("username", user.getUsername());
		return new ModelAndView("forward:/admin/mangas", model);
	}
}
