package com.CodeMasters_9000.model_CodeMasters_9000;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ServerMapper implements RowMapper<Server>{
	public Server mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		Server server = new Server();
		server.setServerID(resultSet.getString("serverID"));
		server.setServerName(resultSet.getString("serverName"));
		server.setAssignedTables(resultSet.getString("assignedTables"));
		server.setPhoneNumber(resultSet.getString("phoneNumber"));
		server.setPassword(resultSet.getString("password"));
		return server;
	}
}