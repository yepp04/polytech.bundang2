package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_practice3 {
	public static void main(String[] args) {

		/////////////////////////////////
		// #3 정수형 변수의 나눗셈은 정수범위에서 버림처리

		int k04_ii = 1000 / 3; // 333.3333 이 나오지 않고 333이 나옴, 나머지 1
		System.out.printf("#3-1 : %d\n", k04_ii); // 333 출력

		k04_ii = 1000 % 3; // 나머지를 계산할 땐 %
		System.out.printf("#3-2 : %d\n", k04_ii); // 1000나누기3의 나머지 1출력

		// 나머지 연산자의 응용

		for (int k04_i = 0; k04_i < 20; k04_i++) {
			System.out.printf("#3-3 : %d\n", k04_i); // 0에서 19까지 출력

			if (((k04_i + 1) % 5) == 0) { // 나머지를 5로 나눠서 딱떨어지면
				System.out.printf("\n"); // newline 실행
			}
		}

	}
}
