package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	public static void connectionClose(Connection con) {

		// 3.해제
		try {
			if (con != null) // 접속이 null이 아닐 때
				con.close(); // 접속을 종료한다
		} catch (SQLException e) {
		}
	}

	public static Connection connect() {
		Connection con = null;

		String server = "localhost"; // MySQL 서버 주소 127.0.0.1
		String database = "test"; // MySQL DATABASE 이름
		String user_name = "root"; // MySQL 서버 아이디
		String password = ""; // MySQL 서버 비밀번호

		// 2.연결
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://" + server + "/" + database
							+ "?allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					user_name, password);
		} catch (SQLException e) {
			System.err.println("con 오류:" + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}

}
