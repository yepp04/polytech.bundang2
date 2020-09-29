package bizProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_DBTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		ResultSet k04_rset = k04_stmt.executeQuery("show tables;");
		// 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		while (k04_rset.next()) { // ResultSet 객체를 한 줄씩 읽어라
			System.out.println("값 : " + k04_rset.getString(1)); // 한 줄씩 이렇게 출력
		}
		k04_rset.close(); // ResultSet 닫음
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}