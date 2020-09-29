package biz_200624;

import java.util.ArrayList;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_ArrayList2 {
	public static void main(String[] args) {
		int k04_iTestMAX = 1000000;// for문을 얼마나 돌릴 것인지에 대한 변수
		ArrayList<Integer> k04_iAL = new ArrayList<>(); // 어레이 인티저 생성
		for (int k04_i = 0; k04_i < k04_iTestMAX; k04_i++) { // 0에서 백만까지 for문 실행
			k04_iAL.add((int) (Math.random() * 1000000)); // 수학점수 1000000개 생성후 어레이에 저장
		}

		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) {// 어레이 사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %d\n", k04_i, k04_iAL.get(k04_i));
			// 어레이를 for문 실행에 따라 출력
		}

		System.out.printf("*********************************\n"); // 줄 출력
		k04_iAL.sort(null); // 어레이를 정렬시킴

		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) { // 어레이 사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %d\n", k04_i, k04_iAL.get(k04_i));
			// 어레이를 for문 실행에 따라 출력
		}
	}
}
