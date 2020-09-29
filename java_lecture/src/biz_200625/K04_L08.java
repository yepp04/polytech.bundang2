package biz_200625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_L08 {
	public static void main(String[] args) throws IOException {
		File k04_f = new File("c:\\users\\kopo\\desktop\\sw\\기업업무프로그래밍\\day_data\\THTSKS010H00.dat");
		// 파일 변수 생성
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 파일 읽어들임
		File k04_f1 = new File("c:\\users\\kopo\\desktop\\StockDailyPrice.csv");
		// 새로 쓸 파일 변수 f1 생성
		BufferedWriter k04_bw1 = new BufferedWriter(new FileWriter(k04_f1));
		// 버퍼라이터를 통해 f1에 내용을 쓸 예정
		String k04_readtxt; // 스트링 변수 선언

		int k04_cnt = 0; // 전체 카운트 변수
		int k04_wcnt = 0; // 쓰기 카운트 변수
		while ((k04_readtxt = k04_br.readLine()) != null) {
			// 한 줄을 읽었을 때 null값이 아니면 반복
			StringBuffer k04_s = new StringBuffer(); // 스트링버퍼 변수 생성
			String[] k04_field = k04_readtxt.split("%_%"); // %_%로 구분한 값을 field배열에 저장

			if (k04_field.length > 2 && k04_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				// 자른값의 3번째값에 ^와 공백을 제거하고 처음값이 A이면
				k04_s.append(k04_field[0].replace("^", "").trim()); // 1번째배열값에 ^과 공백 제거후 버퍼에 추가
				for (int k04_i = 1; k04_i < k04_field.length; k04_i++) { // 배열길이만큼 for문 실행
					k04_s.append("," + k04_field[k04_i].replace("^", "").trim()); // 콤마와 필드의 각값에 ^과 공백 제거후 버퍼 추가
				}
				k04_bw1.write(k04_s.toString()); // 스트링버퍼s를 스트링으로 변환후 버퍼라이터에 씀
				k04_bw1.newLine(); // 개행입력
				k04_wcnt++; // 쓰기 카운트 1 추가
				System.out.printf("write [%d][%d][%s]\n", k04_cnt, k04_wcnt, k04_s.toString());
				// 카운트와 변환된 스트링값s를 출력
			}
			k04_cnt++; // 전체 카운트 1 추가
		}
		k04_br.close(); // 버퍼리더 닫기
		k04_bw1.close(); // 버퍼라이터 닫기
		System.out.printf("Program End[%d][%d]records\n", k04_cnt, k04_wcnt);
		// 전부 입력 완료 했을 때 출력
	}
}
