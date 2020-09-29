package biz_200625;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_L08_3 {
	public static void main(String[] args) throws IOException {
		File k04_f = new File("c:\\users\\kopo\\desktop\\A005930.csv");
		// 파일 변수 생성
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 파일 읽어들임
		String k04_readtxt; // 스트링 변수 선언
		int k04_iMax = 0; // iMax 초기화
		int k04_iMin = 9999999; // iMin 초기화

		while ((k04_readtxt = k04_br.readLine()) != null) {
			// 한 줄을 읽었을 때 null값이 아니면 반복
			String[] k04_field = k04_readtxt.split(","); // ,로 구분한 값을 field배열에 저장
			if (k04_field.length > 2 && k04_field[2].equals("A005930") && k04_field[1].substring(0, 4).equals("2005")) {
				// 필드길이 2이상, 삼성전자 2005년일 때
				if (k04_iMax < Integer.parseInt(k04_field[3])) {
					// 종가가 iMax보다 크면
					k04_iMax = Integer.parseInt(k04_field[3]);
					// iMax = 현재값
				}
				if (k04_iMin > Integer.parseInt(k04_field[3])) {
					// 종가가 iMin보다 작으면
					k04_iMin = Integer.parseInt(k04_field[3]);
					// iMin = 현재값
				}
			}

		}
		k04_br.close(); // 버퍼리더 닫기
		System.out.printf("2005년 삼성전자 종가 최대값 [%d] 최소값 [%d]\n", k04_iMax, k04_iMin);
//		// 전부 입력 완료 했을 때 출력
	}
}