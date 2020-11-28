package com.CodeMasters_9000.controller_CodeMasters_9000;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage_ControllerClass {

	@RequestMapping("/")
	public String homePage(ModelMap model) {

		return "homePage";
	}

}