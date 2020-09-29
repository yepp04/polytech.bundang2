package biz_200624;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_ArrayTest2 {
	public static void main(String[] args) {
		int[] k04_iArray = { 1, 7, 5, 3, 2, 1, 3, 4, 9, 12, 0, 212, 33, 11, 21, 11, 2121, 121, 11, 5, 6, 33 };
		// 배열 값 숫자 무작위로 쓰기
		for (int k04_i = 0; k04_i < k04_iArray.length; k04_i++) { // 배열길이만큼 for문실행
			System.out.printf("k04_iArray[%d]=%d\n", k04_i, k04_iArray[k04_i]);
			// 배열값 출력
		}
		//
		// MAX, MIN 찾기
		//

		int k04_iMax = k04_iArray[0]; // 처음시작배열부터 시작
		int k04_iMaxPt = 0; // 몇번째 배열이 가장 클지 찾는 번호
		for (int k04_i = 0; k04_i < k04_iArray.length; k04_i++) { // 배열개수만큼 루프반복
			if (k04_iMax < k04_iArray[k04_i]) { // 만일 기존맥스변수보다 배열값이 크다면
				k04_iMax = k04_iArray[k04_i]; // 기존맥스변수값을 배열값으로 바꿈
				k04_iMaxPt = k04_i; // 기존맥스변수배열위치값도 바꿈
			}
		}
		int k04_iMin = k04_iArray[0]; // 처음시작배열부터 시작
		int k04_iMinPt = 0; // 몇번째 배열이 가장 작을지 찾는 번호
		for (int k04_i = 0; k04_i < k04_iArray.length; k04_i++) { // 배열개수만큼 루프반복
			if (k04_iMin > k04_iArray[k04_i]) { // 만일 기존민변수보다 배열값이 작다면
				k04_iMin = k04_iArray[k04_i]; // 기존민변수값을 배열값으로 바꿈
				k04_iMinPt = k04_i; // 기존민변수배열위치값도 바꿈
			}
		}
		System.out.printf("MAX : k04_iArray[%d]=%d\n", k04_iMaxPt, k04_iMax);
		// 배열값 출력
		System.out.printf("MIN : k04_iArray[%d]=%d\n", k04_iMinPt, k04_iMin);
		// 배열값 출력
	}
}
