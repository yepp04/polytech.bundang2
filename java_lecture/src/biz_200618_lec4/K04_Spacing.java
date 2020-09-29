package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200619 강진성
public class K04_Spacing {
	public static void main(String[] args) {
		////////////////
		// 띄어쓰기 연습
		//
		// 그냥 이론적 연습
		for (int k04_i = 0; k04_i < 10; k04_i++) { // for문의 i를 0에서 9까지 돌림
			for (int k04_j = 0; k04_j < k04_i; k04_j++) { // for문 j를 0에서 i보다 작은 만큼 돌림(최대 9번 돌기)
				System.out.printf(" "); // 돌려줄 때 띄어쓰기 출력
			}
			System.out.printf("%d\n", k04_i); // i가 0에서 9까지 출력
		}
	}
}
