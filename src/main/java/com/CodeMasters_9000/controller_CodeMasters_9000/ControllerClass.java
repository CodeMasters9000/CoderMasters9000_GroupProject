package com.CodeMasters_9000.controller_CodeMasters_9000;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.CodeMasters_9000.dao_CodeMasters_9000.ServerDao;
import com.CodeMasters_9000.dao_CodeMasters_9000.TableDAO;
import com.CodeMasters_9000.dao_CodeMasters_9000.billDAO;
import com.CodeMasters_9000.model_CodeMasters_9000.*;
@Controller

public class ControllerClass{
	@Autowired
	billDAO bDAO;
	@Autowired
	ServerDao sDao;
	@Autowired
	TableDAO tDAO;
	
	
	@ModelAttribute("newBill")
	public Bill setupAddForm()	{
		return new Bill();
	}
	@GetMapping("/bills")
	public String bills(HttpSession session, Model model) {
		List<Bill> bills = bDAO.getAllBills();
		List<Server> servers = bDAO.getAllServers();
		List<Reservation> reservations = bDAO.getAllReservations();
		model.addAttribute("serverList", servers);
		model.addAttribute("resList", reservations);
		model.addAttribute("billList", bills);
		return ("bills");
	}
	
	@PostMapping("/createBill")
	 public String createBill(@ModelAttribute("newBill") Bill
	createBill, Model model) {

		 bDAO.createBill(createBill);

	 List<Bill> bills = bDAO.getAllBills();
	List<Server> servers = bDAO.getAllServers();
	List<Reservation> reservations = bDAO.getAllReservations();
	model.addAttribute("serverList", servers);
	model.addAttribute("resList", reservations);
	 model.addAttribute("billList", bills);

	 return "bills";
	 }
	
	
	@GetMapping("/editProfilePage")
	public String editProfilePage(HttpSession session, Model model, @ModelAttribute("server") Server server) {
		List<Server> servers = sDao.getAllServers();
		
		model.addAttribute("serverList", servers);
		
		return "editProfile";
	}
	
	
	@PostMapping("/editProfile")
	public String editElements( @ModelAttribute("server") Server server, Model model) {
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
	public String changeSubmitted(@ModelAttribute("server") Server server, Model model, @RequestParam(name = "newPass")
	String newPass, @RequestParam(name = "confirmPass") String confirmPass, @RequestParam(name = "previousPass") String prePass,
	@RequestParam(name = "ID") String serverId) {
		
		if(sDao.setPass(serverId, prePass, newPass, confirmPass)){
			
			
			model.addAttribute("message", "Password changed!" );
			List<Server> servers = sDao.getAllServers();
			model.addAttribute("serverList", servers);
			return "changePass";
			
			
		}else {
			model.addAttribute("dangerMessage", "Wrong information entered ");
			return "changePass";
		}
	}
	
	
	@GetMapping("/tables")
	public String tablesMap(@ModelAttribute("table") Table table, Model model, HttpSession session) {
		
		
		List<Table> Tables = tDAO.getAllTables();
		List<Table> availableTables = new ArrayList<Table>();
		List<Table> unavailableTables = new ArrayList<Table>();
		
		for(Table t : Tables) {
			if(t.getIsAvailable()) {
				availableTables.add(t);
			}else {
				unavailableTables.add(t);
			}
		}
		model.addAttribute("availableTables", availableTables);
		model.addAttribute("unavailableTables", unavailableTables);
		model.addAttribute("tableModel", table);
		return "tables";
	}
	
	@GetMapping("/editTable")
	public String editTable(@ModelAttribute("table") Table table, Model model, HttpSession session, @RequestParam(required = true) int id) {
		
		model.addAttribute("id", id);
		table = tDAO.getOneTable(id);
		model.addAttribute("table", table);
		List<Server> servers = sDao.getAllServers();
		model.addAttribute("serverList", servers);
		
		return "editTable";
	}
	
	
	
 
}