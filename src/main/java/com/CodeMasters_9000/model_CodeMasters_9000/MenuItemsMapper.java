package com.CodeMasters_9000.model_CodeMasters_9000;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MenuItemsMapper implements RowMapper<MenuItems>{
	public MenuItems mapRow(ResultSet resultSet, int i) throws SQLException	{
		
		MenuItems menuItems = new MenuItems();
		menuItems.setItemID(resultSet.getString("itemID"));
		menuItems.setName(resultSet.getString("name"));
		menuItems.setCost(resultSet.getFloat("cost"));
		return menuItems;
	}
}