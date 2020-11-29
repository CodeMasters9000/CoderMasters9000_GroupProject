package com.CodeMasters_9000.controller_CodeMasters_9000;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodeMasters_9000.dao_CodeMasters_9000.ServerDao;

@Controller
public class Login_Feature_ControllerClass {
	@Autowired
	ServerDao sDao;
	
	private static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.reset();
		
		byte[] hash = md.digest(data.getBytes());
		return bytesToStringHex(hash);

	}

	private static String bytesToStringHex(byte[] hash) {
		char[] hexChars = new char[hash.length * 2];
		for (int i = 0; i < hash.length; i++) {
			int v = hash[i] & 0xFF;
			hexChars[i * 2] = hexArray[v >>> 4];
			hexChars[i * 2 + 1] = hexArray[v & 0x0F];

		}
		return new String(hexChars);
	}

	@RequestMapping("/")
	public String homePage(ModelMap model) {

		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "id") String id, @RequestParam(name = "password") String password,
			HttpSession session, Model model) {
		String str = null;
		String passFromDataBase = sDao.getPassword(id);
		try {
			if(passFromDataBase.equals(generateHash(password, "md5"))) {
				session.setAttribute("password", password);
				session.setAttribute("id", id);
				str = "homePage";
			}else {
				model.addAttribute("message", "Invalid Credentials");
				str = "login";
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	
	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("password");
		return "login";
	}
	

}
