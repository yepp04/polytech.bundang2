package biz_200625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_FileReadWrite {

	public static void k04_FileWrite() throws IOException {
		File k04_f = new File("c:\\users\\kopo\\Mytest2.txt");
		// 파일 변수 생성 및 파일 경로 입력
		BufferedWriter k04_bw = new BufferedWriter(new FileWriter(k04_f));
		// 버퍼라이터로 파일을 쓰고 파일로 저장시키는 인스턴스 생성
		k04_bw.write("안녕 파일");// 내용 쓰기
		k04_bw.newLine(); // 개행
		k04_bw.write("hello 헬로"); // 내용 쓰기
		k04_bw.newLine(); // 개행

		k04_bw.close(); // 버퍼라이터 닫기
	}

	public static void k04_FileRead() throws IOException {
		File k04_f = new File("c:\\users\\kopo\\Mytest2.txt");
		// 파일 변수 생성 및 파일 경로 입력
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 파일을 읽고 출력시키는 인스턴스 생성
		String k04_readtxt; // 스트링 변수 선언

		while ((k04_readtxt = k04_br.readLine()) != null) {
			// 읽을게 있으면
			System.out.printf("%s\n", k04_readtxt);
			// 그 줄 출력하기
		}
		k04_br.close(); // 버퍼리더 닫기
	}

	public static void main(String[] args) throws IOException {
		k04_FileWrite(); // 파일쓰기 메서드 실행
		k04_FileRead(); // 파일 읽기 메서드 실행
	}
}
