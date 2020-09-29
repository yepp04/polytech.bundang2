package biz_200624;

import java.util.ArrayList;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_OneRec2 {

	private int k04_studentId; // 번호
	private String k04_name; // 이름
	private int k04_kor; // 국어점수
	private int k04_eng; // 영어점수
	private int k04_mat; // 수학점수

	public K04_OneRec2(int k04_studentId, String k04_name, int k04_kor, int k04_eng, int k04_mat) {
		// 생성자 : 번호, 이름, 국어점수, 영어점수, 수학점수
		this.k04_studentId = k04_studentId; // 번호
		this.k04_name = k04_name; // 이름
		this.k04_kor = k04_kor; // 국어점수
		this.k04_eng = k04_eng; // 영어점수
		this.k04_mat = k04_mat; // 수학점수
	}

	public int k04_studentId() { // 번호 게터
		return this.k04_studentId;
	}

	public String k04_name() { // 이름 게터
		return this.k04_name;
	}

	public int k04_kor() { // 국어점수 게터
		return this.k04_kor;
	}

	public int k04_eng() { // 영어점수 게터
		return this.k04_eng;
	}

	public int k04_mat() { // 수학점수 게터
		return this.k04_mat;
	}

	public int k04_sum() { // 합계 게터
		return this.k04_kor + this.k04_eng + this.k04_mat;
	}

	public double k04_ave() { // 평균 게터
		return this.k04_sum() / 3.0;
	}

	static ArrayList<K04_OneRec2> k04_ArrayOneRec = new ArrayList<>(); // 클래스 어레이 생성
	static int k04_sumkor = 0; // 국어점수 합계
	static int k04_sumeng = 0; // 영어점수 합계
	static int k04_summat = 0; // 수학점수 합계
	static int k04_sumsum = 0; // 합계점수 합계
	static int k04_sumave = 0; // 평균점수 합계
	static final int k04_iPerson = 20; // 사람 수

	public static void k04_dataSet() { // 데이터 어레이에 입력하는 메서드
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) {// 사람수만큼 for문 실행
			String k04_name = String.format("홍길%02d", k04_i); // 이름만들기
			int k04_kor = (int) (Math.random() * 100); // 국어점수 만들기
			int k04_eng = (int) (Math.random() * 100); // 영어점수 만들기
			int k04_mat = (int) (Math.random() * 100); // 수학점수 만들기
			k04_ArrayOneRec.add(new K04_OneRec2(k04_i, k04_name, k04_kor, k04_eng, k04_mat));
			// 하나의 OneRec2클래스를 생성 후 ArrayList에 집어넣었다
		}
	}

	// 헤더 인쇄
	public static void k04_HeaderPrint() {
		System.out.printf("***************************************\n");
		System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "번호", "이름", "국어", "영어", "수학", "합계", "평균");
		System.out.printf("***************************************\n");
	}

	// 내용 인쇄
	public static void k04_ItemPrint(int k04_i) {
		K04_OneRec2 k04_rec; // 클래스 변수 생성
		k04_rec = k04_ArrayOneRec.get(k04_i); // 변수에 어레이에 있는 값을 저장
		System.out.printf("%4d %4s %3d %3d %3d   %3d  %6.2f\n", k04_rec.k04_studentId(), k04_rec.k04_name(),
				k04_rec.k04_kor(), k04_rec.k04_eng(), k04_rec.k04_mat(), k04_rec.k04_sum(), k04_rec.k04_ave());
		// 값 출력

		k04_sumkor += k04_rec.k04_kor(); // 국어점수 합하기
		k04_sumeng += k04_rec.k04_eng(); // 영어점수 합하기
		k04_summat += k04_rec.k04_mat(); // 수학점수 합하기
		k04_sumsum += k04_rec.k04_sum(); // 합계점수 합하기
		k04_sumave += k04_rec.k04_ave(); // 평균점수 합하기
	}

	// 꼬리 인쇄
	public static void k04_TailPrint() {
		System.out.printf("***************************************\n");
		System.out.printf("국어합계 %d   국어평균: %6.2f\n", k04_sumkor, k04_sumkor / (double) k04_ArrayOneRec.size());
		// 국어합계 출력, 국어합계에서 어레이 사이즈를 더블로 캐스팅한 값을 나눈 평균을 출력
		System.out.printf("영어합계 %d   영어평균: %6.2f\n", k04_sumeng, k04_sumeng / (double) k04_ArrayOneRec.size());
		// 영어합계 출력, 영어합계에서 어레이 사이즈를 더블로 캐스팅한 값을 나눈 평균을 출력
		System.out.printf("수학합계 %d   수학평균: %6.2f\n", k04_summat, k04_summat / (double) k04_ArrayOneRec.size());
		// 수학합계 출력, 수학합계에서 어레이 사이즈를 더블로 캐스팅한 값을 나눈 평균을 출력
		System.out.printf("***************************************\n");
		System.out.printf("반평균합계 %d   반평균: %6.2f\n", k04_sumave, k04_sumave / (double) k04_ArrayOneRec.size());
		// 반평균합계 출력, 반평균합계에서 어레이 사이즈를 더블로 캐스팅한 값을 나눈 평균을 출력
	}

	public static void main(String[] args) {
		k04_dataSet(); // 데이터를 어레이에 입력하는 메서드
		k04_HeaderPrint(); // 헤더 출력
		for (int k04_i = 0; k04_i < k04_ArrayOneRec.size(); k04_i++) { // 어레이사이즈만큼 for문실행
			k04_ItemPrint(k04_i); // 내용 출력
		}
		k04_TailPrint(); // 꼬리 출력
	}
}
