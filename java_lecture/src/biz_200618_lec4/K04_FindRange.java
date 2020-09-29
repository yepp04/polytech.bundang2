package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200618 강진성
public class K04_FindRange {
	public static void main(String[] args) {
		/////////////////////////////////
		// 범위를 주어서 찾기
		//
		int k04_iVal; // int 변수 선언
		for (int k04_i = 0; k04_i < 300; k04_i++) { // 0에서 299까지 돌리기
			k04_iVal = 5 * k04_i; // iVal은 5 * i이다
			if (k04_iVal >= 0 && k04_iVal < 10) { // iVal이 일의 자리
				System.out.printf("일 %d\n", k04_iVal); // 일 숫자 출력
			} else if (k04_iVal >= 10 && k04_iVal < 100) { // iVal이 십의 자리
				System.out.printf("십 %d\n", k04_iVal); // 십 숫자 출력
			} else if (k04_iVal >= 100 && k04_iVal < 1000) { // iVal이 백의 자리
				System.out.printf("백 %d\n", k04_iVal); // 백 숫자 출력
			} else { // 그 외(천의 자리)
				System.out.printf("천 %d\n", k04_iVal); // 천 숫자 출력
			}
		}
	}
}
