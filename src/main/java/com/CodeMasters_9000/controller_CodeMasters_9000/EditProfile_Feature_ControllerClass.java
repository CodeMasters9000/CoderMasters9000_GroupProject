package com.CodeMasters_9000.controller_CodeMasters_9000;

import java.security.NoSuchAlgorithmException;
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
		String str = "";
		if (session.getAttribute("id") != null) {
			List<Server> servers = sDao.getAllServers();
			String serverName = sDao.getOneServer(Integer.parseInt(session.getAttribute("id").toString()));
			String serverPhone = sDao.getPhoneNumber(Integer.parseInt(session.getAttribute("id").toString()));
			model.addAttribute("serverName", serverName);
			model.addAttribute("phone", serverPhone);
			model.addAttribute("serverList", servers);
			str = "editProfile";
		} else {
			str = "login";
		}
		return str;
	}

	@PostMapping("/editProfile")
	public String editElements(@ModelAttribute("server") Server server, Model model,
			@RequestParam(name = "name") String name, HttpSession session, @RequestParam(name = "phone") String phone) {

		server.setServerName(name);
		server.setServerID(session.getAttribute("id").toString());
		server.setPhoneNumber(phone);

		sDao.editServer(server, false);

		model.addAttribute("serverModel", server);
		model.addAttribute("message", "Information changed for " + server.getServerName());

		return "editProfile";
	}

	@GetMapping("/changePass")
	public String changePassPage(@ModelAttribute("server") Server server, Model model, HttpSession session) {
		String str = "";
		if (session.getAttribute("id") != null) {
			List<Server> servers = sDao.getAllServers();

			model.addAttribute("serverList", servers);
			model.addAttribute("serverModel", server);
			str = "changePass";
		} else {
			str = "login";
		}
		return str;
	}

	@PostMapping("/changePassword")
	public String changeSubmitted(@ModelAttribute("server") Server server, Model model, HttpSession session,
			@RequestParam(name = "newPass") String newPass, @RequestParam(name = "confirmPass") String confirmPass,
			@RequestParam(name = "previousPass") String prePass, @RequestParam(name = "ID") String serverId) {

		try {
			if (sDao.setPass(serverId, prePass, newPass, confirmPass)) {

				model.addAttribute("message", "Password changed!");
				List<Server> servers = sDao.getAllServers();
				model.addAttribute("serverList", servers);

			} else {
				model.addAttribute("dangerMessage", "Wrong information entered ");

			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "changePass";
	}
}
