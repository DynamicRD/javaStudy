package com.kh.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filePath ="D:\\JavaStudy\\studentMVCProject\\src\\db.properties";
		Properties pt = new Properties();
		pt.load(new FileReader(filePath));
		String id = pt.getProperty("id");
		String pw = pt.getProperty("pw");
		
	}

}
