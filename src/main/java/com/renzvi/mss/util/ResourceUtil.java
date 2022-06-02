package com.renzvi.mss.util;

import java.io.IOException;
import java.io.InputStream;

public class ResourceUtil {

	public static String getFileAsString(String fileName) {
		String result = null;
		try (InputStream is = ResourceUtil.class.getClassLoader().getResourceAsStream(fileName)) {
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			result = new String(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
}
