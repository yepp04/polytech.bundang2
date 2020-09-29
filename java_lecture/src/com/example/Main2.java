package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Main2 {
	public static void main(String[] args) throws IOException {
		Reader fr = new FileReader("gradle.properties"); // gradle프로퍼티파일을 읽는 fr 인스턴스
		Properties prop = new Properties(); // 프로퍼티 읽기쓰기를 위한 새로운 인스턴스
		prop.load(fr); // fr을 로딩한다
		String read = prop.getProperty("android.useAndroidX"); // fr안의 android.use~의 값을 넣는다
		System.out.println(read);// read 값을 출력한다
		fr.close(); // 닫는다
	}
}
