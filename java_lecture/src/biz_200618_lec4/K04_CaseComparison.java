package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200618 강진성
public class K04_CaseComparison {
	public static void main(String[] args) {
		//////////////////////////////////////////
		// 이 예제는 정말 억지로 만든 프로그램, 이상한 것임

		for (int k04_i = 1; k04_i < 13; k04_i++) { // for문 1~12까지 돌림
			System.out.printf(" %d월 =>", k04_i); // i가 월로 출력됨(1월~12월)
			LOOP: for (int k04_j = 1; k04_j < 32; k04_j++) {
				// for문 1~31까지 돌림, LOOP 돌아오는 지점
				switch (k04_i) { // k04_i가
				case 4: // 4월
				case 6: // 6월
				case 9: // 9월
				case 11: // 11월이고
					if (k04_j == 30) { // 30일일 때
						System.out.printf("%d", k04_j); // 마지막행 콤마 제거 출력
						break LOOP; // 루프 지점으로 돌아가기
					}
					break; // 케이스 종료
				case 2: // 2월이고
					if (k04_j == 28) { // 28일일 때
						System.out.printf("%d", k04_j); // 마지막행 콤마 제거 출력
						break LOOP; // 루프 지점으로 돌아가기
					}
					break; // 케이스 종료
				}
				if (k04_j == 31) { // 31일일 때
					System.out.printf("%d", k04_j); // 마지막행 콤마 제거 출력
					break LOOP; // 루프 지점으로 돌아가기
				}
				System.out.printf("%d,", k04_j); // j가 일로 출력됨(1일~31일)
			}
			System.out.printf("\n"); // i가 한번 돌 때마다 개행 출력
		}
	}
}
