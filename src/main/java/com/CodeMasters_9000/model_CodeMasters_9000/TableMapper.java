package com.CodeMasters_9000.model_CodeMasters_9000;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TableMapper implements RowMapper<Table>{
	public Table mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		Table t = new Table();
		t.setTableID(resultSet.getInt("tableID"));
		t.setReservationID(resultSet.getString("reservationID"));
		t.setServerID(resultSet.getString("serverID"));
		t.setBillID(resultSet.getString("billID"));
		t.setSeats(resultSet.getString("seats"));
		t.setReservationTime(resultSet.getString("reservationTime"));
		t.setAvailableTime(resultSet.getString("availableTime"));
		t.setIsAvailable(resultSet.getBoolean("isAvailable"));

		return t;
	}
}