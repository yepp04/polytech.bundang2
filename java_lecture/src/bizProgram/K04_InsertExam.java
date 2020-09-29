package bizProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_InsertExam {
	public static void main(String[] args) throws ClassNotFoundException, SQLException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("insert into examtable2(name, studentid, kor, eng, mat) values ('효민', 209901, 95, 100, 95);");
		k04_stmt.execute("insert into examtable2(name, studentid, kor, eng, mat) values ('보람', 209902, 95, 95, 95);");
		k04_stmt.execute(
				"insert into examtable2(name, studentid, kor, eng, mat) values ('은정', 209903, 100, 100, 100);");
		k04_stmt.execute("insert into examtable2(name, studentid, kor, eng, mat) values ('지연', 209904, 100, 95, 90);");
		k04_stmt.execute("insert into examtable2(name, studentid, kor, eng, mat) values ('소연', 209905, 80, 100, 70);");
		k04_stmt.execute("insert into examtable2(name, studentid, kor, eng, mat) values ('큐리', 209906, 100, 100, 70);");
		k04_stmt.execute("insert into examtable2(name, studentid, kor, eng, mat) values ('화영', 209907, 70, 70, 70);");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}
