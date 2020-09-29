package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_TaxcalcCumtom {
	//////////////////////////////////////
	// 한국식은 소비자가가 100원, 이런 식으로 가격이 똑 덜어지게 처리
	// 세금은 무조건 올려서 소비자에게 받아야 한다.
	// 즉 세전가격을 버림처리하면 무조건 세금은 올림처리가 된다.
	// 세전가격을 정수형 연산하면 된다
	//
	// net = custom / (1 + rate)
	// tax = custom - net
	// 작업현장에서 이정도 산수는 많이 나온다 ^^
	//
	public static void main(String[] args) {
		int k04_custom = 280; // 소비자가격
		int k04_taxrate = 3; // 3%는 0.03 -> taxrate / 100.0
		int k04_taxval; // 세금
		int k04_netval; // 세전가격

		k04_netval = (int) (k04_custom / (1 + k04_taxrate / 100.0)); // 소비자가 / 1.03
		k04_taxval = k04_custom - k04_netval; // 세금 = 소비자가 - 세전가격

		System.out.printf("**********************************************************\n");
		System.out.printf("*            소비자가 중심 세금 계산                     *\n");
		System.out.printf("소비자가격 : %d원,    세전가격 : %d원,    세금 : %d원\n", k04_custom, k04_netval, k04_taxval);
		// 소비자가, 세전가격, 세금 출력
		System.out.printf("**********************************************************\n");
	}
}
