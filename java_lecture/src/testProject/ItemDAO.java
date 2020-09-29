package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDAO {

	public static final String ITEM_TABLE_NAME = "itemlist"; // 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_NO = "no"; // 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_NAME = "name"; // 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_WEIGHT = "weight(g)";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_SCREEN = "screen(inch)";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_CAPACITY = "capacity(gigabyte)";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_ETC = "etc";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다
	public static final String ITEM_COLUMN_PRICE = "price(10000won)";// 데이터 베이스의 컬럼 값들을 모두 상수로 입력해준다

	static Scanner scanner = new Scanner(System.in);

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
		String database = "testproject"; // MySQL DATABASE 이름
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
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM " + ITEM_TABLE_NAME + " WHERE no = ?"); // DELETE
																											// 쿼리를 입력한다
		pstmt.setInt(1, item.getNo()); // 물음표에 지울 이름을 입력한다
		int result = pstmt.executeUpdate(); // 결과를 업데이트 한다

		pstmt.close(); // 쿼리를 종료한다
		connectionClose(con);

		return result; // result값을 리턴한다
	}

	public static int update(String query) throws SQLException {
		Connection con = connect();
		// UPDATE 쿼리를 입력한다

		PreparedStatement pstmt = con.prepareStatement(query);
		int result = pstmt.executeUpdate(); // 결과를 업데이트 한다

		pstmt.close(); // 쿼리를 종료한다
		connectionClose(con);
		return result; // result값을 리턴한다
	}

	public static int getInsert(Item item) throws SQLException {
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO " + ITEM_TABLE_NAME + "(" + ITEM_COLUMN_NAME + ", `"
				+ ITEM_COLUMN_WEIGHT + "`, `" + ITEM_COLUMN_SCREEN + "`, `" + ITEM_COLUMN_CAPACITY + "`, "
				+ ITEM_COLUMN_ETC + ", `" + ITEM_COLUMN_PRICE + "`) VALUES (?, ?, ?, ?, ?, ?)"); // INSERT 쿼리를 입력한다
		pstmt.setString(1, item.getName()); // 얘는 1부터 시작함
		pstmt.setInt(2, item.getWeight()); // 얘는 1부터 시작함
		pstmt.setInt(3, item.getScreen()); // 얘는 1부터 시작함
		pstmt.setInt(4, item.getCapacity()); // 얘는 1부터 시작함
		pstmt.setString(5, item.getEtc()); // 얘는 1부터 시작함
		pstmt.setInt(6, item.getPrice()); // 얘는 1부터 시작함
		int result = pstmt.executeUpdate(); // 결과를 업데이트 한다

		pstmt.close(); // 쿼리를 종료한다
		connectionClose(con);
		return result; // result값을 리턴한다
	}

	public static List<Item> getSelect() throws SQLException {
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + ITEM_TABLE_NAME);
		ResultSet result = pstmt.executeQuery();
		// 처리
		List<Item> itemList = new ArrayList<Item>();
		while (result.next()) {
			int no = result.getInt(ITEM_COLUMN_NO);
			String name = result.getString(ITEM_COLUMN_NAME);
			int weight = result.getInt(ITEM_COLUMN_WEIGHT);
			int screen = result.getInt(ITEM_COLUMN_SCREEN);
			int capacity = result.getInt(ITEM_COLUMN_CAPACITY);
			String etc = result.getString(ITEM_COLUMN_ETC);
			int price = result.getInt(ITEM_COLUMN_PRICE);

			Item item = new Item(no, name, weight, screen, capacity, etc, price);
			itemList.add(item);
		}

		result.close();
		pstmt.close();
		connectionClose(con);
		return itemList;
	}

	public static List<Item> getSelect(int num, int num2) throws SQLException {
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + ITEM_TABLE_NAME + " WHERE " + ITEM_COLUMN_NO
				+ " = " + num + " OR " + ITEM_COLUMN_NO + " = " + num2);
		ResultSet result = pstmt.executeQuery();
		// 처리
		List<Item> itemList = new ArrayList<Item>();
		while (result.next()) {
			int no = result.getInt(ITEM_COLUMN_NO);
			String name = result.getString(ITEM_COLUMN_NAME);
			int weight = result.getInt(ITEM_COLUMN_WEIGHT);
			int screen = result.getInt(ITEM_COLUMN_SCREEN);
			int capacity = result.getInt(ITEM_COLUMN_CAPACITY);
			String etc = result.getString(ITEM_COLUMN_ETC);
			int price = result.getInt(ITEM_COLUMN_PRICE);

			Item item = new Item(no, name, weight, screen, capacity, etc, price);
			itemList.add(item);
		}

		result.close();
		pstmt.close();
		connectionClose(con);
		return itemList;
	}

	public static List<Integer> getSelectNo(int num) throws SQLException {
		Connection con = connect();
		PreparedStatement pstmt = con
				.prepareStatement("SELECT " + ITEM_COLUMN_NO + " FROM " + ITEM_TABLE_NAME + " WHERE no = ?");
		Item item = new Item(num);
		pstmt.setInt(1, item.getNo()); // 얘는 1부터 시작함
		ResultSet result = pstmt.executeQuery();
		// 처리
		List<Integer> itemList = new ArrayList<Integer>();
		while (result.next()) {
			int no = result.getInt(ITEM_COLUMN_NO);
			itemList.add(no);
		}
		result.close();
		pstmt.close();
		connectionClose(con);
		return itemList;
	}

	public static int getSelectWeight(int num) throws SQLException {
		Connection con = connect();
		int weight = 0;
		PreparedStatement pstmt = con
				.prepareStatement("SELECT `" + ITEM_COLUMN_WEIGHT + "` FROM " + ITEM_TABLE_NAME + " WHERE no = ?");
		Item item = new Item(num);
		pstmt.setInt(1, item.getNo()); // 얘는 1부터 시작함
		ResultSet result = pstmt.executeQuery();
		// 처리
		while (result.next()) {
			weight = result.getInt(ITEM_COLUMN_WEIGHT);
		}
		result.close();
		pstmt.close();
		connectionClose(con);
		return weight;
	}

	public static int getSelectScreen(int num) throws SQLException {
		Connection con = connect();
		int screen = 0;
		PreparedStatement pstmt = con
				.prepareStatement("SELECT `" + ITEM_COLUMN_SCREEN + "` FROM " + ITEM_TABLE_NAME + " WHERE no = ?");
		Item item = new Item(num);
		pstmt.setInt(1, item.getNo()); // 얘는 1부터 시작함
		ResultSet result = pstmt.executeQuery();
		// 처리
		while (result.next()) {
			screen = result.getInt(ITEM_COLUMN_SCREEN);
		}
		result.close();
		pstmt.close();
		connectionClose(con);
		return screen;
	}

	public static int getSelectCapacity(int num) throws SQLException {
		Connection con = connect();
		int capacity = 0;
		PreparedStatement pstmt = con
				.prepareStatement("SELECT `" + ITEM_COLUMN_CAPACITY + "` FROM " + ITEM_TABLE_NAME + " WHERE no = ?");
		Item item = new Item(num);
		pstmt.setInt(1, item.getNo()); // 얘는 1부터 시작함
		ResultSet result = pstmt.executeQuery();
		// 처리
		while (result.next()) {
			capacity = result.getInt(ITEM_COLUMN_CAPACITY);
		}
		result.close();
		pstmt.close();
		connectionClose(con);
		return capacity;
	}

	public static int getSelectPrice(int num) throws SQLException {
		Connection con = connect();
		int price = 0;
		PreparedStatement pstmt = con
				.prepareStatement("SELECT `" + ITEM_COLUMN_PRICE + "` FROM " + ITEM_TABLE_NAME + " WHERE no = ?");
		Item item = new Item(num);
		pstmt.setInt(1, item.getNo()); // 얘는 1부터 시작함
		ResultSet result = pstmt.executeQuery();
		// 처리
		while (result.next()) {
			price = result.getInt(ITEM_COLUMN_PRICE);
		}
		result.close();
		pstmt.close();
		connectionClose(con);
		return price;
	}

	public static String getSelectName(int num) throws SQLException {
		Connection con = connect();
		String name = "";
		PreparedStatement pstmt = con
				.prepareStatement("SELECT " + ITEM_COLUMN_NAME + " FROM " + ITEM_TABLE_NAME + " WHERE no = ?");
		Item item = new Item(num);
		pstmt.setInt(1, item.getNo()); // 얘는 1부터 시작함
		ResultSet result = pstmt.executeQuery();
		// 처리
		while (result.next()) {
			name = result.getString(ITEM_COLUMN_NAME);
		}

		result.close();
		pstmt.close();
		connectionClose(con);
		return name;
	}

}
