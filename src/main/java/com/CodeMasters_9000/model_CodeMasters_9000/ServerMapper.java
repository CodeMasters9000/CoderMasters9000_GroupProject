package com.CodeMasters_9000.model_CodeMasters_9000;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class ServerMapper implements RowMapper<Server>{
	public Server mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		Server server = new Server();
		bill.setBillID(resultSet.getString("billID"));
		bill.setReservationID(resultSet.getString("reservationID"));
		bill.setServerID(resultSet.getString("serverID"));
		bill.setItemsOrdered(resultSet.getString("itemsOrdered"));
		bill.setItemsComped(resultSet.getString("itemsComped"));
		bill.setSubtotal(resultSet.getFloat("subTotal"));
		bill.setTip(resultSet.getFloat("tip"));
		bill.setTotal(resultSet.getFloat("total"));
		bill.setIsPaid(resultSet.getBoolean("isPaid"));
		LocalDateTime dateTime = LocalDateTime.of(resultSet.getDate("seatTime").toLocalDate(),  resultSet.getTime("seatTime").toLocalTime());
		Date d = java.sql.Timestamp.valueOf(dateTime);
		bill.setSeatTime(d);
		dateTime = LocalDateTime.of(resultSet.getDate("leaveTime").toLocalDate(),  resultSet.getTime("leaveTime").toLocalTime());
		d = java.sql.Timestamp.valueOf(dateTime);
		bill.setLeaveTime(d);
		return server;
	}
}