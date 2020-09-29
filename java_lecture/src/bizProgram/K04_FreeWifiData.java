package bizProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K04_FreeWifiData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException { // 메인 메서드
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		// 초기화된 드라이버를 드라이버매니저를 통해 겟커넥션 한다. mysql url주소/db주소, 아이디, 비번
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다

		File k04_f = new File("c:\\Users\\kopo\\Desktop\\전국무료와이파이표준데이터.txt");
		// 바탕화면에 있는 파일의 인스턴스를 생성한다
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 파일을 읽는 새로운 파일리더를 새로운 버퍼리더로 생성한다.

		String k04_readtxt; // 변수 선언
		if ((k04_readtxt = k04_br.readLine()) == null) { // readtxt가 null이면 (첫째줄 읽음)
			System.out.printf("빈 파일입니다\n"); // 빈 파일입니다 출력
			return; // 프로그램 종료
		}
		String[] k04_field_name = k04_readtxt.split("\t"); // ???

		int k04_LineCnt = 0; // 인트변수 초기화, 나중에 번호매기는 용으로 쓰임
		while ((k04_readtxt = k04_br.readLine()) != null) { // readtxt가 null이 아니면
			String[] k04_field = k04_readtxt.split("\t"); // readtxt를 탭을 기준으로 잘라서 field 배열에 넣어라
			String k04_QueryTxt; // querytxt 변수 선언
			k04_QueryTxt = String.format( // querytxt는 format형 string이다
					"insert into freewifi(" + "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
							+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
							+ "manage_office, manage_office_phone, latitude, longitude, write_date)" + " values ("
							+ "'%s', '%s', '%s', '%s', '%s'," + "'%s', '%s', '%s', '%s' ,'%s',"
							+ "'%s', '%s', %s, %s, '%s');",
					// ''가 없는 %s 는 double형이라서 그렇다.
					k04_field[0], k04_field[1], k04_field[2], k04_field[3], k04_field[4], k04_field[5], k04_field[6],
					k04_field[7], k04_field[8], k04_field[9], k04_field[10], k04_field[11], k04_field[12],
					k04_field[13], k04_field[14]);
			k04_stmt.execute(k04_QueryTxt); // 쿼리를 실행한다
			System.out.printf("%d번째 항목 Insert OK [%s]\n", k04_LineCnt, k04_QueryTxt); // 다음의 내용을 출력한다

			k04_LineCnt++; // lineCnt에 1을 더한다
		}
		k04_br.close(); // BufferedReader 닫음
		k04_stmt.close(); // Statement 닫음
		k04_conn.close(); // Connection 닫음
	}
}
