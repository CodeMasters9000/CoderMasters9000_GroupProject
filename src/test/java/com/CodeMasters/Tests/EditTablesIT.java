package com.CodeMasters.Tests;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.ui.Model;


import com.CodeMasters_9000.controller_CodeMasters_9000.EditTable_Feature_ControllerClass;
import com.CodeMasters_9000.model_CodeMasters_9000.Table;

public class EditTablesIT {

	
	EditTable_Feature_ControllerClass cc;

	@BeforeAll
	public void before() {
		this.cc = new EditTable_Feature_ControllerClass();
	}
	
	
	@Test
	public void test() {
		
		int id = 4;
		Table t = new Table();
		t.setTableID(id);
		t.setReservationID("000");
		t.setServerID("002");
		t.setBillID("000000");
		t.setReservationTime("2020-11-05 18:44");
		t.availableTime();
		
		
		HttpSession session = null;
		Model model = null;
		cc.editTable(t, model, session, id);
		
		assertSame(model.getAttribute("table"), t);
		
		
		
	}

}
