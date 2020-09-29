package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200618 강진성
public class K04_ArrayComparison {
	public static void main(String[] args) {
		//////////////////////////////////
		// 비정형 비교(룰이 애매한)는 배열을 이용하는 것도 한 방법이다.
		//
		int[] k04_iLMD = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 단 배열은 0부터 시작한다는 것에 유의 LastMonthDate
		// iLMD[0] ~ iLMD[11] 이다

		for (int k04_i = 1; k04_i < 13; k04_i++) { // for문 1~12까지 돌림
			System.out.printf(" %d월 =>", k04_i); // i가 월로 출력됨(1월~12월
			for (int k04_j = 1; k04_j < 32; k04_j++) { // for문 1~31까지 돌림
				System.out.printf("%d", k04_j); // j가 일로 출력됨(1일~31일)

				if (k04_iLMD[k04_i - 1] == k04_j) { // 배열의 각 iLMD값이 j값과 같으면
					break; // 나가기
				}
				System.out.printf(","); // 마지막일 콤마 안찍기
			}
			System.out.printf("\n"); // i가 한번 돌 때마다 개행 출력
		}
	}
}
