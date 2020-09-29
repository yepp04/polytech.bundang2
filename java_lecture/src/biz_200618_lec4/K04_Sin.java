package biz_200618_lec4;

//BIZ프로그래밍 4강 선택,반복,배열 실습 200619 강진성
public class K04_Sin {
	public static void main(String[] args) {
		//
		// sin 그래프를 그려보자
		// 360도 : 2pi = 1도 : x
		//
		double k04_fSin; // sin의 삼각비 변수 선언

		for (int k04_i = 0; k04_i < 360; k04_i++) { // 360도까지 값이 어찌 나오나
			k04_fSin = Math.sin(k04_i * 3.141592 / 180); // sin의 삼각비 계산(radian)
			System.out.printf("%d sin ==> %f\n", k04_i, k04_fSin); // i도의 sin은 삼각비가 ###라고 출력
		}

		for (int k04_i = 0; k04_i < 360; k04_i++) { // 360도까지 그리자
			k04_fSin = Math.sin(k04_i * 3.141592 / 180); // sin의 삼각비 계산(radian)
			int k04_iSpace = (int) ((1.0 - k04_fSin) * 50); // iSpace는 1에서 삼각비 값을 빼서 50을 곱한 값을 인트로 캐스팅

			for (int k04_j = 0; k04_j < k04_iSpace; k04_j++) { // for문에서 j는 iSpace의 크기 -1 만큼 돌아감
				System.out.printf(" "); // 띄어쓰기 출력
			}
			System.out.printf("*[%f][%d]\n", k04_fSin, k04_iSpace); // 띄어쓰기된 그 뒤에 sin 값과 iSpace값 출력
		}
	}
}
