package com.CodeMasters_9000.controller_CodeMasters_9000;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.CodeMasters_9000.dao_CodeMasters_9000.billDAO;
import com.CodeMasters_9000.model_CodeMasters_9000.*;
@Controller

public class ControllerClass{
	@Autowired
	billDAO bDAO;
	@ModelAttribute("newBill")
	public Bill setupAddForm()	{
		return new Bill();
	}
	@GetMapping("/bills")
	public String bills(HttpSession session, Model model) {
		List<Bill> bills = bDAO.getAllBills();
		model.addAttribute("billList", bills);
		System.out.println(bills.get(0).getLeaveTime());
		return ("bills");
	}
	
	@PostMapping("/createBill")
	 public String createBill(@ModelAttribute("newBill") Bill
	createBill, Model model) {

		 bDAO.createBill(createBill);

	 List<Bill> bills = bDAO.getAllBills();
	 model.addAttribute("billList", bills);

	 return "bills";
	 }
 
}