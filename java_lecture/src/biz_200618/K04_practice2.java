package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_practice2 {
	public static void main(String[] args) {

		///////////////////////////////////////
		// #2. 누적하기, 합구하기

		int k04_sum; // c는 맨 앞에서만 선언, c++m java는 필요할 때 선언해도 됨, 하지만 지저분
		k04_sum = 0; // 누적, 루프는 꼭 초기화

		// 1부터 100까지 더하기
		for (int k04_i = 1; k04_i < 101; k04_i++) {
			k04_sum = k04_sum + k04_i; // 1부터 100까지 누적
		}
		System.out.printf("#2 : %d\n", k04_sum); // 총합 출력
		// 평균을 처리한다면 여기서 다 더한다음 하기
		System.out.printf("#2-2 : %d\n", k04_sum / 100); // 평균 출력

		// 배열 응용

		int[] k04_v = { 1, 2, 3, 4, 5 }; // 배열 값에 바로 1, 2, 3, 4, 5 넣기
		int k04_vSum; // 인트변수 선언

		k04_vSum = 0; // 변수 초기화

		for (int k04_i = 0; k04_i < 5; k04_i++) {
			k04_vSum = k04_vSum + k04_v[k04_i]; // 누적하기
		}

		System.out.printf("#2-3 : %d\n", k04_vSum); // 누적 값의 결과 출력
	}
}
