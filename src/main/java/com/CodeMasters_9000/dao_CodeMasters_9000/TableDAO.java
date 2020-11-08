package com.CodeMasters_9000.dao_CodeMasters_9000;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.CodeMasters_9000.model_CodeMasters_9000.Server;
import com.CodeMasters_9000.model_CodeMasters_9000.Table;
import com.CodeMasters_9000.model_CodeMasters_9000.TableMapper;

@Component
public class TableDAO {

	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL = "SELECT * FROM TABLES";
	
	private final String SQL_EDIT_TABLE = "UPDATE TABLES SET RESERVATIONID = ?, SERVERID = ?, BILLID = ?, "
			+ "AVAILABLETIME = ? WHERE TABLEID = ? ";
	
	
	
	@Autowired
	public TableDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public Table getOneTable(int id) {
		List<Table> list = getAllTables();
		Table t = new Table();
		for(Table table : list) {
			if((table.getTableID()) == id) {
				t = table;
			}
		}
		return t;
	}
	public List<Table> getAllTables(){
		return jdbcTemplate.query(SQL_GET_ALL, new TableMapper());
	}
	

	
	
	public boolean editServer(Table newTable) {
		return jdbcTemplate.update(SQL_EDIT_TABLE, newTable.getReservationID(), newTable.getServerID(), 
				newTable.getBillID(), newTable.getIsAvailable(), newTable.getTableID()) > 0;
	}
	
	
	

	
}
