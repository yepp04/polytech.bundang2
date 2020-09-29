package bizProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_FreeWifiSelect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다

		double k04_lat = 37.3860521; // 위도
		double k04_lng = 127.1214038; // 경도

		String k04_QueryTxt; // querytxt 변수 선언
//		k04_QueryTxt = String.format( // (현재 위도에서 지정된 위도값을 뺀 것의 제곱 + 현재 경도에서 지정된 경도값을 뺀 것의 제곱)의 루트 '값'이 '값'들의 최솟값과 같은
//										// 것을 찾아라
//				"select * from freewifi where " + "sqrt(power(latitude - %f, 2) + power(longitude - %f, 2)) = "
//						+ "(select min(sqrt(power(latitude - %f, 2) + power(longitude - %f, 2))) from freewifi);",
//				k04_lat, k04_lng, k04_lat, k04_lng);

//		k04_QueryTxt = "select * from freewifi;"; // 전체 검색
//		k04_QueryTxt = "select * from freewifi where service_provider = 'SKT'"; // SKT꺼만 검색
		k04_QueryTxt = "select * from freewifi where inst_country = '수원시'"; // 수원시꺼만 검색

		ResultSet k04_rset = k04_stmt.executeQuery(k04_QueryTxt); // 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		int k04_iCnt = 0; // 인트 변수를 초기화
		while (k04_rset.next()) {
			System.out.printf("*(%d)***************************************\n", k04_iCnt++); // while 값이 돌아갈 때마다 1씩 더해져서
																								// 출력됨
			System.out.printf("설치장소명             : %s\n", k04_rset.getString(1)); // 리절트셋의 첫번째 컬럼 값
			System.out.printf("설치장소상세           : %s\n", k04_rset.getString(2)); // 리절트셋의 두번째 컬럼 값
			System.out.printf("설치시도명             : %s\n", k04_rset.getString(3)); // 리절트셋의 세번째 컬럼 값
			System.out.printf("설치시군구명           : %s\n", k04_rset.getString(4)); // 리절트셋의 네번째 컬럼 값
			System.out.printf("설치시설구분           : %s\n", k04_rset.getString(5)); // 리절트셋의 다섯번째 컬럼 값
			System.out.printf("서비스제공사명        : %s\n", k04_rset.getString(6)); // 리절트셋의 여섯번째 컬럼 값
			System.out.printf("와이파이SSID     : %s\n", k04_rset.getString(7)); // 리절트셋의 일곱번째 컬럼 값
			System.out.printf("설치년월                : %s\n", k04_rset.getString(8)); // 리절트셋의 여덟번째 컬럼 값
			System.out.printf("소재지도로명주소      : %s\n", k04_rset.getString(9)); // 리절트셋의 아홉번째 컬럼 값
			System.out.printf("소재지지번주소        : %s\n", k04_rset.getString(10)); // 리절트셋의 열번째 컬럼 값
			System.out.printf("관리기관명             : %s\n", k04_rset.getString(11)); // 리절트셋의 열한번째 컬럼 값
			System.out.printf("관리기관전화번호      : %s\n", k04_rset.getString(12)); // 리절트셋의 열두번째 컬럼 값
			System.out.printf("위도                     : %s\n", k04_rset.getFloat(13)); // 리절트셋의 열세번째 컬럼 값
			System.out.printf("경도                     : %s\n", k04_rset.getFloat(14)); // 리절트셋의 열네번째 컬럼 값
			System.out.printf("데이터기준일자        : %s\n", k04_rset.getDate(15)); // 리절트셋의 열다섯번째 컬럼 값
			System.out.printf("********************************************\n");
		}
		k04_rset.close(); // ResultSet 닫음
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}
