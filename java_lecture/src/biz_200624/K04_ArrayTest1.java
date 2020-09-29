package biz_200624;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_ArrayTest1 {
	public static void main(String[] args) {
		int[] k04_iArray = { 1, 3, 5, 7, 9 }; // 배열 int[5]로 값 직접 입력해서 만듬
		for (int k04_i = 0; k04_i < 5; k04_i++) { // for문 5번 실행
			System.out.printf("k04_iArray[%d]=%d\n", k04_i, k04_iArray[k04_i]);
			// 어레이 출력
		}
		k04_iArray[5] = 11; // 배열 0에서 4번까지 있어서 이건 아웃바운드됨
	}
}
