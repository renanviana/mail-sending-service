package com.renzvi.mss.factory;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements Closeable {

	private static final ThreadLocal<Connection> conn = new ThreadLocal<>();

	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getInstance() throws SQLException {
		if (conn.get() == null || conn.get().isClosed()) {
			conn.set(DriverManager.getConnection("jdbc:h2:~/.mail-sending-service-db"));
		}
		conn.get().setAutoCommit(true);
		return conn.get();
	}

	@Override
	public void close() throws IOException {
		if (conn.get() != null) {
			try {
				conn.get().close();
				conn.set(null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
