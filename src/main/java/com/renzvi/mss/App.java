package com.renzvi.mss;

import com.renzvi.mss.config.DatabaseInitialize;

public class App {
	
	public static void main(String[] args) {
		
		// create tables if not exists
		DatabaseInitialize.createTables();
		
	}
	
}
