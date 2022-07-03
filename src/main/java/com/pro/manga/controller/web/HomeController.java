package com.pro.manga.controller.web;

import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.manga.domain.Manga;
import com.pro.manga.domain.User;
import com.pro.manga.model.UserDto;
import com.pro.manga.service.MangaService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	MangaService mangaService;
	
	@RequestMapping("")
	public String menu(ModelMap model) {
		List<Manga> list=mangaService.findAll();
		
		model.addAttribute("user", new UserDto());
		model.addAttribute("mangas", list);
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println(username);
		
		boolean checkLogin=true;
		if(username.equals("anonymousUser"))
			checkLogin=false;
		model.addAttribute("check", checkLogin);
		model.addAttribute("username", username);
		return "web/home";
	}
}
