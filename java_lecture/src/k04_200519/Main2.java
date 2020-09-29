package k04_200519;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String database = "";
		String id = "root";
		String password = "hiemsnigra04!";
		String query = null;

		Scanner scanner = new Scanner(System.in);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database
					+ "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", id, password);
			while (true) {
				statement = connection.createStatement();
				System.out.println("######################################");
				System.out.println("############ MY DATABASE #############");
				System.out.println("######################################");
				System.out.println("[1] LIST OF DATABASE");
				System.out.println("[2] USE DATABASE");
				System.out.println("[3] LIST OF TABLES");
				System.out.println("[4] SELECT * FROM A TABLE");

				System.out.print("Input number : ");
				String num = scanner.nextLine();

				if (database.equals("") && num.equals("3")) {
					System.out.println("DB에 먼저 접속하세요");
				} else if (num.equals("1")) {
					query = "show databases";
					statement.execute(query);
					resultSet = statement.getResultSet();
				} else if (num.equals("2")) {
					System.out.println("DB의 이름을 입력하세요");
					query = scanner.nextLine();
					database = query;
					connection.setCatalog(database);
					System.out.println(database + " DB 접속");
				} else if (num.equals("3") && !database.equals("")) {
					query = "show tables";
					statement.execute(query);
					resultSet = statement.getResultSet();
				} else if (num.equals("4") && database.equals("")) {
					System.out.println("DB에 먼저 접속하세요");
				} else if (num.equals("4")) {
					System.out.println("TABLE을 입력하세요");
					query = "select * from " + scanner.nextLine();
					statement.execute(query);
					resultSet = statement.getResultSet();
				}

				if ((!database.equals("")) && resultSet != null) {
					while (resultSet.next()) {
						String str = resultSet.getString(1);
						System.out.println(str);
					}
				} else if (database.equals("") && num.equals("1")) {
					while (resultSet.next()) {
						String str = resultSet.getString(1);
						System.out.println(str);
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("con 오류:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
