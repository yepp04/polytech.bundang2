package biz_200619;

//BIZ프로그래밍 5강 실무실습1 실습 200619 강진성
public class K04_Calendar {
	public static void main(String[] args) {
		int k04_iWeekday = 3; // 0(일) 1(월) 2(화) 3(수) 1월이 수요일 시작이라 3임
		int[] k04_iEnd = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 각 달에 대한 끝자리 날 배열로 입력
		for (int k04_iMon = 0; k04_iMon < 12; k04_iMon++) { // 0부터 11까지 12번 돌기
			System.out.printf("\n\n         %d월\n", k04_iMon + 1);
			// i_Mon에 1을 더해줘서 1~12월 출력
			System.out.printf("======================\n"); // 밑줄 및 개행 출력
			System.out.printf(" 일 월 화 수 목 금 토\n"); // 요일 헤더 출력
			for (int k04_space = 0; k04_space < k04_iWeekday; k04_space++) {
				// 처음에 띄어쓰기로 날짜와 요일을 맞춰준다
				System.out.printf("   "); // 띄어쓰기 3번이 하나의 요일임
			}
			for (int k04_i = 0; k04_i < k04_iEnd[k04_iMon]; k04_i++) {
				// 배열에서 각 월에 대한 마지막 날짜만큼 for문 돌림
				System.out.printf(" %2d", k04_i + 1); // 날짜 출력
				k04_iWeekday++; // 돌 때마다 iWeekday를 1 더하기
				if (k04_iWeekday == 7) { // iWeekday가 7이 되면
					k04_iWeekday = 0; // iWeekday를 0으로 초기화
					if (k04_i == k04_iEnd[k04_iMon] - 1) {
						// weekday가 7일 때 마지막날이랑 겹치면 개행 X
					} else { // 아니면
						System.out.printf("\n"); // 개행
					}
				}
			}
		}
	}
}
