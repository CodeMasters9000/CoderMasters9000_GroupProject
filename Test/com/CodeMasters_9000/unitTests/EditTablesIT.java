package com.CodeMasters_9000.unitTests;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.CodeMasters_9000.controller_CodeMasters_9000.ControllerClass;
import com.CodeMasters_9000.dao_CodeMasters_9000.TableDAO;
import com.CodeMasters_9000.model_CodeMasters_9000.Table;
import com.CodeMasters_9000.model_CodeMasters_9000.TableMapper;

public class EditTablesIT {

	
	ControllerClass cc;

	@Before
	public void before() {
		this.cc = new ControllerClass();
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
