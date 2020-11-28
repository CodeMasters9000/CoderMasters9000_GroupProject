package com.CodeMasters_9000.controller_CodeMasters_9000;

import java.util.ArrayList;
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
import com.CodeMasters_9000.dao_CodeMasters_9000.TableDAO;
import com.CodeMasters_9000.model_CodeMasters_9000.Server;
import com.CodeMasters_9000.model_CodeMasters_9000.Table;

@Controller
public class EditTable_Feature_ControllerClass {
	@Autowired
	TableDAO tDAO;
	@Autowired
	ServerDao sDao;
	private int id;

	@GetMapping("/tables")
	public String tablesMap(@ModelAttribute("table") Table table, Model model, HttpSession session) {

		List<Table> Tables = tDAO.getAllTables();
		List<Table> availableTables = new ArrayList<Table>();
		List<Table> unavailableTables = new ArrayList<Table>();

		for (Table t : Tables) {
			if (t.getIsAvailable()) {
				availableTables.add(t);
			} else {
				unavailableTables.add(t);
			}
		}
		model.addAttribute("availableTables", availableTables);
		model.addAttribute("unavailableTables", unavailableTables);
		model.addAttribute("tableModel", table);
		return "tables";
	}

	@GetMapping("/editTable")
	public String editTable(@ModelAttribute("table") Table table, Model model, HttpSession session,
			@RequestParam(required = true) int id) {

		this.id = id;
		model.addAttribute("id", id);
		table = tDAO.getOneTable(id);
		model.addAttribute("table", table);
		List<Server> servers = sDao.getAllServers();
		model.addAttribute("serverList", servers);

		return "editTable";
	}

	@PostMapping("/editTable")
	public String changeStatus(@ModelAttribute("table") Table table, Model model, @RequestParam("time") String time,
			@RequestParam("date") String date, @RequestParam("ReservationID") String reservationID,
			@RequestParam("serverID") String serverID, @RequestParam("billID") String billID,
			@RequestParam("isAvailable") boolean isAvailable) {

		String dateTime = date.concat(" ".concat(time));

		table = tDAO.getOneTable(this.id);
		table.setReservationTime(dateTime);
		table.setReservationID(reservationID);
		table.setServerID(serverID);
		table.setBillID(billID);
		table.setIsAvailable(isAvailable);
		table.availableTime();

		if (tDAO.editTable(table)) {
			model.addAttribute("message", "A new table is unavailable");

		} else {
			model.addAttribute("dangerMessage", "Failed to add the table");
		}

		List<Table> tables = tDAO.getAllTables();
		List<Table> availableTables = new ArrayList<Table>();
		List<Table> unavailableTables = new ArrayList<Table>();

		for (Table t : tables) {
			if (t.getIsAvailable()) {
				availableTables.add(t);
			} else {
				unavailableTables.add(t);
			}
		}
		model.addAttribute("availableTables", availableTables);
		model.addAttribute("unavailableTables", unavailableTables);
		model.addAttribute("tableModel", table);
		return "tables";

	}

	@GetMapping("/editUnavailable")
	public String editUnavailable(@ModelAttribute("table") Table table, Model model, HttpSession session,
			@RequestParam(required = true) int id) {

		this.id = id;
		model.addAttribute("id", id);
		table = tDAO.getOneTable(id);
		model.addAttribute("table", table);
		List<Server> servers = sDao.getAllServers();
		model.addAttribute("serverList", servers);

		return "editUnavailable";

	}

	@PostMapping("/editUnavailable")
	public String changeUnavailable(@ModelAttribute("table") Table table, Model model,
			@RequestParam("time") String time, @RequestParam("date") String date,
			@RequestParam("ReservationID") String reservationID, @RequestParam("serverID") String serverID,
			@RequestParam("billID") String billID, @RequestParam("isAvailable") boolean isAvailable) {

		String dateTime = date.concat(" ".concat(time));

		table = tDAO.getOneTable(this.id);
		table.setReservationTime(dateTime);
		table.setReservationID(reservationID);
		table.setServerID(serverID);
		table.setBillID(billID);
		table.setIsAvailable(isAvailable);

		if (tDAO.editTable(table)) {
			model.addAttribute("message", "Table is available again");

		} else {
			model.addAttribute("dangerMessage", "Couldnt make the table available");
		}

		List<Table> tables = tDAO.getAllTables();
		List<Table> availableTables = new ArrayList<Table>();
		List<Table> unavailableTables = new ArrayList<Table>();

		for (Table t : tables) {
			if (t.getIsAvailable()) {
				availableTables.add(t);
			} else {
				unavailableTables.add(t);
			}
		}
		model.addAttribute("availableTables", availableTables);
		model.addAttribute("unavailableTables", unavailableTables);
		model.addAttribute("tableModel", table);
		return "tables";

	}
}
