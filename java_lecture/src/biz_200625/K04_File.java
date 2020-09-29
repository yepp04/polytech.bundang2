package biz_200625;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_File {
	public static void main(String[] args) {
		try {
			File k04_f = new File("c:\\Users\\Kopo\\Mytest.txt");
			// 파일 변수 생성 및 파일 경로 입력
			FileWriter k04_fw = new FileWriter(k04_f);
			// 파일라이터로 파일을 쓰고 파일로 저장시키는 인스턴스 생성

			k04_fw.write("안녕 파일\n"); // 이거 씀
			k04_fw.write("hello 헬로\n"); // 이거 씀

			k04_fw.close(); // filewriter 닫는다

			FileReader k04_fr = new FileReader(k04_f);
			// 파일 읽는다 아까 만들었던 k04_f 파일

			int k04_n = -1; // 인트변수 -1로 초기화
			char[] k04_ch; // 캐릭터배열 변수 선언

			while (true) { // 무한반복문
				k04_ch = new char[100]; // 캐릭터크기 100
				k04_n = k04_fr.read(k04_ch); // ch를 읽는다
				//
				if (k04_n == -1) { // 더이상 읽을 데이터가 없다
					break; // break
				}

				for (int k04_i = 0; k04_i < k04_n; k04_i++) {
					// n만큼 for문 실행
					// for (char k04_c : k04_ch) {
					System.out.printf("%c", k04_ch[k04_i]);
					// 캐릭터 출력
				}
			}
			k04_fr.close(); // 파일리더 닫기

			System.out.printf("\n FILE READ END"); // 출력
		} catch (Exception e) { // 에러 캐치
			// TODO Auto-generated catch block
			System.out.printf("나 에러[%ㄴ]\n", e);
		}
	}
}
