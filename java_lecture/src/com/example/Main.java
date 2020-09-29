package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Hero hero = new Hero("홍길동", 75, 18);

		// 용사를 직렬화 하여 저장
		FileOutputStream fos = new FileOutputStream("save.dat"); // save.dat내용을 꺼내는 인스턴스
		ObjectOutputStream oos = new ObjectOutputStream(fos);// 마샬링 해준다
		oos.writeObject(hero); // 이 인스턴스 안에 hero 내용을 쓴다
		oos.flush(); // 입력한다
		oos.close(); // 닫는다

		// 용사를 복원
		FileInputStream fis = new FileInputStream("save.dat"); // save.dat내용을 입력하는 인스턴스
		ObjectInputStream ois = new ObjectInputStream(fis); // 마샬링 해준다
		Hero hero2 = (Hero) ois.readObject(); // 이 인스턴스 안에 hero를 언마샬링해서 hero2에 넣는다
		ois.close(); // 닫는다
		System.out.println(hero2); // 출력한다
	}
}
