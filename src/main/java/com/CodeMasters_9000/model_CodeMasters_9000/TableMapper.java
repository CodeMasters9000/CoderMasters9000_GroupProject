package com.CodeMasters_9000.model_CodeMasters_9000;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TableMapper implements RowMapper<Table>{
	public Table mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		Table t = new Table();
		t.setTableID(resultSet.getInt("tableID"));
		t.setReservationID(resultSet.getInt("reservationID"));
		t.setServerID(resultSet.getInt("serverID"));
		t.setBillID(resultSet.getInt("billID"));
		t.setSeats(resultSet.getInt("seats"));
		t.setReservationTime(resultSet.getDate("reservationTime"));
		t.setAvailableTime(resultSet.getDate("availableTime"));
		t.setIsAvailable(resultSet.getBoolean("isAvailable"));

		return t;
	}
}