package com.renzvi.mss.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.renzvi.mss.factory.ConnectionFactory;
import com.renzvi.mss.util.ResourceUtil;

public class DatabaseInitialize {

	public static void createTables() {
		try (Connection conn = ConnectionFactory.getInstance();
				PreparedStatement ps = conn.prepareStatement(ResourceUtil.getFileAsString("create-tables.sql"))) {
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
