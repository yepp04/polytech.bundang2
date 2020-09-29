package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_practice5 {
	public static void main(String[] args) {

		////////////////////////////////////
		// #5 소수점 이하에서는 어떻게 할까?

		int k04_MyVal = 14 / 5; // 이 값은 2.8이다. 소수점 이하 버리면 2, 반올림하면 3
		System.out.printf("#5-1 : %d\n", k04_MyVal); // 그냥 연산하면 버려진다

		// 변수를 실수형(float, double 형태로 형변환) 계산을 한 후 0.5를 더한 다음
		// 정수형 형변환을 하면 반올림 처리가 된다.
		// 실수(Real Number)를 꼭 알자!! ㅋㅋㅋ

		double k04_MyValF;

		k04_MyValF = 14 / 5;
		System.out.printf("#5-2 : %f\n", k04_MyValF); // 소수형 연산이 안됨

		k04_MyValF = 14.0 / 5; // 한개라도 실수형태의 표시를 해야 실수가 나온다
		System.out.printf("#5-3 : %f\n", k04_MyValF);

		k04_MyValF = (14.0) / 5 + 0.5; // 실수형 계산에서 0.5를 더해보자
		System.out.printf("#5-4 : %f\n", k04_MyValF);

		k04_MyVal = (int) ((14.0) / 5 + 0.5); // 실수형 계산을 하고 정수형 형변환을 하자
		System.out.printf("#5-5 : %d\n", k04_MyVal);
	}
}
