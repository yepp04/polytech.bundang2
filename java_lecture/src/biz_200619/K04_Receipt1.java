package biz_200619;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//BIZ프로그래밍 5강 실무실습1 실습 200619 강진성
public class K04_Receipt1 {
	public static void main(String[] args) {
		DecimalFormat k04_df = new DecimalFormat("###,###,###,###,###"); // 콤마 찍어주기
		String k04_storeName = "종로상회(분당서현점)"; // 상점이름
		String k04_businessNum = "129-17-77924"; // 사업자 번호
		String k04_CEO = "이상철"; // 가게 주인
		String k04_tel = "031 781 1596"; // 가게 전화번호
		String k04_addr = "성남시 분당구 서현동 269-3"; // 가게 주소
		int k04_table = 12; // 테이블 번호

		Calendar k04_cald = Calendar.getInstance(); // 캘린더 인스턴스를 생성한다
		SimpleDateFormat k04_sdf = new SimpleDateFormat("yyyyMMdd"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정한다

		String k04_orderNum = k04_sdf.format(k04_cald.getTime()) + " 01 00001"; // 주문번호
		int k04_cash = 0; // 현금결제
		int k04_card = 2200; // 카드결제
		int k04_point = 0; // 포인트결제
		int k04_total = k04_cash + k04_card + k04_point; // 주문 총 금액
		int k04_taxRate = 10; // 세금 10%
		int k04_netVal = (int) ((10 * k04_total) / (10 * (1 + k04_taxRate / 100.0))); // 세전금액
		int k04_taxVal = k04_total - k04_netVal; // 세금
		int k04_dutyFree = 0; // 면세금액
		int k04_sale = k04_point; // 할인금액
		int k04_get = k04_total - k04_sale; // 받을 금액
		int k04_receiptPay = k04_netVal + k04_taxVal + k04_dutyFree;
		// 영수금액 = 세전금액 + 세금 + 면세금액

		SimpleDateFormat k04_sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정한다

		String k04_cardNum = "55222059****2021"; // 카드번호
		int k04_OKNum = 79753574; // 승인번호
		int k04_installment = 0; // 할부개월
		int k04_memberNum = 730461774; // 가맹번호
		String k04_memCompany = "비씨카드사"; // 가맹사 이름쓰기

		SimpleDateFormat k04_sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // sdf2 인스턴스를 생성 후 날짜시간의 모양을 지정한다

		System.out.printf("               영  수  증              \n"); // 헤더출력
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("%s   %s\n", k04_storeName, k04_businessNum); // 가게이름, 사업자 번호
		System.out.printf("%s  %s\n", k04_CEO, k04_tel); // 사장, 가게 전화번호
		System.out.printf("%s\n", k04_addr); // 가게 주소
		System.out.printf("테이블명 : %d\n", k04_table); // 테이블 번호
		System.out.printf("주문번호 : %s\n", k04_orderNum); // 주문 번호
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("주문합계                  %14s\n", k04_df.format(k04_total)); // 주문합계
		System.out.printf("할인금액                  %14s\n", k04_df.format(k04_sale)); // 할인금액
		System.out.printf("받을금액                  %14s\n", k04_df.format(k04_get)); // 받을금액
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("현  금%11s    ", k04_df.format(k04_cash)); // 현금결제
		System.out.printf("과  세%13s\n", k04_df.format(k04_netVal)); // 세전금액
		System.out.printf("카  드%11s    ", k04_df.format(k04_card)); // 카드결제
		System.out.printf("세  액%13s\n", k04_df.format(k04_taxVal)); // 부가세
		System.out.printf("포인트%11s    ", k04_df.format(k04_point)); // 포인트결제
		System.out.printf("면  세%13s\n", k04_df.format(k04_dutyFree)); // 면세금액
		System.out.printf("                     영수금액%11s\n", k04_df.format(k04_receiptPay));
		// 영수금액 = 세전금액 + 부가세 + 면세금액
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("           [우리카드 신용 승인]          \n"); // 헤더출력
		System.out.printf("승 인 일 시 :  %s\n", k04_sdf2.format(k04_cald.getTime())); // 승인일시
		System.out.printf("카 드 번 호 :  %s\n", k04_cardNum); // 카드번호
		System.out.printf("승 인 번 호 :  %d", k04_OKNum); // 승인번호
		System.out.printf("  할부개월 : %02d\n", k04_installment); // 할부개월
		System.out.printf("승 인 금 액 :  %s\n", k04_df.format(k04_get)); // 승인금액
		System.out.printf("가 맹 번 호 :  %s  /  %s\n", k04_memberNum, k04_memCompany); // 가맹번호
		System.out.printf("사업자 번호 :  %s\n", k04_businessNum); // 사업자 번호
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("%s  CASHIER :         직원\n", k04_sdf3.format(k04_cald.getTime())); // 날짜출력
		System.out.printf("----------------------------------------\n"); // 줄 출력
		System.out.printf("감사 합니다.\n"); // 인사

	}
}
