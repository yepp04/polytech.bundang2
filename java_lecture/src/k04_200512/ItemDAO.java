package k04_200512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
	public static final String ITEM_TABLE_NAME = "hero"; // 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_NAME = "name"; // 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_PRICE = "price";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_WEIGHT = "weight";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다

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

	public static int delete(Item item) throws SQLException {
		Connection con = connect();

		PreparedStatement pstmt = con.prepareStatement("DELETE FROM ITEM WHERE name = ?"); // DELETE 쿼리를 입력한다
		pstmt.setString(1, item.getName()); // 물음표에 지울 이름을 입력한다
		int result = pstmt.executeUpdate(); // 결과를 업데이트 한다

		pstmt.close(); // 쿼리를 종료한다

		connectionClose(con); // 접속을 종료한다
		return result; // result값을 리턴한다
	}

	public static int update(Item item) throws SQLException {
		Connection con = connect();

		// UPDATE 쿼리를 입력한다
		PreparedStatement pstmt = con.prepareStatement("UPDATE ITEM SET price = 500 WHERE name = '해독제'");
		int result = pstmt.executeUpdate(); // 결과를 업데이트 한다

		pstmt.close(); // 쿼리를 종료한다

		connectionClose(con); // 접속을 종료한다
		return result; // result값을 리턴한다
	}

	public static int insert(Item item) throws SQLException {
		Connection con = connect();

		PreparedStatement pstmt = con.prepareStatement("INSERT INTO  VALUES ('체력회복제', 200)"); // INSERT 쿼리를 입력한다
		int result = pstmt.executeUpdate(); // 결과를 업데이트 한다

		pstmt.close(); // 쿼리를 종료한다

		connectionClose(con); // 접속을 종료한다
		return result; // result값을 리턴한다
	}

	public static ArrayList<Item> findByMinimumPrice(int minPrice) throws SQLException {
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ITEM WHERE PRICE > ?"); // SELECT 쿼리를 입력한다
		pstmt.setInt(1, minPrice); // 물음표의 최소 가격을 입력한다
		ResultSet result = pstmt.executeQuery(); // 쿼리를 실행한다

		// 처리
		ArrayList<Item> itemList = new ArrayList<Item>(); // 검색 결과에 따른 itemList를 ArrayList에 추가한다
		while (result.next()) {
			String name = result.getString(ITEM_COLUMN_NAME);
			int price = result.getInt(ITEM_COLUMN_PRICE);
			int weight = result.getInt(ITEM_COLUMN_WEIGHT);

			Item item = new Item(name, price, weight); // 결과값을 넣을 item 생성자를 생성한다
			itemList.add(item); // 그 생성자를 ArrayList에 추가한다
		}

		result.close(); // 결과값을 종료한다
		pstmt.close(); // 쿼리를 종료한다

		connectionClose(con); // 접속을 종료한다
		return itemList; // itemList를 리턴한다
	}
}
