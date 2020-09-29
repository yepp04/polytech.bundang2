package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200618 강진성
public class K04_CountingNumKorAdvanced {
	public static void main(String[] args) {
		int k04_iNumVal = 1000000000; // 읽을 숫자 값 지정
		String k04_sNumVal = String.valueOf(k04_iNumVal); // int -> String
		String k04_sNumVoice = ""; // sNumVoice 변수 초기화
		System.out.printf("==> %s [%d자리]\n", k04_sNumVal, k04_sNumVal.length());
		// String으로 변경된 숫자 값과 그 숫자값이 몇자리인지 출력
		int k04_i; // 변수 선언
		int k04_j; // 변수 선언

		String[] k04_units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		// 1~9 숫자 배열 삽입
		String[] k04_unitx = { "", "십", "백", "천", "만", "십", "백", "천", "억", "십" };
		// 자릿수 숫자 배열 삽입
		k04_i = 0; // i는 숫자의 자릿값과 같아지면 멈추게 하기 위한 용도
		k04_j = k04_sNumVal.length() - 1; // 자릿값을 조정하기 위한 변수

		while (true) { // 무한반복
			if (k04_i >= k04_sNumVal.length()) { // i가 자릿값보다 같거나 커지면
				break; // while 탈출
			}

			System.out.printf("%s[%s]", k04_sNumVal.substring(k04_i, k04_i + 1),
					k04_units[Integer.parseInt(k04_sNumVal.substring(k04_i, k04_i + 1))]);
			// k04_sNumVal.substring(k04_i, k04_i + 1) => substring은 index가 0부터 시작한다. 곧 제일
			// 앞자리부터 하나씩 자른다.
			// k04_units[Integer.parseInt(k04_sNumVal.substring(k04_i, k04_i + 1))] => 위에서
			// 자른 그 숫자값을 int형으로 변환
			if (k04_sNumVal.equals("0")) {
				k04_sNumVoice = "영";
			} else {
				if (k04_sNumVal.substring(k04_i, k04_i + 1).equals("0")) {
					// 만의 자릿수가 없을 때
					if (k04_sNumVal.substring(0, 1).matches("[1-9]") // 0에서 1까지 1-9 중 1개의 값일 때
							&& k04_sNumVal.substring(k04_sNumVal.length() - 8, k04_sNumVal.length() - 4)
									.equals("0000")) {
						// 자릿수를 통해 알아보기 --> 만의 자리가 아무것도 없으면 equals "0000"
						//
						// 해당자리가 0일땐 단위값을 안붙이는데 억, 만 자리는 붙인다
						// 이백 사만 이십.. 이백 만 원..
						// 억, 만 자리가 아니면 아무짓도 안함
						//
						if (k04_unitx[k04_j].equals("억")) { // 자릿수가 억일 때
							k04_sNumVoice = k04_sNumVoice + "" + k04_unitx[k04_j]; // 단위만 붙여준다.
						} else {
							// 아무것도 안함
						}
					} else {
						if (k04_unitx[k04_j].equals("만") || k04_unitx[k04_j].equals("억")) { // 자릿값이 만이나 억일 때
							k04_sNumVoice = k04_sNumVoice + "" + k04_unitx[k04_j]; // 단위를 붙여준다.
							// 해당자리가 0이면 단위만 붙여줌
						} else { // 아니면
							// 아무짓도 안함
						}
					}

				} else {
					k04_sNumVoice = k04_sNumVoice + k04_units[Integer.parseInt(k04_sNumVal.substring(k04_i, k04_i + 1))]
							+ k04_unitx[k04_j];
				} // 기존 한글숫자읽기 뒤에 새로운 한글숫자읽기를 붙인다

			}

			k04_i++; // while이 한 번 돌 때마다 1 더해줌
			k04_j--; // while이 한 번 돌 때마다 1 빼기

		}
		System.out.printf("\n %s[%s]\n", k04_sNumVal, k04_sNumVoice); // 숫자와 지금까지 모아놓은 숫자읽기 스트링값을 출력한다
	}
}
