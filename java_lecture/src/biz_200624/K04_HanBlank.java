package biz_200624;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_HanBlank {

	public static String k04_HanBlankForeword(String k04_txt, int k04_space) {
		String k04_str = ""; // str값 초기화
		StringBuffer k04_sb = new StringBuffer(k04_str);
		int k04_byteSum = 0; // 물건 이름 바이트 계산 위한 변수 선언
		for (int k04_j = 0; k04_j < k04_txt.length(); k04_j++) { // 물건 이름길이만큼 for문 실행
			if (k04_txt.substring(k04_j, k04_j + 1).matches("^[ㄱ-ㅎ가-힣]*$")) { // 각 글자가 한글이면
				k04_byteSum = k04_byteSum + 2; // 바이트에 2 추가
			} else { // 한글이 아니면
				k04_byteSum++; // 1 추가
			}
		}
		for (int k04_i = 0; k04_i < k04_space - k04_byteSum; k04_i++) {
			// 공간에서 바이트를 빼준 값만큼
			k04_sb.append(" "); // 띄어쓰기 추가
		}
		k04_sb.append(k04_txt);// 띄어쓰기된 str값에 txt값 추가
		k04_str = k04_sb.toString(); // 스트링버퍼 str을 string값으로 변경
		return k04_str; // str 리턴
	}

	public static String k04_HanBlankBackword(String k04_txt, int k04_space) {
		String k04_str = ""; // str값 초기화
		StringBuffer k04_sb = new StringBuffer(k04_str);
		int k04_byteSum = 0; // 물건 이름 바이트 계산 위한 변수 선언
		for (int k04_j = 0; k04_j < k04_txt.length(); k04_j++) { // 물건 이름길이만큼 for문 실행
			if (k04_txt.substring(k04_j, k04_j + 1).matches("^[ㄱ-ㅎ가-힣]*$")) { // 각 글자가 한글이면
				k04_byteSum = k04_byteSum + 2; // 바이트에 2 추가
			} else { // 한글이 아니면
				k04_byteSum++; // 1 추가
			}
		}
		k04_sb.append(k04_txt); // 먼저 txt값을 입력
		for (int k04_i = 0; k04_i < k04_space - k04_byteSum; k04_i++) {
			// 공간에서 바이트를 빼준 값만큼
			k04_sb.append(" "); // 띄어쓰기 추가
		}
		k04_str = k04_sb.toString(); // 스트링버퍼 str을 string값으로 변경
		return k04_str; // str 리턴
	}

	public static int k04_HanCount(String k04_txt) {
		int k04_hanCount = 0; // 한글숫자 계산 0부터 시작
		for (int k04_j = 0; k04_j < k04_txt.length(); k04_j++) { // txt길이만큼 for문 실행
			if (k04_txt.substring(k04_j, k04_j + 1).matches("^[ㄱ-ㅎ가-힣]*$")) { // 각 글자가 한글이면
				k04_hanCount++; // 한글 개수 1 추가
			}
		}
		return k04_hanCount; // 숫자 리턴
	}

	public static void main(String[] args) {
		System.out.printf("HanBlankForeword[%s]\n", k04_HanBlankForeword("한글abcd", 15));
		// 공간이 15일때 띄어쓰기 먼저 + String 값 합해서 15
		System.out.printf("HanBlankForeword[%s]\n", k04_HanBlankForeword("한글한글aa", 15));
		// 공간이 15일때 띄어쓰기 먼저 + String 값 합해서 15
		System.out.printf("HanBlankBackword[%s]\n", k04_HanBlankBackword("한글aa", 15));
		// 공간이 15일때 String 먼저 + 띄어쓰기 값 합해서 15
		System.out.printf("HanBlankBackword[%s]\n", k04_HanBlankBackword("한글한글aa", 15));
		// 공간이 15일때 String 먼저 + 띄어쓰기 값 합해서 15
		System.out.printf("한글은 [%d]개\n", k04_HanCount("한글한글aa"));
		// 글자에서 한글개수 세서 출력
	}
}
