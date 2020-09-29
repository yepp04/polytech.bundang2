package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_MoneyExWithCommission3 {
	public static void main(String[] args) {
		int k04_MyWon = 1000000; // 100만원을 달러로 바꿀 예정
		double k04_MoneyEx = 1238.21; // 달러 환율
		double k04_commission = 0.003; // 환전 수수료 0.3프로
		int k04_usd = (int) (k04_MyWon / k04_MoneyEx);
		// 최종 결과를 정수형으로 만들면 버림처리가 된다. 전체금액을 환율로 나눴다.
		double k04_ComPerOne = k04_MoneyEx * k04_commission;
		// 환율 * 수수료 = 달러당 수수료
		double k04_TotalCom = k04_usd * k04_ComPerOne; // 총 수수료 = 미화 * 달러당 수수료
		int k04_remain = (int) (k04_MyWon - k04_usd / k04_MyWon);
		// 고객에게 돌려줄 잔돈도 당연히 소수점 이하의 금액은 은행이 갖는다. 실수로 계산 후 버림처리
		// 전체금액에서 달러금액 (달러 * 환율)을 뺐다. 만일 2324.22원 이런식으로 나오면 0.22원은 은행이 갖는다. 줄 수 없다.
		//////////////////////////////////////////////////
		// 당연히 수수료는 받아야 할 돈이니 올림처리하자
		int k04_i_TotalCom; // 버림 처리할 총 수수료 변수
		/////////////////////////////////////////////////
		// 홍보경군도 고객에게 2233원을 더 주셔야 807달러를 드립니다 했더니 짤렸다.
		//
		// 정확한 답은 실수형 계산으로 먼저 (1달러 + 1달러 환전수수료) 이 금액을 전체금액으로 나누어 환전해 주는 것이다.
		// 왜 더블로 계산하고, 인트로 계산하는지 잘 생각해라. 이런거 익히는 게 변수 선언, 형변환, 연산이다.
		//
		k04_usd = (int) (k04_MyWon / (k04_MoneyEx + k04_ComPerOne)); // 환전달러
		k04_TotalCom = k04_usd * k04_ComPerOne; // 총 수수료
		////////////
		// 수수료 올림처리
		if (k04_TotalCom != (double) ((int) k04_TotalCom)) { // 총수수료가 버림처리한 총수수료와 동일하지 않으면
			k04_i_TotalCom = (int) k04_TotalCom + 1; // 소수점 버림처리한 총 수수료에 1원 추가
		} else {
			k04_i_TotalCom = (int) k04_TotalCom; // 총 수수료 소수점 버림
		}
		////////////
		System.out.printf("*************************************************************************************\n");
		System.out.printf("*                      정확한 수수료 적용환전                                       *\n");
		System.out.printf("총 수수료 : %d원 => 미화 : %d달러, 달러당 수수료 : %f원\n", k04_i_TotalCom, k04_usd, k04_ComPerOne); // 깔끔
		k04_remain = (int) (k04_MyWon - k04_usd * k04_MoneyEx - k04_i_TotalCom);
		// 달러에서 환율을 곱하면 다시 원화가 되는데 처음 가졌던 돈 100만원에서 그 원화를 빼고 다시 수수료를 빼면 remain 값이 나온다
		System.out.printf("총 한화환전금액 : %d원 => 미화 : %d달러, 수수료 징수 : %d원,  잔돈 : %d원\n", k04_MyWon, k04_usd, k04_i_TotalCom,
				k04_remain); // easy
		System.out.printf("*************************************************************************************\n");
	}
}
