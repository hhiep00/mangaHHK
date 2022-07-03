package com.pro.manga.controller.admin;

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
@RequestMapping("admin/users")
public class AdminUserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("user", new UserDto());
		return "admin/users/addOrEdit";
	}
	
	@GetMapping("edit/{username}")
	public ModelAndView edit(ModelMap model, @PathVariable("username") String username) {
		Optional<User> opt = userService.findByUsername(username);
		UserDto dto=new UserDto();
		System.out.println(opt.isPresent());
		if(opt.isPresent()) {
			User entity=opt.get();
			BeanUtils.copyProperties(entity, dto);
			
			model.addAttribute("user", dto);
			
			return new ModelAndView("admin/users/addOrEdit", model);
		}
		model.addAttribute("message", "User is not existed");
		
		return new ModelAndView("forward:/admin/users/list", model);
	}
	
//	@GetMapping("delete/{username}")
//	public ModelAndView delete(ModelMap model,
//			@PathVariable("username") String username) {
//		
//		userService.deleteByUsername(username);
//		model.addAttribute("message", "User is deleted");
//		return new ModelAndView("forward:/admin/user/addOrEdit", model);
//	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("user") UserDto dto,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("admin/users/addOrEdit");
		}
		User entity=new User();
		BeanUtils.copyProperties(dto, entity);
		
//		userService.save(entity);
		model.addAttribute("message", "User is saved");
		return new ModelAndView("forward:/admin/users", model);
	}
	
	@RequestMapping("")
	public String search(ModelMap model) {
		List<User> list = userService.findAll();
		model.addAttribute("users", list);
		return "admin/users/list";
	}
	
	
	
	
	
	
	
	
}
