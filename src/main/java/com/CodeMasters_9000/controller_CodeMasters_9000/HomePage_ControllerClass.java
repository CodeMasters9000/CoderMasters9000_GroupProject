package com.CodeMasters_9000.controller_CodeMasters_9000;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage_ControllerClass {

	@GetMapping("/homePage")
	public String homePage(ModelMap model, HttpSession session) {
		String str = "";
		if (session.getAttribute("id") != null) {
			str = "homePage";
		} else {
			str = "login";
		}

		return str;
	}

}