package k04_200519;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

		Scanner scanner = new Scanner(System.in);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database
					+ "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", id, password);
			while (true) {
				statement = connection.createStatement();
				String query = scanner.nextLine();
				if (database.equals("") && query.equals("show tables")) {
					System.out.println("DB에 다시 접속하세요");
				} else if (query.matches("use.*")) {
					String splited[] = query.split(" ");
					database = splited[1];
					connection.setCatalog(database);
					System.out.println(database + " DB 접속");
				} else if (database.equals("") && query.equals("show databases")) {
					statement.execute(query);
					resultSet = statement.getResultSet();
				} else if (!database.equals("") && statement.execute(query)) {
					resultSet = statement.getResultSet();

				}
				if ((!database.equals("")) && resultSet != null) {
					while (resultSet.next()) {
						String str = resultSet.getString(1);
						System.out.println(str);
					}
				} else if (database.equals("") && query.equals("show databases")) {
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
