package com.CodeMasters_9000.model_CodeMasters_9000;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReservationMapper implements RowMapper<Reservation>{
	public Reservation mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		Reservation reservation = new Reservation();
		reservation.setReservationID(resultSet.getString("reservationID"));
		reservation.setNoOfPeople(resultSet.getString("noOfPeople"));
		reservation.setEmail(resultSet.getString("email"));
		reservation.setName(resultSet.getString("name"));
		return reservation;
	}
}