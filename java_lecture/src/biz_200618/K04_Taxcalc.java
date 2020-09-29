package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
/////////////////////////////////
// 반올림은 유효숫자를 높여 오차를 줄이는 방법이나, 세금계산 문제 같으면 손해를 안봐야 되는 문제
// 즉 세율을 나눠서 원단위가 딱 떨어지면 그대로 세금을 먹이나, 아니면 +1원을 더해야 한다.
public class K04_Taxcalc {

	public static int k04_taxcal(int k04_val, int k04_rate) { // 세금계산 메서드 생성
		int k04_ret;
		if (((double) k04_val + (double) k04_rate / 100.0) == k04_val * k04_rate / 100) { // 세율을 나눠서 실수형과 정수형이 딱 떨어질 때
			k04_ret = k04_val * k04_rate / 100; // 그대로 세금을 먹임
		} else {
			k04_ret = k04_val * k04_rate / 100 + 1; // 1원을 더해서 먹임
		}
		return k04_ret;
	}
	/////////////////////////////////////////

	public static void main(String[] args) {
		int k04_val = 271; // 세전가격
		int k04_rate = 3; // 세율

		////////////////////
		// 우리나라는 세금을 포함한 소비자가격을 기입하는데, 일본가면 세전 가격을 소비자가라고 붙여놔서 헷갈림
		// 100엔이라고 편의점에서 사면 112엔을 받아서 잔돈만 생긴다.
		int k04_tax = k04_taxcal(k04_val, k04_rate);
		System.out.printf("*********************************************************\n");
		System.out.printf("*                단순 세금 계산                         *\n");
		System.out.printf("실제 세금 계산 : %f\n", k04_val * k04_rate / 100.0); // 세금계산 출력
		// 하나라도 double형식 연산을 하면 실수로 표시
		System.out.printf("세전가격 : %d원,  세금 : %d원,  세포함가격 : %d원\n", k04_val, k04_tax, k04_val + k04_tax); // 세전가격, 세금,
																											// 세포함가격
		// 출력
		System.out.printf("*********************************************************\n");

	}
}
