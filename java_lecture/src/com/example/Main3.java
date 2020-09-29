package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main3 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 총무부 리더 홍길동 41세 인스턴스 생성
		Department department = new Department("총무부", new Employee("홍길동", 41));

		// 홍길동 직렬화 하여 저장
		FileOutputStream fos = new FileOutputStream("company.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(department);
		oos.flush();
		oos.close();

		// 홍길동 복원
		FileInputStream fis = new FileInputStream("company.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Department department2 = (Department) ois.readObject();
		ois.close();
		System.out.println(department2);
	}
}
