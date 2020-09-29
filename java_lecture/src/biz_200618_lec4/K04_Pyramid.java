package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200619 강진성
public class K04_Pyramid {
	public static void main(String[] args) {
		int k04_m = 20;
		int k04_n = 1;

		while (true) {
			for (int k04_i = 0; k04_i < k04_m; k04_i++) { // 초기값 m은 20까지 있음
				System.out.printf(" "); // 초기값 처음 20칸 띄어쓰기 하고 점점 줄어들듯
			}
			for (int k04_i = 0; k04_i < k04_n; k04_i++) { // 초기값 n은 1임
				System.out.printf("★"); // 초기값 1이므로 별 한개 찍어줌
			}
			System.out.printf("\n"); // 개행 출력

			k04_m = k04_m - 1; // 초기값 20칸 띄우다가 -1칸씩 줄어듬 20 19 18...
			k04_n = k04_n + 2; // 초기값 20칸 띄운 뒤에 별하나 출력 그후 19칸 뒤 3, 18칸 뒤 식으로 출력

			if (k04_m < 0) { // m이 0보다 작으면
				break; // 나감
			}
		}
	}
}
