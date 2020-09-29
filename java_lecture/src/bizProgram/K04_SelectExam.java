package bizProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_SelectExam {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		ResultSet k04_rset = k04_stmt.executeQuery("select * from examtable2;");
		// 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		System.out.printf("  이름     학번      국어    영어    수학\n"); // 테이블의 칼럼명들을 직접 써서 출력
		while (k04_rset.next()) { // ResultSet 객체를 한 줄씩 읽어라
			System.out.printf("%4s  %6d  %3d  %3d  %3d \n", k04_rset.getString(1), k04_rset.getInt(2),
					k04_rset.getInt(3), k04_rset.getInt(4), k04_rset.getInt(5));
			// 칼럼이 5개이기 때문에 리절트셋에서 겟하는 값을 1에서 5까지 줌.
		}
		k04_rset.close(); // ResultSet 닫음
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}
