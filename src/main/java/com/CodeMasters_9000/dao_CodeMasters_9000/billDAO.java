package com.CodeMasters_9000.dao_CodeMasters_9000;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.CodeMasters_9000.model_CodeMasters_9000.BillMapper;
import com.CodeMasters_9000.model_CodeMasters_9000.Server;
import com.CodeMasters_9000.model_CodeMasters_9000.Bill;

@Component
public class billDAO {
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL = "SELECT * FROM bill";
	private final String SQL_CREATE_BILL = "INSERT INTO bill (billID, reservationID, serverID,itemsOrdered,itemsComped,subtotal, tip, isPaid, seatTime, leaveTime) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_GET_SERVERS = "SELECT * FROM SERVER";
	@Autowired
	public billDAO(DataSource dataSource)	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Bill> getAllBills()	{
		return jdbcTemplate.query(SQL_GET_ALL, new BillMapper());
		
	}
	public List<Server> getAllServers()	{
		return jdbcTemplate.query(SQL_GET_SERVERS, new ServerMapper());
		
	}
	public boolean createBill(Bill newBill) {
		    Date date = java.sql.Timestamp.valueOf(LocalDateTime.now());
		    Date date2 = new Date(0);
		return jdbcTemplate.update(SQL_CREATE_BILL,  String.format("%06d", getBillCount()), String.format("%03d", Integer.parseInt(newBill.getReservationID()))  , String.format("%03d", Integer.parseInt(newBill.getServerID())) ,"","",0,0,false, date, date2 )>0;
	}
	public int getBillCount() {
		List<Bill> billList = jdbcTemplate.query(SQL_GET_ALL, new BillMapper());
		ArrayList<Integer> billIDs = new ArrayList<>();
		for(Bill b: billList) {
			billIDs.add(Integer.parseInt(b.getBillID()));
		}
		return Collections.max(billIDs)+1;
	}
}
