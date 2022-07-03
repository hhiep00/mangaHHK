package com.pro.manga.controller.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.manga.domain.User;
import com.pro.manga.model.UserDto;
import com.pro.manga.service.UserService;

@Controller
@RequestMapping("edit-infor")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("")
	public String edit(ModelMap model) {
		return "web/account/editInfor";
	}
	
	@GetMapping("{username}")
	public ModelAndView edit(ModelMap model, @PathVariable("username") String username) {
		Optional<User> opt = userService.findByUsername(username);
		UserDto dto=new UserDto();
		if(opt.isPresent()) {
			User entity=opt.get();
			BeanUtils.copyProperties(entity, dto);
			
			model.addAttribute("user", dto);
			
			return new ModelAndView("web/account/editInfor", model);
		}
		model.addAttribute("message", "User is not existed");
		
		return new ModelAndView("forward:/web/account/editInfor", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("user") UserDto dto,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("web/account/editInfor");
		}
		User entity=new User();
		BeanUtils.copyProperties(dto, entity);
		
		userService.save(entity);
		model.addAttribute("message", "User is saved");
		return new ModelAndView("forward:/web/account/editInfor", model);
	}
}
