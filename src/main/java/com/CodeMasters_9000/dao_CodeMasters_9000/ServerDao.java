package com.CodeMasters_9000.dao_CodeMasters_9000;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.CodeMasters_9000.model_CodeMasters_9000.Server;
import com.CodeMasters_9000.model_CodeMasters_9000.ServerMapper;

@Component
public class ServerDao {

	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL = "SELECT * FROM SERVER";
	private final String SQL_CREATE_SERVER = "INSERT INTO SERVER (SERVERID, SERVERNAME, ASSIGNEDTABLES, PHONENUMBER) VALUES (?,?,?,"
			+ "?)";
	private final String SQL_DELETE_SERVER = "DELETE FROM SERVER WHERE SERVERID = ?";
	private final String SQL_EDIT_SERVER = "UPDATE SERVER SET SERVERNAME = ?, PHONENUMBER = ?, ISHOST = ? WHERE SERVERID = ? ";
	private final String SQL_SETPASSWORD = "UPDATE SERVER SET PASSWORD = ? WHERE SERVERID = ?";
	
	
	
	@Autowired
	public ServerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Server> getAllServers(){
		return jdbcTemplate.query(SQL_GET_ALL, new ServerMapper());
	}
	
	public boolean createServer(Server newServer) {
		newServer.setPassword("default");
		return jdbcTemplate.update(SQL_CREATE_SERVER, newServer.getServerID(), newServer.getServerName(), newServer.getAssignedTables(),
				newServer.getPhoneNumber() ) > 0;
	}
	
	
	public boolean deleteServer(int serverId) {
		return jdbcTemplate.update(SQL_DELETE_SERVER, serverId) > 0;
	}
	
	
	public boolean editServer(Server newServer, boolean isHost) {
		return jdbcTemplate.update(SQL_EDIT_SERVER, newServer.getServerName(), newServer.getPhoneNumber(), isHost, newServer.getServerID()) > 0;
	}
	
	
	
	public boolean setPass(String Id,String oldPass , String newPass, String confirmPass) {
		
		
		if (newPass.equals(confirmPass)) {
			
			return jdbcTemplate.update(SQL_SETPASSWORD, newPass, Id) > 0;
		}else 
		{return false;}
	}
	
}
