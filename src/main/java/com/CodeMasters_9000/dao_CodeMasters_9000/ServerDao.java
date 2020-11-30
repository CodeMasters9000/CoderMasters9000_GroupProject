package com.CodeMasters_9000.dao_CodeMasters_9000;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import com.CodeMasters_9000.controller_CodeMasters_9000.Login_Feature_ControllerClass;
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

	public String getPassword(String id) {
		List<Server> list = getAllServers();
		String password = "";
		for (Server server : list) {
			if (server.getServerID().equals(id)) {
				password = server.getPassword();
			}
		}
		return password;
	}

	public String getOneServer(int id) {
		List<Server> list = getAllServers();
		String name = "";
		for (Server server : list) {
			if (Integer.parseInt(server.getServerID()) == id) {
				name = server.getServerName();
			}
		}
		return name;
	}
	public String getPhoneNumber(int id) {
		List<Server> list = getAllServers();
		String phone = "";
		for (Server server : list) {
			if (Integer.parseInt(server.getServerID()) == id) {
				phone = server.getPhoneNumber();
			}
		}
		return phone;
	}

	public List<Server> getAllServers() {
		return jdbcTemplate.query(SQL_GET_ALL, new ServerMapper());
	}

	public boolean createServer(Server newServer) {
		newServer.setPassword("default");
		return jdbcTemplate.update(SQL_CREATE_SERVER, newServer.getServerID(), newServer.getServerName(),
				newServer.getAssignedTables(), newServer.getPhoneNumber()) > 0;
	}

	public boolean deleteServer(int serverId) {
		return jdbcTemplate.update(SQL_DELETE_SERVER, serverId) > 0;
	}

	public boolean editServer(Server newServer, boolean isHost) {
		return jdbcTemplate.update(SQL_EDIT_SERVER, newServer.getServerName(), newServer.getPhoneNumber(), isHost,
				newServer.getServerID()) > 0;
	}

	public boolean setPass(String Id, String oldPass, String newPass, String confirmPass)
			throws NoSuchAlgorithmException {
		boolean flag = false;
		List<Server> serverList = getAllServers();
		String oldHash = Login_Feature_ControllerClass.generateHash(oldPass, "md5");
		for (Server server : serverList) {
			if (server.getPassword().equals(oldHash)) {
				flag = true;
			}
		}
		if (newPass.equals(confirmPass) && flag) {
			String newHash = Login_Feature_ControllerClass.generateHash(newPass, "md5");
			return jdbcTemplate.update(SQL_SETPASSWORD, newHash, Id) > 0;
		} else {
			return false;
		}
	}

}
