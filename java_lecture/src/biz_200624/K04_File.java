package biz_200624;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_File {
	public static void main(String[] args) throws Exception {
		FileWriter k04_fw = new FileWriter("C:\\users\\kopo\\a.txt", true);
		// 저장하고자 하는 파일이름(필요한 경로도 써라)과 중복시 덮어쓰기 유무
		BufferedWriter k04_bw = new BufferedWriter(k04_fw); // 버퍼라이터 인스턴스 생성
		StringBuffer k04_sf = new StringBuffer(); // 스트링버퍼 인스턴스 생성
		BufferedReader k04_br = new BufferedReader(new InputStreamReader(System.in));
		// 버퍼리더 인스턴스를 생성하며 인풋스트림리더 생성(키보드로 입력)
		String k04_str = ""; // 스트링 값 초기화
		while (!(k04_str = k04_br.readLine()).startsWith("s")) {
			// 키보드로 타자를 치는데 s만 안쓰면 계속 칠 수 있음
			k04_sf.append(k04_str + "\n"); // 칠 때마다 str값에 더하기
		}
		k04_br.close(); // 자원해제
		k04_fw.write(k04_sf.toString()); // 스트링버퍼를 스트링형으로 변환하여 기록
		k04_fw.flush(); // 모두 입력
		k04_fw.close(); // 자원해제
		System.out.println("저장이 완료되었습니다.");
	}
}
