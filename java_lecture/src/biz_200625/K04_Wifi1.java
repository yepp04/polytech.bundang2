package biz_200625;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//BIZ프로그래밍 8강 File 실습 200625 강진성
public class K04_Wifi1 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\두개를 써야한다
		File k04_f = new File("c:\\users\\kopo\\desktop\\data\\전국무료와이파이표준데이터.txt");
		// 파일 변수 생성
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 읽어들임
		File k04_f1 = new File("c:\\users\\kopo\\desktop\\data\\전국무료와이파이표준데이터_SKT.txt");
		// 새로운 파일변수 1 생성 (SKT)
		File k04_f2 = new File("c:\\users\\kopo\\desktop\\data\\전국무료와이파이표준데이터_KT.txt");
		// 새로운 파일변수 2 생성 (KT)
		File k04_f3 = new File("c:\\users\\kopo\\desktop\\data\\전국무료와이파이표준데이터_LGU.txt");
		// 새로운 파일변수 3 생성 (LGU)
		BufferedWriter k04_bw1 = new BufferedWriter(new FileWriter(k04_f1));
		// 버퍼라이터로 이 파일에다가 쓴다
		BufferedWriter k04_bw2 = new BufferedWriter(new FileWriter(k04_f2));
		// 버퍼라이터로 이 파일에다가 쓴다
		BufferedWriter k04_bw3 = new BufferedWriter(new FileWriter(k04_f3));
		// 버퍼라이터로 이 파일에다가 쓴다

		String k04_readtxt; // 스트링 변수 생성
		// 한 줄을 먼저 읽어야 필드명을 알 수 있다
		if ((k04_readtxt = k04_br.readLine()) == null) {
			// 더이상 읽을 줄이 없으면
			System.out.printf("빈 파일입니다\n");
			// 출력
			return;
		}
		// 첫 줄은 모든 파일에 다 쓴다
		k04_bw1.write(k04_readtxt);
		k04_bw1.newLine();// 개행 입력
		k04_bw2.write(k04_readtxt);
		k04_bw2.newLine();// 개행 입력
		k04_bw3.write(k04_readtxt);
		k04_bw3.newLine();// 개행 입력

		int k04_LineCnt = 0; // 몇번째인지 확인하는 변수
		while ((k04_readtxt = k04_br.readLine()) != null) {
			// 읽을 줄이 있으면
			String[] k04_field = k04_readtxt.split("\t");
			// 탭으로 글자를 자름
			if (k04_field[5].trim().equals("SKT")) {
				// 5번째 필드가 SKT이면
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT, LGU+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT, KT\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"미래창조과학부(SKT, KT, LGU+)\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT, KT, U+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("SK, KT, LG U+")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT,KT,U+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("서울특별시청-SKT")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("SKT/LGU+")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT, LG\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT,LGU+,경기도 광주시청\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT,LGU+,경기도광주시청\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT,U+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT,경기도 광주시청\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("SK텔레콤")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT, KT, LGU+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SK, KT, LGU+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SK,KT,LG\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SK, KT, LG U+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SK,KT,LGU+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"SKT,KT,LGU+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("SK")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("sk텔레콤")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("㈜SK텔레콤")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
			} else if (k04_field[5].trim().equals("KT")) {
				// 5번째 필드가 KT이면
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT, SKT, LGU+\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT, SKT\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT,SKT\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "KT";
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("서울특별시청-KT")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("㈜KT")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT, LGU+\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT,LG\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT,U+\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"시흥시청,㈜케이티\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("KT올레")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("㈜케이티")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"강원도 고성군청, KT\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"KT, 하남시\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
			} else if (k04_field[5].trim().equals("KT/LGU+")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("KT,LG")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LGU+")) {
				// 5번째 필드가 LGU+이면
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"LGU+,KT\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LGU+,SKT")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"LGU+,SKT\"")) {
				k04_field[5] = "SKT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw1.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw1.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("서울특별시청-LGU+")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LGT")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"강원도 고성군청, LGU+\"")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("\"LGU+, KT\"")) {
				k04_field[5] = "KT";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw2.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw2.newLine(); // 개행
				k04_field[5] = "LGU+";
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LG")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("Lgu+")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LG U+")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LG U +")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("강원도 고성군청, LGU+")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("(주)엘지유플러스")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("LGU")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else if (k04_field[5].trim().equals("U+")) {
				k04_field[5] = "LGU+";
				k04_readtxt = Arrays.toString(k04_field).replaceAll(",", "\t").replace("[", "").replace("]", "");
				k04_bw3.write(k04_readtxt); // 한 줄을 쓴다
				k04_bw3.newLine(); // 개행
			} else { // 이것들이 아니면
				System.out.printf("알 수 없는 통신사[%d번째 항목][%s]***\n", k04_LineCnt, k04_field[5]);
				// 소속되지 않은 통신사 출력
			}
			k04_LineCnt++; // 번호 1 추가
		}
		k04_br.close();// 버퍼리더 닫기
		k04_bw1.close(); // SKT버퍼라이터1 닫기
		k04_bw2.close(); // KT버퍼라이터2 닫기
		k04_bw3.close(); // LGU+버퍼라이터3 닫기
	}
}
