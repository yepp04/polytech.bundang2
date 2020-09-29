package biz_200625;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_L07 {
	public static void main(String[] args) throws IOException {
		File k04_f = new File("c:\\users\\kopo\\desktop\\sw\\기업업무프로그래밍\\day_data\\THTSKS010H00.dat");
		// 파일 변수 생성
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 파일 읽어들임
		String k04_readtxt; // 스트링 변수 선언
		int k04_LineCnt = 0; // 각 줄에 번호 입력인데 이걸 지금 쓸일이 없는가봄.
		int k04_n = -1; // 인트값 초기화
		StringBuffer k04_s = new StringBuffer(); // 스트링버퍼변수 선언
		while (true) { // 무한반복문
			char[] k04_ch = new char[1000]; // 캐릭터 배열 생성
			k04_n = k04_br.read(k04_ch); // 한 단어의 길이를 n에 저장, ch에 값 저장
			if (k04_n == -1) { // 읽을게 없으면
				break; // 멈춤
			}

			for (char k04_c : k04_ch) { // for문 실행
				if (k04_c == '\n') { // c가 개행이면
					System.out.printf("[%s]***\n", k04_s.toString());
					// 스트링버퍼 s를 스트링으로 변환 후 출력
					k04_s.delete(0, k04_s.length()); // 그 s값을 삭제
				} else { // 개행이 아니면
					k04_s.append(k04_c); // c값에 추가
				}
			}
			k04_LineCnt++; // 라인 1 추가
		}
		System.out.printf("[%s]***\n", k04_s.toString());
		// 그 후 s값을 스트링값으로 변환 후 출력
		k04_br.close(); // 버퍼리더 닫기
	}
}
