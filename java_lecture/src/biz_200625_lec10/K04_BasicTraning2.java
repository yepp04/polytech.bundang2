package biz_200625_lec10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//BIZ프로그래밍 10강 JAVA DB 다루기 실습 200625 강진성

class K04_Record {
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
	static double k04_avekor = 0; // 국어점수 합계
	static double k04_aveeng = 0; // 영어점수 합계
	static double k04_avemat = 0; // 수학점수 합계
	static double k04_avesum = 0; // 합계점수 합계
	static double k04_aveave = 0.0; // 평균점수 합계

	static int k04_sumkorNow = 0; // 현페이지 국어점수 합계
	static int k04_sumengNow = 0; // 현페이지 영어점수 합계
	static int k04_summatNow = 0; // 현페이지 수학점수 합계
	static int k04_sumsumNow = 0; // 현페이지 합계점수 합계
	static double k04_sumaveNow = 0.0; // 현페이지 평균점수 합계

	static double k04_avekorNow = 0; // 현페이지 국어점수 평균
	static double k04_aveengNow = 0; // 현페이지 영어점수 평균
	static double k04_avematNow = 0; // 현페이지 수학점수 평균
	static double k04_avesumNow = 0; // 현페이지 합계점수 평균
	static double k04_aveaveNow = 0.0; // 현페이지 평균점수 평균

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

	static ArrayList<K04_Record> k04_ArrayOneRec = new ArrayList<>();

	public K04_Record(int k04_studentId, String k04_name, int k04_kor, int k04_eng, int k04_mat) {
		// 생성자 번호, 이름, 국어점수, 영어점수, 수학점수
		this.k04_studentId = k04_studentId; // 번호
		this.k04_name = k04_name; // 이름
		this.k04_kor = k04_kor; // 국어점수
		this.k04_eng = k04_eng; // 영어점수
		this.k04_mat = k04_mat; // 수학점수
	}

	public static void k04_dataSet() {
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) { // 사람수만큼 for문 실행
			String k04_name = String.format("홍길%02d", k04_i + 1); // 이름만들기
			int k04_kor = (int) (Math.random() * 100); // 국어점수 만들기
			int k04_eng = (int) (Math.random() * 100); // 영어점수 만들기
			int k04_mat = (int) (Math.random() * 100); // 수학점수 만들기
			k04_ArrayOneRec.add(new K04_Record(k04_i + 1, k04_name, k04_kor, k04_eng, k04_mat));
			// 하나의 OnePageRec클래스를 생성 후 ArrayList에 집어넣었다
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

	public static void k04_NowZero() {// 현페이지 점수를 구하기 위해 이전점수 초기화
		k04_sumkorNow = 0; // 국어점수 초기화
		k04_sumengNow = 0; // 영어점수 초기화
		k04_summatNow = 0; // 수학점수 초기화
		k04_sumsumNow = 0; // 합계점수 초기화
		k04_sumaveNow = 0; // 평균점수 초기화
	}

	// 현재꼬리 인쇄
	public static void k04_TailPrintNow(Connection k04_conn, int k04_start, int k04_OnePage) throws SQLException {
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		ResultSet k04_rsetKorSum = k04_stmt.executeQuery("select sum(kor) from (select kor from class_record limit "
				+ k04_start + ", " + k04_OnePage + ") as korsum;");
		// 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		k04_rsetKorSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumkorNow = k04_rsetKorSum.getInt(1);
		k04_rsetKorSum.close(); // ResultSet 닫음

		ResultSet k04_rsetEngSum = k04_stmt.executeQuery("select sum(eng) from (select eng from class_record limit "
				+ k04_start + ", " + k04_OnePage + ") as engsum;");
		k04_rsetEngSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumengNow = k04_rsetEngSum.getInt(1);
		k04_rsetEngSum.close(); // ResultSet 닫음

		ResultSet k04_rsetMatSum = k04_stmt.executeQuery("select sum(mat) from (select mat from class_record limit "
				+ k04_start + ", " + k04_OnePage + ") as matsum;");
		k04_rsetMatSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_summatNow = k04_rsetMatSum.getInt(1);
		k04_rsetMatSum.close(); // ResultSet 닫음

		ResultSet k04_rsetSumSum = k04_stmt
				.executeQuery("select sum(kor + eng + mat) from (select kor, eng, mat from class_record limit "
						+ k04_start + ", " + k04_OnePage + ") as sumsum;");
		k04_rsetSumSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumsumNow = k04_rsetSumSum.getInt(1);
		k04_rsetSumSum.close(); // ResultSet 닫음

		ResultSet k04_rsetAvgSum = k04_stmt
				.executeQuery("select sum((kor + eng + mat) / 3) from (select kor, eng, mat from class_record limit "
						+ k04_start + ", " + k04_OnePage + ") as avgsum;");
		k04_rsetAvgSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumaveNow = k04_rsetAvgSum.getInt(1);
		k04_rsetAvgSum.close(); // ResultSet 닫음

		ResultSet k04_rsetKorAvg = k04_stmt.executeQuery("select avg(kor) from (select kor from class_record limit "
				+ k04_start + ", " + k04_OnePage + ") as korsum;");
		k04_rsetKorAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_avekorNow = k04_rsetKorAvg.getFloat(1);
		k04_rsetKorAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetEngAvg = k04_stmt.executeQuery("select avg(eng) from (select eng from class_record limit "
				+ k04_start + ", " + k04_OnePage + ") as engsum;");
		k04_rsetEngAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_aveengNow = k04_rsetEngAvg.getFloat(1);
		k04_rsetEngAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetMatAvg = k04_stmt.executeQuery("select avg(mat) from (select mat from class_record limit "
				+ k04_start + ", " + k04_OnePage + ") as matsum;");
		k04_rsetMatAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_avematNow = k04_rsetMatAvg.getFloat(1);
		k04_rsetMatAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetSumAvg = k04_stmt
				.executeQuery("select avg(kor + eng + mat) from (select kor, eng, mat from class_record limit "
						+ k04_start + ", " + k04_OnePage + ") as sumsum;");
		k04_rsetSumAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_avesumNow = k04_rsetSumAvg.getFloat(1);
		k04_rsetSumAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetAvgAvg = k04_stmt
				.executeQuery("select avg((kor + eng + mat) / 3) from (select kor, eng, mat from class_record limit "
						+ k04_start + ", " + k04_OnePage + ") as avgsum;");
		k04_rsetAvgAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_aveaveNow = k04_rsetAvgAvg.getFloat(1);
		k04_rsetAvgAvg.close(); // ResultSet 닫음

		System.out.printf("===============================================================\n");
		System.out.printf("현재페이지\n");// 현재페이지 출력
		System.out.printf("합계%17d%7d%7d%7d%8.0f\n", k04_sumkorNow, k04_sumengNow, k04_summatNow, k04_sumsumNow,
				k04_sumaveNow); // 합계 출력
		System.out.printf("평균%17.0f%7.0f%7.0f%7.0f%8.0f\n", k04_avekorNow, k04_aveengNow, k04_avematNow, k04_avesumNow,
				k04_aveaveNow);
		// 평균 출력
		k04_NowZero(); // 현재페이지 합계 및 평균 초기화

		k04_stmt.close(); // Statement 닫음
	}

	// 누적꼬리 인쇄
	public static void k04_TailPrint(Connection k04_conn, int k04_0, int k04_plus) throws SQLException {

		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		ResultSet k04_rsetKorSum = k04_stmt.executeQuery(
				"select sum(kor) from (select kor from class_record limit " + k04_0 + ", " + k04_plus + ") as korsum;");
		// 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		k04_rsetKorSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumkor = k04_rsetKorSum.getInt(1);
		k04_rsetKorSum.close(); // ResultSet 닫음

		ResultSet k04_rsetEngSum = k04_stmt.executeQuery(
				"select sum(eng) from (select eng from class_record limit " + k04_0 + ", " + k04_plus + ") as engsum;");
		k04_rsetEngSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumeng = k04_rsetEngSum.getInt(1);
		k04_rsetEngSum.close(); // ResultSet 닫음

		ResultSet k04_rsetMatSum = k04_stmt.executeQuery(
				"select sum(mat) from (select mat from class_record limit " + k04_0 + ", " + k04_plus + ") as matsum;");
		k04_rsetMatSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_summat = k04_rsetMatSum.getInt(1);
		k04_rsetMatSum.close(); // ResultSet 닫음

		ResultSet k04_rsetSumSum = k04_stmt
				.executeQuery("select sum(kor + eng + mat) from (select kor, eng, mat from class_record limit " + k04_0
						+ ", " + k04_plus + ") as sumsum;");
		k04_rsetSumSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumsum = k04_rsetSumSum.getInt(1);
		k04_rsetSumSum.close(); // ResultSet 닫음

		ResultSet k04_rsetAvgSum = k04_stmt
				.executeQuery("select sum((kor + eng + mat) / 3) from (select kor, eng, mat from class_record limit "
						+ k04_0 + ", " + k04_plus + ") as avgsum;");
		k04_rsetAvgSum.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_sumave = k04_rsetAvgSum.getInt(1);
		k04_rsetAvgSum.close(); // ResultSet 닫음

		ResultSet k04_rsetKorAvg = k04_stmt.executeQuery(
				"select avg(kor) from (select kor from class_record limit " + k04_0 + ", " + k04_plus + ") as korsum;");
		k04_rsetKorAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_avekor = k04_rsetKorAvg.getFloat(1);
		k04_rsetKorAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetEngAvg = k04_stmt.executeQuery(
				"select avg(eng) from (select eng from class_record limit " + k04_0 + ", " + k04_plus + ") as engsum;");
		k04_rsetEngAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_aveeng = k04_rsetEngAvg.getFloat(1);
		k04_rsetEngAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetMatAvg = k04_stmt.executeQuery(
				"select avg(mat) from (select mat from class_record limit " + k04_0 + ", " + k04_plus + ") as matsum;");
		k04_rsetMatAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_avemat = k04_rsetMatAvg.getFloat(1);
		k04_rsetMatAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetSumAvg = k04_stmt
				.executeQuery("select avg(kor + eng + mat) from (select kor, eng, mat from class_record limit " + k04_0
						+ ", " + k04_plus + ") as sumsum;");
		k04_rsetSumAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_avesum = k04_rsetSumAvg.getFloat(1);
		k04_rsetSumAvg.close(); // ResultSet 닫음

		ResultSet k04_rsetAvgAvg = k04_stmt
				.executeQuery("select avg((kor + eng + mat) / 3) from (select kor, eng, mat from class_record limit "
						+ k04_0 + ", " + k04_plus + ") as avgsum;");
		k04_rsetAvgAvg.next();// ResultSet 객체를 한 줄씩 읽어라
		k04_aveave = k04_rsetAvgAvg.getFloat(1);
		k04_rsetAvgAvg.close(); // ResultSet 닫음

		System.out.printf("===============================================================\n");
		System.out.printf("누적페이지\n"); // 누적페이지 출력
		System.out.printf("합계%17d%7d%7d%7d%8.0f\n", k04_sumkor, k04_sumeng, k04_summat, k04_sumsum, k04_sumave);
		// 누적페이지 합계 출력
		System.out.printf("평균%17.0f%7.0f%7.0f%7.0f%8.0f\n\n", k04_avekor, k04_aveeng, k04_avemat, k04_avesum,
				k04_aveave);
		// 누적페이지 평균 출력
	}
}

public class K04_BasicTraning2 {

	public static void k04_CreateTable(Connection k04_conn) throws SQLException, ClassNotFoundException {
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("create table class_record(" + "id int not null primary key," + "name varchar(50),"
				+ "kor int," + "eng int," + "mat int);");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음

	}

	public static void k04_DeleteTable(Connection k04_conn) throws SQLException, ClassNotFoundException { // 메인 메서드
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("delete from class_record;");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음
	}

	public static void k04_InsertTable(Connection k04_conn) throws ClassNotFoundException, SQLException {
		K04_Record k04_rec; // 클래스 변수 선언
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다

		String k04_QueryTxt = ""; // querytxt 변수 초기화
		for (int k04_i = 0; k04_i < K04_Record.k04_iPerson; k04_i++) {
			k04_rec = K04_Record.k04_ArrayOneRec.get(k04_i); // 클래스 변수에 어레이 값 저장
			k04_QueryTxt = String.format( // querytxt는 format형 string이다
					"insert into class_record(" + "id, name, kor, eng, mat)" + " values ("
							+ "'%d', '%s', '%d', '%d', '%d');",
					k04_rec.k04_studentId(), k04_rec.k04_name(), k04_rec.k04_kor(), k04_rec.k04_eng(),
					k04_rec.k04_mat());
			k04_stmt.execute(k04_QueryTxt); // 쿼리를 실행한다
		}
		k04_stmt.close(); // Statement 닫음
	}

	public static void k04_SelectTable(Connection k04_conn, int k04_start, int k04_end) throws SQLException {
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		ResultSet k04_rset = k04_stmt.executeQuery(
				"select *, (kor + eng + mat) as sum, ((kor + eng + mat) / 3) as avg from class_record limit "
						+ k04_start + ", " + k04_end + ";");
		// 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		while (k04_rset.next()) { // ResultSet 객체를 한 줄씩 읽어라
			if (k04_rset.getInt(1) >= 1000) {
				System.out.printf("%03d    %-7s%4d%7d%7d   %4d  %6.0f\n", k04_rset.getInt(1), k04_rset.getString(2),
						k04_rset.getInt(3), k04_rset.getInt(4), k04_rset.getInt(5), k04_rset.getInt(6),
						k04_rset.getFloat(7));
				k04_rset.close(); // ResultSet 닫음
				k04_stmt.close(); // Statement 닫음
				return;
			}
			System.out.printf("%03d     %-7s%4d%7d%7d   %4d  %6.0f\n", k04_rset.getInt(1), k04_rset.getString(2),
					k04_rset.getInt(3), k04_rset.getInt(4), k04_rset.getInt(5), k04_rset.getInt(6),
					k04_rset.getFloat(7));
			// 뽑아오는 값이 7개이기 때문에 리절트셋에서 겟하는 값을 1에서 7까지 줌.
		}
		k04_rset.close(); // ResultSet 닫음
		k04_stmt.close(); // Statement 닫음
	}

	public static Connection k04_Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		return k04_conn;
	}

	public static void main(String[] args) { // 메인 메서드
		try {
			k04_Connection(); // 커넥션 실행
			int k04_OnePage = 30; // 한 페이지 수

//			K04_Record.k04_dataSet();
//			k04_CreateTable(k04_Connection());
//			k04_DeleteTable(k04_Connection());
//			k04_InsertTable(k04_Connection());

			if (K04_Record.k04_iPerson % k04_OnePage == 0) { // 나눠서 딱떨어지면
				for (int k04_i = 0; k04_i < (K04_Record.k04_iPerson / k04_OnePage); k04_i++) {
					// 사람수에서 페이지 나눈 수만큼 for문 실행
					int k04_0 = 0; // 0이라는 값을 나타내는 변수
					int k04_start = (k04_OnePage * k04_i); // LIMIT의 index 변수
					K04_Record.k04_HeaderPrint(k04_i); // 헤더 출력
					k04_SelectTable(k04_Connection(), k04_start, k04_OnePage); // 내용 출력
					K04_Record.k04_TailPrintNow(k04_Connection(), k04_start, k04_OnePage); // 현재페이지
					K04_Record.k04_TailPrint(k04_Connection(), k04_0, k04_start + k04_OnePage); // 누적페이지
				}
			} else { // 나눠서 딱 떨어지지 않으면
				for (int k04_i = 0; k04_i < (K04_Record.k04_iPerson / k04_OnePage + 1); k04_i++) {
					// 사람수에서 페이지 나눈 수에서 1더한만큼 for문 실행
					int k04_0 = 0; // 0이라는 값을 나타내는 변수
					int k04_start = (k04_OnePage * k04_i); // LIMIT의 index 변수
					K04_Record.k04_HeaderPrint(k04_i); // 헤더 출력
					k04_SelectTable(k04_Connection(), k04_start, k04_OnePage);
					K04_Record.k04_TailPrintNow(k04_Connection(), k04_start, k04_OnePage);
					K04_Record.k04_TailPrint(k04_Connection(), k04_0, k04_start + k04_OnePage);
				}
			}
		} catch (ClassNotFoundException |

				SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				k04_Connection().close(); // Connection 닫음
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
