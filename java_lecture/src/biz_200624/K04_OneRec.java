package biz_200624;

//BIZ프로그래밍 7강 String, Byte, StringBuffer, Array, ArrayList 실습 200624 강진성
public class K04_OneRec {
	private String k04_name; // 이름 변수
	private int k04_kor; // 국어점수 변수
	private int k04_eng; // 영어점수 변수
	private int k04_mat; // 수학점수 변수

	public K04_OneRec(String k04_name, int k04_kor, int k04_eng, int k04_mat) {
		// 클래스 생성자에 이름, 국어, 영어, 수학, 합계, 평균이 있다
		this.k04_name = k04_name;// 이름
		this.k04_kor = k04_kor; // 국어
		this.k04_eng = k04_eng; // 영어
		this.k04_mat = k04_mat; // 수학
		k04_sum(); // 합계
		k04_ave(); // 평균
	}

	public String k04_name() {
		return this.k04_name; // 이름 게터
	}

	public int k04_kor() {
		return this.k04_kor; // 국어 게터
	}

	public int k04_eng() {
		return this.k04_eng; // 영어 게터
	}

	public int k04_mat() {
		return this.k04_mat; // 수학 게터
	}

	public int k04_sum() {
		return this.k04_kor + this.k04_eng + this.k04_mat; // 합계 게터
	}

	public double k04_ave() {
		return this.k04_sum() / 3.0; // 평균 게터
	}

	public static void main(String[] args) {

		int k04_iPerson = 5; // 사람수

		K04_OneRec[] k04_inData = new K04_OneRec[k04_iPerson]; // 클래스 배열 생성
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) { // 사람수만큼 for문 돌림
			String k04_name = String.format("홍길%02d", k04_i + 1); // 이름은 홍길00 식
			int k04_kor = (int) (Math.random() * 100); // 국어 점수 랜덤
			int k04_eng = (int) (Math.random() * 100); // 영어 점수 랜덤
			int k04_mat = (int) (Math.random() * 100); // 수학 점수 랜덤
			k04_inData[k04_i] = new K04_OneRec(k04_name, k04_kor, k04_eng, k04_mat);
			// 클래스 배열 안에 생성자 값 입력
		}
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) { // 사람수만큼 for문 돌림
			System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n", k04_i + 1,
					k04_inData[k04_i].k04_name(), k04_inData[k04_i].k04_kor(), k04_inData[k04_i].k04_eng(),
					k04_inData[k04_i].k04_mat(), k04_inData[k04_i].k04_sum(), k04_inData[k04_i].k04_ave());
			// 번호와 이름, 국어, 영어, 수학, 총점, 평균 출력
		}
	}
}
