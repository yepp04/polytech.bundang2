package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_practice4 {
	public static void main(String[] args) {

		////////////////////////////////////
		// #4 원하는 자릿수 반올림, 버림처리

		int k04_ii = 12345; // 12345원은 10원 이하 버려서 처리하기
		int k04_j = (k04_ii / 10) * 10; // 정수형 연산의 특징을 잘 이해해야 한다
		System.out.printf("#4-1 : 12345 -> %d - 10원 이하 버림\n", k04_j);

		k04_ii = 12345; // 12345원은 10원 이하 반올림 처리하기
		k04_j = ((k04_ii + 5) / 10) * 10; // 정수형 연산의 특징을 잘 이해해야 한다
		System.out.printf("#4-2 : 12345 -> %d - 10원 이하 반올림(올림)\n", k04_j);

		k04_ii = 12344; // 12344원은 10원 이하 반올림 처리하기
		k04_j = ((k04_ii + 5) / 10) * 10; // 이 식이 맞는지 검증해보자
		System.out.printf("#4-2 : 12344 -> %d - 10원 이하 반올림(내림)\n", k04_j);

		k04_ii = 12355; // 12355원은 100원 이하 버려서 처리하기
		k04_j = ((k04_ii) / 100) * 100; // 정수형 연산의 특징을 잘 이해해야 한다
		System.out.printf("#4-3 : 12355 -> %d - 100원 이하 버림\n", k04_j);

		k04_ii = 12355; // 12355원은 100원 이하 반올림 처리하기
		k04_j = ((k04_ii + 50) / 100) * 100; // 정수형 연산의 특징을 잘 이해해야 한다
		System.out.printf("#4-3 : 12355 -> %d - 100원 이하 반올림(올림)\n", k04_j);

		k04_ii = 12545; // 12545원은 1000원 이하 버려서 처리하기
		k04_j = ((k04_ii) / 1000) * 1000; // 정수형 연산의 특징을 잘 이해해야 한다
		System.out.printf("#4-4 : 12545 -> %d - 1000원 이하 버림\n", k04_j);

		k04_ii = 12545; // 12545원은 1000원 이하 반올림 처리하기
		k04_j = ((k04_ii + 500) / 1000) * 1000; // 정수형 연산의 특징을 잘 이해해야 한다
		System.out.printf("#4-4 : 12545 -> %d - 1000원 이하 반올림(올림)\n", k04_j);
	}
}
