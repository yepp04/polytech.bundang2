package biz_200619;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//BIZ프로그래밍 5강 실무실습1 실습 200619 강진성
public class K04_Receipt2 {

	public static int k04_netVal(int k04_price, int k04_taxRate) {
		int k04_net = (int) ((10 * k04_price) / (10 * (1 + k04_taxRate / 100.0))); // 세전금액
		return k04_net; // 세전금액 리턴~
	}

	public static int k04_taxVal(int k04_price, int k04_netVal) {
		int k04_tax = k04_price - k04_netVal; // 세금
		return k04_tax; // 세금 리턴~~
	}

	public static void main(String[] args) {
		DecimalFormat k04_df = new DecimalFormat("###,###,###,###,###"); // 콤마 찍어주기

		String k04_restPlaceName = "충주(양평)휴게소"; // 휴게소 이름
		String k04_restPlaceAddr = "충북충주시가금면용전리380-4"; // 휴게소 주소
		String k04_restPlaceBoss = "최병권"; // 휴게소 주인
		String k04_restPlaceBizNum = "677-85-00239"; // 사업자 번호
		String k04_restPlaceTel = "043-857-9229"; // 휴게소 전화번호

		Calendar k04_cald = Calendar.getInstance(); // 캘린더 인스턴스를 생성한다
		SimpleDateFormat k04_sdf = new SimpleDateFormat("yyyyMMdd HHmmss"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정한다

		int k04_POSNum = 2; // 포스번호

		String k04_itemName1 = "쁘띠첼petitzel워터젤리복숭아5개입"; // 물건1
		String k04_itemName2 = "카누다크로스트아메리카노100STICKS"; // 물건2
		String k04_itemCode1 = "1238545823658"; // 물건번호1
		String k04_itemCode2 = "3254858546231"; // 물건번호2
		int k04_price1 = 5200; // 1번 물건 가격
		int k04_price2 = 18000; // 2번 물건 가격
		int k04_num1 = 2; // 1번 물건 개수
		int k04_num2 = 10; // 2번 물건 개수
		int k04_totalPr1 = k04_price1 * k04_num1; // 1번물건 총금액
		int k04_totalPr2 = k04_price2 * k04_num2; // 2번물건 총금액
		int k04_allTotal = k04_totalPr1 + k04_totalPr2; // 총합계

		int k04_taxRate = 10; // 세율 10%
		int k04_netVal1 = k04_netVal(k04_allTotal, k04_taxRate); // 세전금액 (총금액, 세율)
		int k04_taxVal1 = k04_taxVal(k04_allTotal, k04_netVal1); // 세금 (총금액, 세전금액)
		String k04_bcCard = "00/00A"; // 026-비씨카드사
		String k04_cardNum = "5522-20**-****-BADD"; // 카드번호
		int k04_cardPay = k04_allTotal; // 카드 매출
		String k04_dealWay = "일시불"; // 거래 구분
		String k04_OKNum1 = "04-KICC"; // 승인번호1
		int k04_OKNum2 = 75549250; // 승인번호2
		int k04_getPay = 1000000; // 받은 금액
		int k04_change = k04_getPay - k04_cardPay; // 거스름돈
		int k04_orderNum = 920; // 주문번호
		int k04_salesNum = 2; // 판매원번호
		String k04_salesPerson = "편의점2"; // 판매원
		String k04_ilModule = "00138705"; // 연동모듈

		SimpleDateFormat k04_sdf2 = new SimpleDateFormat("yyyy/MM/dd"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정한다
		SimpleDateFormat k04_sdf3 = new SimpleDateFormat("yyyyMMddHHmmss"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정한다

		System.out.printf("%s\n", k04_restPlaceName); // 휴게소 이름
		System.out.printf("%s\n", k04_restPlaceAddr); // 휴게소 주소
		System.out.printf("%s %s TEL:%s\n\n\n", k04_restPlaceBoss, k04_restPlaceBizNum, k04_restPlaceTel); // 사장, 전화번호,
		System.out.printf("[정상등록]%s", k04_sdf.format(k04_cald.getTime())); // 날짜출력
		System.out.printf(" POS번호 : %04d\n", k04_POSNum); // 포스번호 출력
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("품목코드            단가  수량      금액\n"); // 헤더 출력
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("%s\n", k04_itemName1); // 상품1이름
		System.out.printf("%s%11s%6s%10s\n", k04_itemCode1, k04_df.format(k04_price1), k04_df.format(k04_num1),
				k04_df.format(k04_totalPr1)); // 상품1, 가격, 수량, 이 상품 총금액
		System.out.printf("%s\n", k04_itemName2); // 상품2이름
		System.out.printf("%s%11s%6s%10s\n\n", k04_itemCode2, k04_df.format(k04_price2), k04_df.format(k04_num2),
				k04_df.format(k04_totalPr2)); // 상품2, 가격, 수량, 이 상품 총금액

		System.out.printf("과세 물품 합계%26s\n", k04_df.format(k04_netVal1)); // 세전금액
		System.out.printf("부    가    세%26s\n", k04_df.format(k04_taxVal1)); // 부가세
		System.out.printf("합          계%26s\n", k04_df.format(k04_allTotal)); // 합계
		System.out.printf("026-비씨카드사%26s\n", k04_bcCard); // 비씨카드사?
		System.out.printf("카  드  번  호 : %23s\n", k04_cardNum); // 카드번호
		System.out.printf("카  드  매  출 : %23s\n", k04_df.format(k04_cardPay)); // 카드매출
		System.out.printf("거  래  구  분 : %20s\n", k04_dealWay); // 거래구분
		System.out.printf("승  인  번  호 : %s%16d\n", k04_OKNum1, k04_OKNum2); // 승인번호
		System.out.printf("가 맹 점 번 호 : \n"); // 가맹점번호
		System.out.printf("받  은  금  액 : %23s\n", k04_df.format(k04_getPay)); // 받은금액
		System.out.printf("거    스    름 : %23s\n", k04_df.format(k04_change)); // 거스름
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("주문번호:        %04d\n", k04_orderNum); // 주문번호
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("판매원 : %06d %s\n", k04_salesNum, k04_salesPerson); // 판매원 번호, 판매원
		System.out.printf("%s-0002-0922\n", k04_sdf2.format(k04_cald.getTime())); // 날짜 출력
		System.out.printf("연동모듈:[%s  %s]\n", k04_ilModule, k04_sdf3.format(k04_cald.getTime())); // 연동모듈, 날짜출력
	}
}
