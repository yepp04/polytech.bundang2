package biz_200618_lec4;

import java.text.DecimalFormat;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200619 강진성
public class K04_PerfectPrint {
	public static void main(String[] args) {
		/////////////////////
		// 칸 맞추기 실습
		//

		String k04_item = "사과"; // 품목 사과
		int k04_unit_price = 5000; // 단가 5000
		int k04_num = 500; // 수량 500
		int k04_total = k04_unit_price * k04_num; // 합계
		String k04_item2 = "aaaa"; // 품목 aaaa
		int k04_unit_price2 = 3000; // 단가 3000
		int k04_num2 = 900; // 수량 500
		int k04_total2 = k04_unit_price2 * k04_num2; // 합계

		DecimalFormat k04_df = new DecimalFormat("###,###,###,###,###"); // 콤마 찍기

		/// 헤더 찍기
		System.out.printf("=====================================================\n"); // 개행출력
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목", "단가", "수량", "합계"); // 헤더 출력
		System.out.printf("=====================================================\n"); // 개행출력

		// 값 찍기
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n", k04_item, k04_df.format(k04_unit_price),
				k04_df.format(k04_num), k04_df.format(k04_total)); // 자리를 맞춰서 배치 출력
		System.out.printf("%22.20s%10.10s%10.10s%10.10s\n", k04_item2, k04_df.format(k04_unit_price2),
				k04_df.format(k04_num2), k04_df.format(k04_total2)); // 자리를 맞춰서 배치 출력
		System.out.printf("=====================================================\n");
	}
}
