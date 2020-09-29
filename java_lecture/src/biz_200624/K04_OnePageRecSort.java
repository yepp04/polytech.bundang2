package biz_200624;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성

class K04_Record2 {
	static ArrayList<K04_Record2> k04_ArrayOneRec = new ArrayList<>();
	private int k04_studentId; // 번호
	private String k04_name; // 이름
	private int k04_kor; // 국어점수
	private int k04_eng; // 영어점수
	private int k04_mat; // 수학점수
	static int k04_sumkor = 0; // 국어점수 합계
	static int k04_sumeng = 0; // 영어점수 합계
	static int k04_summat = 0; // 수학점수 합계
	static int k04_sumsum = 0; // 합계점수 합계
	static double k04_sumave = 0.0; // 평균점수 합계
	static double k04_aveDivide = 0.0; // 평균나눌 수
	static int k04_sumkorNow = 0; // 현페이지 국어점수 합계
	static int k04_sumengNow = 0; // 현페이지 영어점수 합계
	static int k04_summatNow = 0; // 현페이지 수학점수 합계
	static int k04_sumsumNow = 0; // 현페이지 합계점수 합계
	static double k04_sumaveNow = 0.0; // 현페이지 평균점수 합계
	static double k04_aveDivideNow = 0.0; // 현페이지 평균 나눌 수
	static int k04_iPerson = 1000; // 사람 수

	public int k04_studentId() { // 번호 게터
		return this.k04_studentId;
	}

	public String k04_name() { // 이름 게터
		return this.k04_name;
	}

	public int k04_kor() { // 국어 게터
		return this.k04_kor;
	}

	public int k04_eng() { // 영어 게터
		return this.k04_eng;
	}

	public int k04_mat() { // 수학 게터
		return this.k04_mat;
	}

	public int k04_sum() { // 합계 게터
		return this.k04_kor + this.k04_eng + this.k04_mat;
	}

	public double k04_ave() { // 평균 게터
		return this.k04_sum() / 3.0; // 합계에 3.0(더블값)나눔
	}

	public K04_Record2(int k04_studentId, String k04_name, int k04_kor, int k04_eng, int k04_mat) {
		// 생성자 번호, 이름, 국어점수, 영어점수, 수학점수
		this.k04_studentId = k04_studentId; // 번호
		this.k04_name = k04_name; // 이름
		this.k04_kor = k04_kor; // 국어점수
		this.k04_eng = k04_eng; // 영어점수
		this.k04_mat = k04_mat; // 수학점수
	}

	public static void k04_dataSet() {
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) {// 사람수만큼 for문 실행
			String k04_name = String.format("홍길%02d", k04_i + 1); // 이름만들기
			int k04_kor = (int) (Math.random() * 100); // 국어점수 만들기
			int k04_eng = (int) (Math.random() * 100); // 영어점수 만들기
			int k04_mat = (int) (Math.random() * 100); // 수학점수 만들기
			k04_ArrayOneRec.add(new K04_Record2(k04_i + 1, k04_name, k04_kor, k04_eng, k04_mat));
			// 하나의 OneRec2클래스를 생성 후 ArrayList에 집어넣었다
		}
	}

	// 헤더 인쇄
	public static void k04_HeaderPrint(int k04_i) {
		String k04_printDate = "출력일자 : ";
		System.out.printf("                     성적집계표\n\n");
		Calendar k04_cald = Calendar.getInstance(); // 캘린더 인스턴스를 생성한다
		SimpleDateFormat k04_sdf = new SimpleDateFormat("yyyy.M.dd HH:mm:ss"); // sdf 인스턴스를 생성 후 날짜시간의 모양을 지정
		System.out.printf("PAGE : %-10d%42s\n", k04_i + 1, k04_printDate + k04_sdf.format(k04_cald.getTime()));
		// 페이지 수 출력 및 현재시간 출력
		System.out.printf("===============================================================\n"); // 줄 출력
		System.out.printf("%2s %5s %6s %4s %4s %4s   %3s\n", "번호", "이름", "국어", "영어", "수학", "총점", "평균");
		System.out.printf("===============================================================\n");
	}

	public static void k04_plus(int k04_i) {
		K04_Record2 k04_rec; // 클래스 변수 선언
		k04_rec = k04_ArrayOneRec.get(k04_i); // 클래스 변수에 어레이 값 저장
		k04_sumkor += k04_rec.k04_kor(); // 국어점수 합하기
		k04_sumeng += k04_rec.k04_eng(); // 영어점수 합하기
		k04_summat += k04_rec.k04_mat(); // 수학점수 합하기
		k04_sumsum += k04_rec.k04_sum(); // 합계점수 합하기
		k04_sumave += k04_rec.k04_ave(); // 평균점수 합하기
		k04_sumkorNow += k04_rec.k04_kor(); // 현페이지 국어점수 합하기
		k04_sumengNow += k04_rec.k04_eng(); // 현페이지 영어점수 합하기
		k04_summatNow += k04_rec.k04_mat(); // 현페이지 수학점수 합하기
		k04_sumsumNow += k04_rec.k04_sum(); // 현페이지 합계점수 합하기
		k04_sumaveNow += k04_rec.k04_ave(); // 현페이지 평균점수 합하기

		k04_aveDivide++; // 누적 평균 나눌 수 1 추가
		k04_aveDivideNow++; // 현 페이지 평균 나눌 수 1 추가
	}

	// 내용 인쇄
	public static void k04_ItemPrint(int k04_i) {
		K04_Record2 k04_rec; // 클래스 변수 선언
		k04_rec = k04_ArrayOneRec.get(k04_i); // 클래스 변수에 어레이 값 저장
		if (k04_rec.k04_studentId() >= 10000) {
			System.out.printf("%03d   %-7s%4d%7d%7d   %4d  %6.0f\n", k04_rec.k04_studentId(), k04_rec.k04_name(),
					k04_rec.k04_kor(), k04_rec.k04_eng(), k04_rec.k04_mat(), k04_rec.k04_sum(), k04_rec.k04_ave());
			k04_plus(k04_i);
			return;
		}
		if (k04_rec.k04_studentId() >= 1000) {
			System.out.printf("%03d    %-7s%4d%7d%7d   %4d  %6.0f\n", k04_rec.k04_studentId(), k04_rec.k04_name(),
					k04_rec.k04_kor(), k04_rec.k04_eng(), k04_rec.k04_mat(), k04_rec.k04_sum(), k04_rec.k04_ave());
			k04_plus(k04_i);
			return;
		}
		System.out.printf("%03d     %-7s%4d%7d%7d   %4d  %6.0f\n", k04_rec.k04_studentId(), k04_rec.k04_name(),
				k04_rec.k04_kor(), k04_rec.k04_eng(), k04_rec.k04_mat(), k04_rec.k04_sum(), k04_rec.k04_ave());
		// 어레이에 속한 각 값을 출력
		k04_plus(k04_i);
	}

	public static void k04_NowZero() {// 현페이지 점수를 구하기 위해 이전점수 초기화
		k04_sumkorNow = 0; // 국어점수 초기화
		k04_sumengNow = 0; // 영어점수 초기화
		k04_summatNow = 0; // 수학점수 초기화
		k04_sumsumNow = 0; // 합계점수 초기화
		k04_sumaveNow = 0; // 평균점수 초기화
		k04_aveDivideNow = 0; // 평균 나눌 수 초기화
	}

	// 현재꼬리 인쇄
	public static void k04_TailPrintNow() {
		System.out.printf("===============================================================\n");
		System.out.printf("현재페이지\n");// 현재페이지 출력
		System.out.printf("합계%17d%7d%7d%7d%8.0f\n", k04_sumkorNow, k04_sumengNow, k04_summatNow, k04_sumsumNow,
				k04_sumaveNow); // 합계 출력
		System.out.printf("평균%17.0f%7.0f%7.0f%7.0f%8.0f\n", k04_sumkorNow / (double) k04_aveDivideNow,
				k04_sumengNow / (double) k04_aveDivideNow, k04_summatNow / (double) k04_aveDivideNow,
				k04_sumsumNow / (double) k04_aveDivideNow, k04_sumaveNow / (double) k04_aveDivideNow);
		// 평균 출력
		k04_NowZero(); // 현재페이지 합계 및 평균 초기화
	}

	// 누적꼬리 인쇄
	public static void k04_TailPrint() {
		System.out.printf("===============================================================\n");
		System.out.printf("누적페이지\n"); // 누적페이지 출력
		System.out.printf("합계%17d%7d%7d%7d%8.0f\n", k04_sumkor, k04_sumeng, k04_summat, k04_sumsum, k04_sumave);
		// 누적페이지 합계 출력
		System.out.printf("평균%17.0f%7.0f%7.0f%7.0f%8.0f\n\n", k04_sumkor / (double) k04_aveDivide,
				k04_sumeng / (double) k04_aveDivide, k04_summat / (double) k04_aveDivide,
				k04_sumsum / (double) k04_aveDivide, k04_sumave / (double) k04_aveDivide);
		// 누적페이지 평균 출력
	}

	public static void k04_dataSort() {
		Comparator<K04_Record2> k04_bikyeokijun = new Comparator<K04_Record2>() {
			// 클래스 등 복잡한 ArrayList의 소트는 Comparator, Collections를 이용
			@Override
			public int compare(K04_Record2 k04_o1, K04_Record2 k04_o2) {
				// TODO Auto-generated method stub
				// 만일 문자형 비교면 아래와 같이 써줌
				// return (String.valueOf(o1.k04_kor).compareTo(String.valueOf(o2.k04_kor)));
				return (k04_o2.k04_sum() - k04_o1.k04_sum());
				// 뒤레코드의 합계와 앞레코드의 합계 필드를 빼는 것을 비교
			}
		};
		Collections.sort(k04_ArrayOneRec, k04_bikyeokijun); // 설정한 내용대로 정렬
		// Collections.reverse(k04_ArrayOneRec); // 역정렬
	}
}

public class K04_OnePageRecSort {
	public static void main(String[] args) {
		int k04_OnePage = 10; // 한 페이지 수
		if (K04_Record2.k04_iPerson % k04_OnePage == 0) { // 나눠서 딱떨어지면
			for (int k04_i = 0; k04_i < (K04_Record2.k04_iPerson / k04_OnePage); k04_i++) {
				// 사람수를 페이지수만큼 나눈 값보다 1 더해서 for문 실행
				K04_Record2.k04_dataSet(); // 데이터를 어레이에 저장하는 메서드
				K04_Record2.k04_dataSort();
				K04_Record2.k04_HeaderPrint(k04_i); // 헤더 출력
				for (int k04_j = 0 + (k04_OnePage * k04_i); k04_j < k04_OnePage + (k04_OnePage * (k04_i)); k04_j++) {
					// 0~한페이지수, 다음페이지~한페이지수 식으로 끊어감
					if (k04_j == K04_Record2.k04_iPerson) {// 만약 j값이 사람수랑 일치하면
						break; // 나감
					}
					K04_Record2.k04_ItemPrint(k04_j); // 성적 출력
				}
				K04_Record2.k04_TailPrintNow();// 현재페이지 출력
				K04_Record2.k04_TailPrint(); // 누적페이지 출력
			}
		} else { // 나눠서 딱 떨어지지 않으면
			for (int k04_i = 0; k04_i < (K04_Record2.k04_iPerson / k04_OnePage) + 1; k04_i++) {
				// 사람수를 페이지수만큼 나눈 값보다 1 더해서 for문 실행
				K04_Record2.k04_dataSet(); // 데이터를 어레이에 저장하는 메서드
				K04_Record2.k04_HeaderPrint(k04_i); // 헤더 출력
				for (int k04_j = 0 + (k04_OnePage * k04_i); k04_j < k04_OnePage + (k04_OnePage * (k04_i)); k04_j++) {
					// 0~한페이지수, 다음페이지~한페이지수 식으로 끊어감
					if (k04_j == K04_Record2.k04_iPerson) {// 만약 j값이 사람수랑 일치하면
						break; // 나감
					}
					K04_Record2.k04_ItemPrint(k04_j); // 성적 출력
				}
				K04_Record2.k04_TailPrintNow();// 현재페이지 출력
				K04_Record2.k04_TailPrint(); // 누적페이지 출력
			}
		}
	}
}