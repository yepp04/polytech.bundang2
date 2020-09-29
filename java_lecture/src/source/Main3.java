package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
	public static final String HERO_TABLE_NAME = "hero";
	public static final String HERO_COLUMN_NAME = "name";
	public static final String HERO_COLUMN_HP = "hp";

	public static void connectionClose(Connection con) {
		// 3.해제
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}
	}

	public static Connection connect() {
		Connection con = null;

		String server = "localhost"; // MySQL 서버 주소 127.0.0.1
		String database = "test_db"; // MySQL DATABASE 이름
		String user_name = "root"; // MySQL 서버 아이디
		String password = "password"; // MySQL 서버 비밀번호

		// 2.연결
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://" + server + "/" + database
							+ "?allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					user_name, password);
//			System.out.println("정상적으로 연결되었습니다.");
		} catch (SQLException e) {
			System.err.println("con 오류:" + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}

	public static void main(String args[]) throws Exception {
		// 삽입
		Hero spiderMan = new Hero("spider man", 200);
		if (Main3.insert(spiderMan) > 0) {
			System.out.println("정상 처리");
		} else {
			System.out.println("에러");
		}

		// 검색
		List<Hero> heroList = query(10);
		for (Hero hero : heroList) {
			System.out.println(hero);
		}

		// 삭제
		delete(spiderMan);

		// 업데이트
		Hero firstHero = heroList.get(0);
		firstHero.setHp(1000);
		int result = update(firstHero);
		if (result > 0) {
			System.out.println(result + "건 업데이트 됨");
		} else {
			System.out.println("아무것도 안 됨");
		}

		// 검색
		heroList = query(10);
		for (Hero hero : heroList) {
			System.out.println(hero);
		}

		// 트랜잭션 처리
		Connection con = connect();
		try {
			con.setAutoCommit(false);

			insert(spiderMan);
			spiderMan.setHp(2000);
			update(spiderMan);

			con.commit();
		} catch (Exception e) {
			con.rollback();
		}

		// 3.해제
		connectionClose(con);
	}

	public static int delete(Hero hero) throws SQLException {
		Connection con = Main3.connect();

		// DELETE FROM hero WHERE name = 'spider man';
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM hero WHERE name = ?");
		pstmt.setString(1, hero.getName());
		int result = pstmt.executeUpdate();

		// 처리
//		System.out.println(result + " 건 삽입됨");

		pstmt.close();

		connectionClose(con);
		return result;
	}

	public static int update(Hero hero) throws SQLException {
		Connection con = connect();

		// UPDATE hero SET hp = 50 WHERE name = 'super man'
		PreparedStatement pstmt = con.prepareStatement("UPDATE hero SET hp = ? WHERE name = ?");
		pstmt.setInt(1, hero.getHp());
		pstmt.setString(2, hero.getName());
		int result = pstmt.executeUpdate();

		// 처리
//		System.out.println(result + " 건 삽입됨");

		pstmt.close();

		Main3.connectionClose(con);
		return result;
	}

	public static int insert(Hero hero) throws SQLException {
		Connection con = connect();

		PreparedStatement pstmt = con.prepareStatement("INSERT INTO " + HERO_TABLE_NAME + " VALUES (?, ?)");
		pstmt.setString(1, hero.getName());
		pstmt.setInt(2, hero.getHp());
		int result = pstmt.executeUpdate();

		// 처리
//		System.out.println(result + " 건 삽입됨");

		pstmt.close();

		Main3.connectionClose(con);

		return result;
	}

	public static List<Hero> query(int minHp) throws SQLException {
		Connection con = connect();

		PreparedStatement pstmt = con
				.prepareStatement("SELECT * FROM " + HERO_TABLE_NAME + " WHERE " + HERO_COLUMN_HP + " >= ?");
		pstmt.setInt(1, minHp);
		ResultSet result = pstmt.executeQuery();

		// 처리
		List<Hero> heroList = new ArrayList<Hero>();
		while (result.next()) {
			String name = result.getString(HERO_COLUMN_NAME);
			int hp = result.getInt(HERO_COLUMN_HP);
//			System.out.println(name + ": " + hp);

			Hero hero = new Hero(name, hp);
			heroList.add(hero);
		}

		result.close();
		pstmt.close();

		Main3.connectionClose(con);

		return heroList;

	}

}
