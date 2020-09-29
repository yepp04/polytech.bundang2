package biz_200624;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
import java.util.ArrayList;

public class K04_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> k04_iAL = new ArrayList<>(); // 어레이리스트 스트링으로 생성
		k04_iAL.add("abc"); // 0번 어레이리스트 값 입력
		k04_iAL.add("abcd");// 1번 어레이리스트 값 입력
		k04_iAL.add("efga");// 2번 어레이리스트 값 입력
		k04_iAL.add("가나다0");// 3번 어레이리스트 값 입력
		k04_iAL.add("1234");// 4번 어레이리스트 값 입력
		k04_iAL.add("12rk34");// 5번 어레이리스트 값 입력
		// 어레이리스트를 스트링으로 쓰려고 하는데 숫자값만 넣으면 안됨
		// k04_iAL.add(356); 같은거
		System.out.printf("*************************\n"); // 줄 출력
		System.out.printf("시작 ArraySize %d \n", k04_iAL.size()); // 어레이 사이즈 출력
		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) { // 어레이사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %s\n", k04_i, k04_iAL.get(k04_i)); // 0번부터 5번까지 출력
		}

		k04_iAL.set(3, "가라라라"); // 3번 어레이리스트 내용변경
		System.out.printf("*************************\n"); // 줄 출력
		System.out.printf("내용변경 ArraySize %d \n", k04_iAL.size()); // 어레이 사이즈 출력
		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) {// 어레이사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %s\n", k04_i, k04_iAL.get(k04_i));// 0번부터 5번까지 출력
		}

		k04_iAL.remove(4); // 4번 어레이리스트 삭제
		System.out.printf("*************************\n");// 줄 출력
		System.out.printf("내용변경 ArraySize %d \n", k04_iAL.size());// 어레이 사이즈 출력
		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) {// 어레이사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %s\n", k04_i, k04_iAL.get(k04_i));// 0번부터 4번까지 출력
		}

		k04_iAL.sort(null); // 리스트 sort
		System.out.printf("*************************\n");// 줄 출력
		System.out.printf("리스트Sort ArraySize %d \n", k04_iAL.size());// 어레이 사이즈 출력
		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) {// 어레이사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %s\n", k04_i, k04_iAL.get(k04_i));// 0번부터 4번까지 출력
		}

		k04_iAL.clear(); // 어레이리스트 삭제
		System.out.printf("*************************\n");// 줄 출력
		System.out.printf("전부 삭제 ArraySize %d \n", k04_iAL.size());// 어레이 사이즈 출력
		for (int k04_i = 0; k04_i < k04_iAL.size(); k04_i++) {// 어레이사이즈만큼 for문 실행
			System.out.printf(" ArrayList %d = %s\n", k04_i, k04_iAL.get(k04_i));
		}
	}
}
