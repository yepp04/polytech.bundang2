package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200618 강진성
public class K04_AtypicalComparison2 {
	public static void main(String[] args) {
		for (int k04_i = 1; k04_i < 13; k04_i++) { // for문 1~12까지 돌림
			System.out.printf(" %d월 =>", k04_i); // i가 월로 출력됨(1월~12월)
			for (int k04_j = 1; k04_j < 32; k04_j++) { // for문 1~31까지 돌림

				if (k04_i == 4 || k04_i == 6 || k04_i == 9 || k04_i == 11) {
					// i(월)이 4, 6, 9, 11월이면
					if (k04_j == 30) { // 30일에
						System.out.printf("%d", k04_j); // 마지막행 콤마 제거 출력
						break; // 멈춰라
					}
				}

				if (k04_i == 2) { // i(월)이 2월이면
					if (k04_j == 28) { // 28일에
						System.out.printf("%d", k04_j); // 마지막행 콤마 제거 출력
						break; // 멈춰라
					}
				}

				if (k04_j == 31) {
					System.out.printf("%d", k04_j); // 마지막행 콤마 제거 출력
					break; // 멈춰라
				}

				System.out.printf("%d,", k04_j); // j가 일로 출력됨(1일~31일)
			}
			System.out.printf("\n"); // i가 한번 돌 때마다 개행 출력
		}
	}
}
