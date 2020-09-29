package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200618 강진성
public class K04_CountingNumKor {
	public static void main(String[] args) {
		////////////////////
		// 범위를 주는 것, 숫자 자르기
		String[] k04_units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		// 스트링 배열값 삽입
		for (int k04_i = 0; k04_i < 101; k04_i++) { // 0에서 100까지 for문 돌리기
			if (k04_i >= 0 && k04_i < 10) { // i가 0에서 9사이 일때 (일의자리)
				System.out.printf("일의자리 : %s\n", k04_units[k04_i]); // i를 한번씩 출력해줌
			} else if (k04_i >= 10 && k04_i < 100) { // i가 10에서 99사이일 때
				int k04_i10; // 십의자리 변수선언
				int k04_i0; // 일의자리 변수선언
				k04_i10 = k04_i / 10; // 십의자리
				k04_i0 = k04_i % 10; // 일의자리
				if (k04_i0 == 0) { // 일의자리가 영이면
					if (k04_i10 == 1) { // 십의자리가 일이면
						System.out.printf("십의자리 : 십\n"); // 십 출력
					} else { // 아니면
						System.out.printf("십의자리 : %s십\n", k04_units[k04_i10]); // 뒤에 십만 붙여서 출력
					}
				} else { // 일의자리가 영이아니면
					if (k04_i10 == 1) { // 십의자리가 일이면
						System.out.printf("십의자리 : 십%s\n", k04_units[k04_i0]); // 십뒤에 일의자리 붙여서 출력
					} else { // 아니면
						System.out.printf("십의자리 : %s십%s\n", k04_units[k04_i10], k04_units[k04_i0]);
						// String "십"의 앞뒤로 십의자리와 일의자리 값 넣어 출력
					}
				}
			} else { // 일의자리도 십의자리도 아닐 때 ==> 백의자리
				System.out.printf("==> %d\n", k04_i); // 값을 숫자로 그냥 출력
			}
		}
	}
}
