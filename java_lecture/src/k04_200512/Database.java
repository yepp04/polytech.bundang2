package k04_200512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
	public static final String HERO_TABLE_NAME = "Hero";
	public static final String HERO_COLUMN_NAME = "name";
	public static final String HERO_COLUMN_HP = "hp";

	public static void main(String[] args) throws SQLException {
		Connection con = null;

		String server = "localhost"; // MySQL 서버 주소 127.0.0.1
		String database = "test"; // MySQL DATABASE 이름
		String user_name = "root"; // MySQL 서버 아이디
		String password = ""; // MySQL 서버 비밀번호

		// 2.연결
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database
					+ "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", user_name, password);
			System.out.println("정상적으로 연결되었습니다.");
		} catch (SQLException e) {
			System.err.println("con 오류:" + e.getMessage());
			e.printStackTrace();
		}

		// 삽입
		Hero batMan = new Hero("배트맨", 200);
		if (insert(con, batMan) > 0) {
			System.out.println("정상 처리");
		} else {
			System.out.println("에러");
		}

		// 검색
		List<Hero> heroList = query(con, 10);
		for (Hero hero : heroList) {
			System.out.println(hero);
		}

		// 삭제
		delete(con, batMan);

		// 업데이트
		Hero firstHero = heroList.get(0);
		firstHero.setHp(1000);
		int result = update(con, firstHero);
		if (update(con, firstHero) > 0) {
			System.out.println("업데이트 됨");
		} else {
			System.out.println("아무것도 안 됨");
		}

		// 트랜잭션

		try {
			con.setAutoCommit(false);
			insert(con, batMan);
			batMan.setHp(10000);
			update(con, batMan);
		} catch (SQLException e) {
			con.rollback();

		}

		// 3.해제
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
		}

	}

	public static int delete(Connection con, Hero hero) throws SQLException {
		PreparedStatement pstmt2 = con.prepareStatement("DELETE FROM Hero WHERE name = ?");
		pstmt2.setString(1, hero.getName()); // 얘는 1부터 시작함
		int result = pstmt2.executeUpdate();
		pstmt2.close();
		return result;
	}

	public static int update(Connection con, Hero hero) throws SQLException {
		PreparedStatement pstmt2 = con.prepareStatement("UPDATE Hero set hp = ? where name = ?");
		pstmt2.setInt(1, hero.getHp()); // 얘는 1부터 시작함
		pstmt2.setString(2, hero.getName()); // 얘는 1부터 시작함
		int result = pstmt2.executeUpdate();
		System.out.println(result + "건 삽입됨");
		pstmt2.close();
		return result;
	}

	public static int insert(Connection con, Hero hero) throws SQLException {
		PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO " + HERO_TABLE_NAME + "(name, hp) VALUES (?, ?)");
		pstmt2.setString(1, hero.getName()); // 얘는 1부터 시작함
		pstmt2.setInt(2, hero.getHp()); // 얘는 1부터 시작함
		int result = pstmt2.executeUpdate();
		System.out.println(result + "건 삽입됨");
		pstmt2.close();
		return result;
	}

	public static List<Hero> query(Connection con, int minHp) throws SQLException {
		PreparedStatement pstmt = con
				.prepareStatement("SELECT * FROM " + HERO_TABLE_NAME + " WHERE " + HERO_COLUMN_HP + " > ?");

		pstmt.setInt(1, minHp); // 얘는 1부터 시작함 물음표 첫번째의 값이 10이다
		ResultSet result = pstmt.executeQuery();

		List<Hero> heroList = new ArrayList<Hero>();
		while (result.next()) { // 데이터 시작 전을 가리키고 있다가 다음을 본다 있으면 true 없으면 false
			String name = result.getString(HERO_COLUMN_NAME);
			int hp = result.getInt(HERO_COLUMN_HP);
			System.out.println(name + " : " + hp);

			Hero hero = new Hero(name, hp);
			heroList.add(hero);
		}
		// 운영체제의 자원을 사용하는 것들(File, Network, DB 등)에는 close가 필요하다
		result.close();
		pstmt.close();
		return heroList;
	}
}
