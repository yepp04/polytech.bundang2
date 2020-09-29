package k04_200520;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String database = "";
		String id = "root";
		String password = "hiemsnigra04!";
		String query = null;
		int columnSize = 0;

		Scanner scanner = new Scanner(System.in);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database
					+ "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", id, password);
			while (true) {
				System.out.println("######################################");
				System.out.println("############### TV 편성표 ##############");
				System.out.println("######################################");
				System.out.println("[1] KBS1");
				System.out.println("[2] KBS2");
				System.out.println("[3] MBC");
				System.out.println("[4] SBS");
				statement = connection.createStatement(); // MySQL 접속
				System.out.print("Input number : ");
				String num = scanner.nextLine(); // 채널 입력

				if (num.equals("1")) { // 1일 경우
					database = "kbs1";
					statement.executeQuery("use " + database);
				} else if (num.equals("2")) {
					database = "kbs2";
					statement.executeQuery("use " + database);
				} else if (num.equals("3")) {
					database = "mbc";
					statement.executeQuery("use " + database);
				} else if (num.equals("4")) {
					database = "sbs";
					statement.executeQuery("use " + database);
				} else {
					System.out.println("다시 번호를 입력하세요");
				}

				if (database.equals("kbs1")) { // kbs1 채널로 들어왔을 때
					System.out.println("[1] 5월 19일 KBS1 TV 편성표");
					System.out.println("[2] 5월 20일 KBS1 TV 편성표");
					System.out.println("[3] 5월 21일 KBS1 TV 편성표");
					System.out.print("Input number : ");
					String select = scanner.nextLine(); // 날짜를 고르기
					if (select.equals("1")) {
						query = "select * from date_0519";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query); // 쿼리 실행
						resultSet = statement.getResultSet(); // 결과값 얻기
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("2")) {
						query = "select * from date_0520";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("3")) {
						query = "select * from date_0521";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else {
						System.out.println("다시 번호를 입력하세요");
					}
				} else if (database.equals("kbs2")) {
					System.out.println("[1] 5월 19일 KBS2 TV 편성표");
					System.out.println("[2] 5월 20일 KBS2 TV 편성표");
					System.out.println("[3] 5월 21일 KBS2 TV 편성표");
					System.out.print("Input number : ");
					String select = scanner.nextLine();
					if (select.equals("1")) {
						query = "select * from date_0519";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("2")) {
						query = "select * from date_0520";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("3")) {
						query = "select * from date_0521";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else {
						System.out.println("다시 번호를 입력하세요");
					}
				} else if (database.equals("mbc")) {
					System.out.println("[1] 5월 19일 MBC TV 편성표");
					System.out.println("[2] 5월 20일 MBC TV 편성표");
					System.out.println("[3] 5월 21일 MBC TV 편성표");
					System.out.print("Input number : ");
					String select = scanner.nextLine();
					if (select.equals("1")) {
						query = "select * from date_0519";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("2")) {
						query = "select * from date_0520";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("3")) {
						query = "select * from date_0521";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else {
						System.out.println("다시 번호를 입력하세요");
					}
				} else if (database.equals("sbs")) {
					System.out.println("[1] 5월 19일 SBS TV 편성표");
					System.out.println("[2] 5월 20일 SBS TV 편성표");
					System.out.println("[3] 5월 21일 SBS TV 편성표");
					System.out.print("Input number : ");
					String select = scanner.nextLine();
					if (select.equals("1")) {
						query = "select * from date_0519";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("2")) {
						query = "select * from date_0520";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else if (select.equals("3")) {
						query = "select * from date_0521";
						System.out.println("연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
						statement.execute(query);
						resultSet = statement.getResultSet();
						ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
						columnSize = rsmd.getColumnCount();
					} else {
						System.out.println("다시 번호를 입력하세요");
					}
				}

				if (columnSize == 1) { // 실행한 쿼리의 칼럼 값이 1이면 실행
					while (resultSet.next()) {
						System.out.println(resultSet.getString(1));
					}
				} else if (columnSize == 2) { // 실행한 쿼리의 칼럼 값이 2이면 실행
					while (resultSet.next()) {
						System.out.printf("%s %s\n", resultSet.getString(1), resultSet.getString(2));
					}
				} else if (columnSize == 3) {
					while (resultSet.next()) {
						System.out.printf("%s %s  %s\n", resultSet.getString(1), resultSet.getString(2),
								resultSet.getString(3));
					}
				}

			}

		} catch (SQLException e) {
			System.err.println("con 오류:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
