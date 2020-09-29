package biz_200618;

//BIZ프로그래밍 3강 연산자 실습 200618 강진성
public class K04_MoneyExWithCommission {
	public static void main(String[] args) {
		//////////////////////////////////////
		// 유상현군은 짤렸다. 수수료 안받아서
		// 그 옆에 홍보경군이 수수료를 개선했다.
		//
		int k04_MyWon = 1000000; // 100만원을 달러로 바꿀 예정
		double k04_MoneyEx = 1238.21; // 달러 환율
		double k04_commission = 0.003; // 환전 수수료 0.3프로
		int k04_usd = (int) (k04_MyWon / k04_MoneyEx);
		// 최종 결과를 정수형으로 만들면 버림처리가 된다. 전체금액을 환율로 나눴다.
		double k04_ComPerOne = k04_MoneyEx * k04_commission;
		// 환율 * 수수료 = 달러당 수수료
		double k04_TotalCom = k04_usd * k04_ComPerOne; // 총 수수료 = 미화 * 달러당 수수료
		System.out.printf("*******************************************************************************\n");
		System.out.printf("*                               수수료 계산                                   *\n");
		System.out.printf("총 수수료 : %f원 => 미화 : %d달러, 달러당 수수료 : %f원\n", k04_TotalCom, k04_usd, k04_ComPerOne); // 1원 아래
																												// 돈은?
		System.out.printf("*******************************************************************************\n");
	}
}
