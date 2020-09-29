package bizProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_FreeWifiPK {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("create table freewifi(" + "inst_place varchar(99)," + "inst_place_detail varchar(255),"
				+ "inst_city varchar(99)," + "inst_country varchar(99)," + "inst_place_flag varchar(99),"
				+ "service_provider varchar(80)," + "wifi_ssid varchar(80)," + "inst_date varchar(20),"
				+ "place_addr_road varchar(100)," + "place_addr_land varchar(100)," + "manage_office varchar(255),"
				+ "manage_office_phone varchar(20)," + "latitude double," + "longitude double," + "write_date date, "
				+ "constraint pk primary key(inst_place, inst_place_detail, service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land, manage_office_phone, latitude, longitude, write_date));");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}
