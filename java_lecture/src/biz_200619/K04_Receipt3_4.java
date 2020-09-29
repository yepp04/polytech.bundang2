package biz_200619;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//BIZ프로그래밍 5강 실무실습1 실습 200622 강진성
public class K04_Receipt3_4 {
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

		String k04_hyphen = "-";
		String k04_storeName = "죽전점"; // 점포 지역
		String k04_storeTelAreaCode = "031"; // 전화 지역번호
		String k04_storeTelNum = "888" + k04_hyphen + "1234"; // 전화 번호
		String k04_bizNum = "206-86-50913"; // 사업자번호
		String k04_storeBoss = "이갑수"; // 가게 주인
		String k04_storeAddr = "용인시 수지구 포은대로 552"; // 가게 주소

		Calendar k04_cald = Calendar.getInstance(); // 캘린더 인스턴스를 생성한다
		SimpleDateFormat k04_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정한다

		int k04_POSNum = 9; // 포스번호
		String[] k04_itemName = { "(G)흰다리새우(중)", "고양이간식참치100G", "스위트딸기롤200g", "(G)은연어", "마롱조각케익", "양배추(통)",
				"프리미엄굴소스510g", "백설튀김가루1KG", "CJ진한참기름500ML", "백설 올리브유900ml*3", "EF낱개초밥", "재사용종량제봉투20L", "피코크 새우볶음밥840",
				"세이브아몬드콤보팝콘", "TOP초코렛모카275ml", "맥심TOP블랜드275ml", "동원)어린이치즈180g", "덴)아기소얼룩소Step2", "말하는 메탈 경찰차",
				"콜라비(레드)", "야채통새우볶음밥450g", "헬로우앙팡1000ml", "썬업 오렌지 950ml", "베이비오검은콩레시틴", "베이비오딸기요구르트", "베이비오 계란칼슘",
				"피코크 맛있는순대", "관자살(태국,중,해동)", "매일 저지방2% 1L*2입", "밤고구마2kg박스" };
		// 항목별 30개 이상
		int[] k04_price = { 6900, 4500, 1950, 4070, 1240, 2480, 6400, 1960, 9900, 19350, 4900, 350, 7980, 1950, 970,
				970, 4580, 4580, 1200, 1480, 5060, 3050, 1500, 4300, 41000000, 4300, 7980, 5710, 3950, 54800000 }; // 단가
		int[] k04_num = { 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 500, 1 }; // 수량
		boolean[] k04_taxFree = { true, false, false, true, false, true, false, false, false, false, false, true, false,
				false, false, false, false, false, false, true, false, true, false, false, false, false, false, true,
				true, true }; // 면세 유무

		int k04_taxFreeSum = 0; // 면세
		for (int k04_i = 0; k04_i < k04_taxFree.length; k04_i++) { // 면세 물품
			if (k04_taxFree[k04_i]) { // 면세이면
				k04_taxFreeSum = k04_taxFreeSum + (k04_price[k04_i] * k04_num[k04_i]); // 더해라
			}
		}
		int k04_total = 0; // 합계
		for (int k04_i = 0; k04_i < k04_taxFree.length; k04_i++) { // 물건 전체
			k04_total = k04_total + (k04_price[k04_i] * k04_num[k04_i]); // 다 더하기
		}

		int taxRate = 10; // 부가세 10%
		int k04_sumWithTax = k04_total - k04_taxFreeSum; // 면세금액을 뺀 세후금액
		int k04_netV = k04_netVal(k04_sumWithTax, taxRate); // 세전금액
		int k04_taxV = k04_taxVal(k04_sumWithTax, k04_netV); // 부가세
		String k04_cardName = "하  나"; // 카드 이름
		String k04_cardNum = "5417**8890"; // 카드 번호
		String k04_cardNum2 = "07850246"; // 카드번호2
		String k04_installment = "일시불" + " / "; // 할부
		int k04_cardPay = k04_total; // 카드 결제

		System.out.printf("                  이마트 %s(%s)%s\n", k04_storeName, k04_storeTelAreaCode, k04_storeTelNum);
		// 점포지역,전화번호 출력
		System.out.printf("   emart          %s %s\n", k04_bizNum, k04_storeBoss); // 사업자번호, 가게주인 출력
		System.out.printf("                  %s\n\n", k04_storeAddr); // 이마트 주소
		System.out.printf("영수증 미지참시 교환/환불 불가(30일내)\n"); // 글 출력
		System.out.printf("교환/환불 구매점에서 가능(결제카드지참)\n"); // 글 출력
		System.out.printf("체크카드/신용카드 청구취소 반영은\n"); // 글 출력
		System.out.printf("최대 3~5일 소요 (주말,공휴일제외)\n\n"); // 글 출력
		System.out.printf("[구 매]%s          POS:%04d-2418\n", k04_sdf.format(k04_cald.getTime()), k04_POSNum);
		// 날짜, 포스번호, 출력
		System.out.printf("----------------------------------------------\n"); // 줄 출력
		System.out.printf("   상 품 명            단  가  수량    금  액 \n"); // 헤더 출력
		System.out.printf("----------------------------------------------\n"); // 줄 출력
		for (int k04_i = 0; k04_i < k04_taxFree.length; k04_i++) { // 물건개수만큼 for문 실행
			if (k04_taxFree[k04_i]) { // 만약 비과세이면
				System.out.printf("%02d*  ", k04_i + 1); // 숫자뒤에 별표시
			} else { // 아니면
				System.out.printf("%02d   ", k04_i + 1); // 숫자뒤에 공백
			}

			int k04_byte = 0; // 물건 이름 바이트 계산 위한 변수 선언
			for (int k04_j = 0; k04_j < k04_itemName[k04_i].length(); k04_j++) { // 물건 이름길이만큼 for문 실행
				if (k04_itemName[k04_i].substring(k04_j, k04_j + 1).matches("^[ㄱ-ㅎ가-힣]*$")) { // 각 글자가 한글이면
					k04_byte = k04_byte + 2; // 바이트에 2 추가
				} else { // 한글이 아니면
					k04_byte++; // 1 추가
				}
			}
			int k04_minusByte = 0; // 얼만큼의 바이트를 뺐는지에 대한 변수
			int k04_byte2 = k04_byte; // 바이트 사용하기 위한 복제 변수
			int k04_space = 14; // 14의 공간 변수
			if (k04_byte2 < k04_space) { // 바이트가 14보다 작으면
				System.out.printf("%s", k04_itemName[k04_i]); // 물건이름 출력
				for (int k04_k = 0; k04_k < k04_space - k04_byte2; k04_k++) { // 14에서 물건이름바이트를 뺀만큼 for 실행
					System.out.printf(" "); // 바이트가 14가 될 때까지 공백 출력
				}
				System.out.printf("%11s", k04_df.format(k04_price[k04_i])); // 가격 11s까지 출력가능
				System.out.printf("%5s", k04_df.format(k04_num[k04_i])); // 수량 5s까지 출력가능
				System.out.printf("%11s\n", k04_df.format(k04_price[k04_i] * k04_num[k04_i])); // 금액 11s까지 출력가능
			} else { // 바이트가 18보다 크면
				for (int k04_j = 0; k04_j < k04_byte2 - k04_space; k04_j++) { // 바이트에 14을 뺀 만큼 for 실행
					if (k04_itemName[k04_i].substring(k04_itemName[k04_i].length() - 1, k04_itemName[k04_i].length())
							.matches("^[ㄱ-ㅎ가-힣]*$")) { // 물건이름의 마지막 단어가 한글이면
						k04_itemName[k04_i] = k04_itemName[k04_i].substring(0, k04_itemName[k04_i].length() - 1);
						// 마지막 단어 하나 뺌
						k04_byte2 = k04_byte2 - 1; // 한글은 2바이트기 때문에 추가로 1개 더 빼줌
						k04_minusByte = k04_minusByte + 2; // 2바이트 빠진 것 변수에 추가
					} else { // 마지막 단어가 한글이 아니면
						k04_itemName[k04_i] = k04_itemName[k04_i].substring(0, k04_itemName[k04_i].length() - 1);
						// 마지막 단어 하나 뺌
						k04_minusByte++; // 1바이트 빠진 것 변수에 추가
					}
				}
				System.out.printf("%s", k04_itemName[k04_i]); // 물건이름 출력
				if ((k04_byte - k04_space == 1 || k04_byte - k04_space == 3 || k04_byte - k04_space == 5
						|| k04_byte - k04_space == 7)
						&& (k04_minusByte == 2 || k04_minusByte == 4 || k04_minusByte == 6 || k04_minusByte == 8)) {
					// 바이트가 1이나 3이 빠져야 되는데 한개씩 더 빠지면
					System.out.printf(" "); // 공백 출력, 왜냐면 바이트 1씩 손실남
				} else if ((k04_byte - k04_space == 2 || k04_byte - k04_space == 4 || k04_byte - k04_space == 6
						|| k04_byte - k04_space == 8)
						&& (k04_minusByte == 3 || k04_minusByte == 5 || k04_minusByte == 7 || k04_minusByte == 9)) {
					// 바이트가 2나 4가 빠져야 되는데 한개씩 더 빠지면
					System.out.printf(" "); // 공백 출력, 왜냐면 바이트 1씩 손실남
				}
				System.out.printf("%11s", k04_df.format(k04_price[k04_i])); // 가격 11s까지 출력가능
				System.out.printf("%5s", k04_df.format(k04_num[k04_i])); // 수량 5s까지 출력가능
				System.out.printf("%11s\n", k04_df.format(k04_price[k04_i] * k04_num[k04_i])); // 금액 11s까지 출력가능
			}
			k04_byte = 0; // 바이트 0으로 초기화
		}

		System.out.printf("            (*)면 세  물 품%19s\n", k04_df.format(k04_taxFreeSum)); // 면세물품
		System.out.printf("               과 세  물 품%19s\n", k04_df.format(k04_netV)); // 과세 물품
		System.out.printf("               부   가   세%19s\n", k04_df.format(k04_taxV)); // 부가세
		System.out.printf("               합        계%19s\n", k04_df.format(k04_total)); // 합계
		System.out.printf("결 제 대 상 금 액%29s\n", k04_df.format(k04_total)); // 결제대상금액
		System.out.printf("----------------------------------------------\n"); // 줄 출력
		System.out.printf("0024 %s           %15s/%8s\n", k04_cardName, k04_cardNum, k04_cardNum2); // 카드번호 출력
		System.out.printf("카드결제%35.35s\n", k04_installment + k04_df.format(k04_cardPay));
		// 할부여부, 카드결제금액
		System.out.printf("----------------------------------------------\n"); // 줄 출력
		System.out.printf("홍*두 고객님의 포인트 현황입니다.\n"); // 줄 출력

	}
}
