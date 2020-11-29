package com.CodeMasters_9000.controller_CodeMasters_9000;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.CodeMasters_9000.dao_CodeMasters_9000.billDAO;
import com.CodeMasters_9000.model_CodeMasters_9000.Bill;
import com.CodeMasters_9000.model_CodeMasters_9000.Reservation;
import com.CodeMasters_9000.model_CodeMasters_9000.Server;

@Controller
public class Bill_Feature_ControllerClass {

	@Autowired
	billDAO bDAO;

	@ModelAttribute("newBill")
	public Bill setupAddForm() {
		return new Bill();
	}

	@GetMapping("/bills")
	public String bills(HttpSession session, Model model) {
		String str = "";
		if (session.getAttribute("id") != null) {
		List<Bill> bills = bDAO.getAllBills();
		List<Server> servers = bDAO.getAllServers();
		List<Reservation> reservations = bDAO.getAllReservations();
		model.addAttribute("serverList", servers);
		model.addAttribute("resList", reservations);
		model.addAttribute("billList", bills);
		str = "bills";
		}else {
			str = "login";
		}
		return str;
	}

	@PostMapping("/createBill")
	public String createBill(@ModelAttribute("newBill") Bill createBill, Model model) {

		bDAO.createBill(createBill);

		List<Bill> bills = bDAO.getAllBills();
		List<Server> servers = bDAO.getAllServers();
		List<Reservation> reservations = bDAO.getAllReservations();
		model.addAttribute("serverList", servers);
		model.addAttribute("resList", reservations);
		model.addAttribute("billList", bills);

		return "bills";
	}
}
