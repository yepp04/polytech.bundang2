package biz_200619;

//BIZ프로그래밍 5강 실무실습1 실습 200619 강진성
public class K04_MultiplicationTable {
	public static void main(String[] args) {
		for (int k04_i = 1; k04_i < 10; k04_i = k04_i + 3) { // 1부터 9까지 1 4 7 순으로 3번 돌기
			System.out.printf("**************** **************** ****************\n"); // 구분 출력
			System.out.printf("  구구단 %d 단      구구단 %d 단      구구단 %d 단  \n", k04_i, k04_i + 1, k04_i + 2);
			// for문 i가 1 4 7 순으로 움직이기 때문에 i, i + 1, i + 2 곧 1 2 3 // 4 5 6 // 7 8 9 가 되도록
			// 더해준다
			System.out.printf("**************** **************** ****************\n"); // 구분 출력
			for (int k04_k = 1; k04_k < 10; k04_k++) { // 뒷부분 곱하는 값을 1부터 9까지 돌려준다
				System.out.printf("  %2d * %d = %2d", k04_i, k04_k, k04_i * k04_k);
				// 2자릿수가 나올때 헝클어지지 않도록 2d를 써준다 첫째줄
				System.out.printf("      %2d * %d = %2d", k04_i + 1, k04_k, (k04_i + 1) * k04_k);
				// 2자릿수가 나올때 헝클어지지 않도록 2d를 써준다 둘째줄, i에 +1 더해줌
				System.out.printf("      %2d * %d = %2d\n", k04_i + 2, k04_k, (k04_i + 2) * k04_k);
				// 2자릿수가 나올때 헝클어지지 않도록 2d를 써준다 셋째줄, i에 +2 더해줌
			}
		}
	}
}
