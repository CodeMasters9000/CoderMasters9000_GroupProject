package com.CodeMasters_9000.unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.CodeMasters_9000.controller_CodeMasters_9000.ControllerClass;
import com.CodeMasters_9000.model_CodeMasters_9000.Table;


public class EditTablesTest {
	
	
	@Test
	public void test1() {
		Table t = new Table();
		t.setReservationTime("2020-11-10 14:37");
		t.availableTime();
		assertEquals("2020-11-10 16:37", t.getAvailableTime());
		
	}
	
	
	@Test
	public void test2() {
		Table t = new Table();
		t.setReservationTime("2020-11-10 20:37");
		t.availableTime();
		assertEquals("2020-11-10 22:37", t.getAvailableTime());
	}

}
