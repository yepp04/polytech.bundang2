package biz_200624;

import java.text.DecimalFormat;
import java.util.ArrayList;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_SumVerificationProg {

	public static void main(String[] args) {

		String[] k04_OneRec = { "01*  (G)흰다리새우(      6,900    2     13,800", "02   고양이간식참치      4,500    1      4,500",
				"03   스위트딸기롤20      1,950    1      1,950", "04*  (G)은연어           4,070    1      4,070",
				"05   마롱조각케익        1,240    1      1,240", "06*  양배추(통)          2,480    1      2,480",
				"07   프리미엄굴소스      6,400    1      6,400", "08   백설튀김가루1K      1,960    1      1,960",
				"09   CJ진한참기름50      9,900    1      9,900", "10   백설 올리브유9     19,350    1     19,350",
				"11   EF낱개초밥          4,900    1      4,900", "12*  재사용종량제봉        350    1        350",
				"13   피코크 새우볶       7,980    1      7,980", "14   세이브아몬드콤      1,950    1      1,950",
				"15   TOP초코렛모카2        970    2      1,940", "16   맥심TOP블랜드2        970    1        970",
				"17   동원)어린이치       4,580    1      4,580", "18   덴)아기소얼룩       4,580    1      4,580",
				"19   말하는 메탈 경      1,200    2      2,400", "20*  콜라비(레드)        1,480    1      1,480",
				"21   야채통새우볶음      5,060    1      5,060", "22*  헬로우앙팡1000      3,050    1      3,050",
				"23   썬업 오렌지 95      1,500    1      1,500", "24   베이비오검은콩      4,300    1      4,300",
				"25   베이비오딸기요 41,000,000    2 83,000,000", "26   베이비오 계란       4,300    1      4,300",
				"27   피코크 맛있는       7,980    1      7,980", "28*  관자살(태국,중      5,710    1      5,711",
				"29*  매일 저지방2%       3,950  500  1,976,000", "30*  밤고구마2kg박  54,800,000    1 54,800,000" };

		DecimalFormat k04_df = new DecimalFormat("###,###,###,###,###"); // 콤마 찍어주기

		ArrayList<Integer> k04_price = new ArrayList<>(); // 가격 어레이리스트 생성
		ArrayList<Integer> k04_num = new ArrayList<>(); // 개수 어레이리스트 생성
		ArrayList<Integer> k04_sum = new ArrayList<>(); // 합계 어레이리스트 생성

		for (int k04_i = 0; k04_i < k04_OneRec.length; k04_i++) {
			String k04_pr = k04_OneRec[k04_i] // 한줄을 가져와서 자르고 콤마와 띄어쓰기 제거 후 string 값으로 저장
					.substring(k04_OneRec[k04_i].length() - 27, k04_OneRec[k04_i].length() - 16).replaceAll(",", "")
					.replaceAll(" ", "");
			k04_price.add(Integer.parseInt(k04_pr)); // 스트링값을 인티저로 변경
			String k04_n = k04_OneRec[k04_i].substring(k04_OneRec[k04_i].length() - 16, k04_OneRec[k04_i].length() - 11)
					.replaceAll(",", "").replaceAll(" ", "");
			// 한줄을 가져와서 자르고 콤마와 띄어쓰기 제거 후 string 값으로 저장
			k04_num.add(Integer.parseInt(k04_n)); // 스트링값을 인티저로 변경
			String k04_s = k04_OneRec[k04_i].substring(k04_OneRec[k04_i].length() - 11, k04_OneRec[k04_i].length())
					.replaceAll(",", "").replaceAll(" ", "");
			// 한줄을 가져와서 자르고 콤마와 띄어쓰기 제거 후 string 값으로 저장
			k04_sum.add(Integer.parseInt(k04_s)); // 스트링값을 인티저로 변경
		}

		for (int k04_i = 0; k04_i < k04_OneRec.length; k04_i++) {// 배열 OneRec의 길이만큼 for문 실행
			if ((k04_price.get(k04_i) * k04_num.get(k04_i) != k04_sum.get(k04_i))) { // 가격*개수의 값이 합계와 다르면
				System.out.printf("****************************************************\n");// 줄 출력
				System.out.printf("오류[%s]\n", k04_OneRec[k04_i]); // 그 줄 자체를 출력
				System.out.printf("수정[%s%11s]\n", k04_OneRec[k04_i].substring(0, k04_OneRec[k04_i].length() - 11),
						k04_df.format((k04_price.get(k04_i) * k04_num.get(k04_i))));// 합계 값만 변경해서 출력
				System.out.printf("****************************************************\n"); // 줄 출력
			}
		}
	}
}
