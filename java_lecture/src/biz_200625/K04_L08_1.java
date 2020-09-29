package biz_200625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_L08_1 {
	public static void main(String[] args) throws IOException {
		File k04_f = new File("c:\\users\\kopo\\desktop\\StockDailyPrice.csv");
		// 파일 변수 생성
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 파일 읽어들임
		File k04_f1 = new File("c:\\users\\kopo\\desktop\\A005930.csv");
		// 삼성전자 단축코드 A005930만 추출하여 입력할 변수 생성
		BufferedWriter k04_bw1 = new BufferedWriter(new FileWriter(k04_f1));
		// 버퍼라이터를 통해 f1에 내용을 쓸 예정
		String k04_readtxt; // 스트링 변수 선언

		int k04_cnt = 0; // 카운트 변수
		int k04_wcnt = 0; // 카운트 변수
		while ((k04_readtxt = k04_br.readLine()) != null) {
			// 한 줄을 읽었을 때 null값이 아니면 반복
			StringBuffer k04_s = new StringBuffer(); // 스트링버퍼 변수 생성
			String[] k04_field = k04_readtxt.split(","); // ,로 구분한 값을 field배열에 저장

			if (k04_field.length > 2 && k04_field[2].equals("A005930")) {
				// k04필드 3번째가 A005930일 때
				k04_s.append(k04_field[0]);// 1번째배열값 추가
				for (int k04_i = 1; k04_i < k04_field.length; k04_i++) { // 배열길이만큼 for문 실행
					k04_s.append("," + k04_field[k04_i]); // 버퍼 추가
				}
				k04_bw1.write(k04_s.toString()); // 스트링버퍼s를 스트링으로 변환후 버퍼라이터에 씀
				k04_bw1.newLine(); // 개행입력
				k04_wcnt++; // 카운트 1 추가
				System.out.printf("write [%d][%d][%s]\n", k04_cnt, k04_wcnt, k04_s.toString());
				// 카운트와 변환된 스트링값s를 출력
			}
			k04_cnt++; // 카운트 1 추가
		}
		k04_br.close(); // 버퍼리더 닫기
		k04_bw1.close(); // 버퍼라이터 닫기
		System.out.printf("Program End[%d][%d]records\n", k04_cnt, k04_wcnt);
		// 전부 입력 완료 했을 때 출력
	}
}