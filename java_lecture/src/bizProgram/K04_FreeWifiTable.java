package bizProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_FreeWifiTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("create table freewifi(" + "inst_place varchar(255)," + "inst_place_detail varchar(255),"
				+ "inst_city varchar(255)," + "inst_country varchar(255)," + "inst_place_flag varchar(255),"
				+ "service_provider varchar(255)," + "wifi_ssid varchar(255)," + "inst_date varchar(255),"
				+ "place_addr_road varchar(255)," + "place_addr_land varchar(255)," + "manage_office varchar(255),"
				+ "manage_office_phone varchar(255)," + "latitude double," + "longitude double," + "write_date date);");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}
