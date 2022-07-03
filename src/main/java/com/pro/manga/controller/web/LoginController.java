package com.pro.manga.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.manga.model.UserDto;

@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping("")
	public String login(Model model) {
		return "web/account/login";
	}
}
