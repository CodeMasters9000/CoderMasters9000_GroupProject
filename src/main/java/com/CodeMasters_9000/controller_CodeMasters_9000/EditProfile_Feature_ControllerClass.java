package com.CodeMasters_9000.controller_CodeMasters_9000;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodeMasters_9000.dao_CodeMasters_9000.ServerDao;
import com.CodeMasters_9000.model_CodeMasters_9000.Server;

@Controller
public class EditProfile_Feature_ControllerClass {
	@Autowired
	ServerDao sDao;

	@GetMapping("/editProfilePage")
	public String editProfilePage(HttpSession session, Model model, @ModelAttribute("server") Server server) {
		List<Server> servers = sDao.getAllServers();

		model.addAttribute("serverList", servers);

		return "editProfile";
	}

	@PostMapping("/editProfile")
	public String editElements(@ModelAttribute("server") Server server, Model model) {
		sDao.editServer(server, false);
		List<Server> servers = sDao.getAllServers();

		model.addAttribute("serverList", servers);
		model.addAttribute("serverModel", server);
		model.addAttribute("message", "Information changed for " + server.getServerName());

		return "editProfile";
	}

	@GetMapping("/changePass")
	public String changePassPage(@ModelAttribute("server") Server server, Model model, HttpSession session) {
		List<Server> servers = sDao.getAllServers();

		model.addAttribute("serverList", servers);
		model.addAttribute("serverModel", server);

		return "changePass";
	}

	@PostMapping("/changePassword")
	public String changeSubmitted(@ModelAttribute("server") Server server, Model model,
			@RequestParam(name = "newPass") String newPass, @RequestParam(name = "confirmPass") String confirmPass,
			@RequestParam(name = "previousPass") String prePass, @RequestParam(name = "ID") String serverId) {

		if (sDao.setPass(serverId, prePass, newPass, confirmPass)) {

			model.addAttribute("message", "Password changed!");
			List<Server> servers = sDao.getAllServers();
			model.addAttribute("serverList", servers);
			return "changePass";

		} else {
			model.addAttribute("dangerMessage", "Wrong information entered ");
			return "changePass";
		}
	}
}
