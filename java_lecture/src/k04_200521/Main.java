package k04_200521;

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
		String tablename = null;
		int columnSize = 0;

		Scanner scanner = new Scanner(System.in);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database
					+ "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", id, password);
			while (true) {
				System.out.println("[1] TV편성표 보기");
				System.out.println("[2] 관리자 입력");
				System.out.print("Input number : ");
				String go = scanner.nextLine();
				if (go.equals("2")) {
					System.out.println("#######ID를 입력하세요######");
					String modifylogin = scanner.nextLine();
					if (modifylogin.equals("강진성")) {
						System.out.println("#######비밀번호를 입력하세요######");
						System.out.print("Input number : ");
						String modifypassword = scanner.nextLine();
						if (modifypassword.equals("1234")) {
							statement = connection.createStatement(); // MySQL 접속
							while (true) {
								System.out.println("#######수정할 채널을 입력하세요######");
								System.out.println("[1] KBS1");
								System.out.println("[2] KBS2");
								System.out.println("[3] MBC");
								System.out.println("[4] SBS");
								System.out.println("[5] 처음 화면으로 가기");
								System.out.print("Input number : ");
								String modify = scanner.nextLine();
								// KBS1 수정
								if (modify.equals("1")) {
									database = "kbs1";
									statement.executeQuery("use " + database);
									System.out.println("#######수정할 날짜를 입력하세요######");
									System.out.println("[1] 5월 19일 KBS1 TV 편성표");
									System.out.println("[2] 5월 20일 KBS1 TV 편성표");
									System.out.println("[3] 5월 21일 KBS1 TV 편성표");
									System.out.println("[4] 채널 선택으로 되돌아가기");
									System.out.print("Input number : ");
									String modify2 = scanner.nextLine();
									if (modify2.equals("1")) {
										tablename = "date_0519";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";

													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("2")) {
										tablename = "date_0520";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}
									} else if (modify2.equals("3")) {
										tablename = "date_0521";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("4")) {
										break;
									}
									// kbs2 수정
								} else if (modify.equals("2")) {
									database = "kbs2";
									statement.executeQuery("use " + database);
									System.out.println("#######수정할 날짜를 입력하세요######");
									System.out.println("[1] 5월 19일" + database + "TV 편성표");
									System.out.println("[2] 5월 20일" + database + "TV 편성표");
									System.out.println("[3] 5월 21일" + database + "TV 편성표");
									System.out.println("[4] 채널 선택으로 되돌아가기");
									System.out.print("Input number : ");
									String modify2 = scanner.nextLine();
									if (modify2.equals("1")) {
										tablename = "date_0519";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("2")) {
										tablename = "date_0520";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("삭제할 제목의 일부분을 입력 하세요(주의: 공통된 것이 있는 제목은 모두 지워집니다)");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}
									} else if (modify2.equals("3")) {
										tablename = "date_0521";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("4")) {
										break;
									}
									// MBC 수정
								} else if (modify.equals("3")) {
									database = "mbc";
									statement.executeQuery("use " + database);
									System.out.println("#######수정할 날짜를 입력하세요######");
									System.out.println("[1] 5월 19일" + database + "TV 편성표");
									System.out.println("[2] 5월 20일" + database + "TV 편성표");
									System.out.println("[3] 5월 21일" + database + "TV 편성표");
									System.out.println("[4] 채널 선택으로 되돌아가기");
									System.out.print("Input number : ");
									String modify2 = scanner.nextLine();
									if (modify2.equals("1")) {
										tablename = "date_0519";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("2")) {
										tablename = "date_0520";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}
									} else if (modify2.equals("3")) {
										tablename = "date_0521";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("4")) {
										break;
									}
									// SBS 수정
								} else if (modify.equals("4")) {
									database = "sbs";
									statement.executeQuery("use " + database);
									System.out.println("#######수정할 날짜를 입력하세요######");
									System.out.println("[1] 5월 19일" + database + "TV 편성표");
									System.out.println("[2] 5월 20일" + database + "TV 편성표");
									System.out.println("[3] 5월 21일" + database + "TV 편성표");
									System.out.println("[4] 채널 선택으로 되돌아가기");
									System.out.print("Input number : ");
									String modify2 = scanner.nextLine();
									if (modify2.equals("1")) {
										tablename = "date_0519";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("2")) {
										tablename = "date_0520";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}
									} else if (modify2.equals("3")) {
										tablename = "date_0521";
										query = "select * from " + tablename + " order by time";
										statement.execute(query); // 쿼리 실행
										resultSet = statement.getResultSet(); // 결과값 얻기
										ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
										columnSize = rsmd.getColumnCount();
										if (columnSize == 3) {
											while (resultSet.next()) {
												System.out.printf("%s %s  %s\n", resultSet.getString(1),
														resultSet.getString(2), resultSet.getString(3));
											}
										}
										while (true) {
											System.out.println("[1] 추가");
											System.out.println("[2] 삭제");
											System.out.println("[3] 되돌아가기");
											System.out.print("Input number : ");
											String modify3 = scanner.nextLine();
											if (modify3.equals("1")) {
												System.out.println("방송시간대를 입력하세요 ex) 08시");
												String time = scanner.nextLine();
												System.out.println("세부 시간 및 방송명을 입력하세요 ex) 55 무한도전");
												String airname = scanner.nextLine();
												System.out.println(
														"연령등급 및 방송 세부 정보를 입력하세요 ex) 19,HD,재,수,자 또는 없으면 없음 이라고 무조건 써야합니다");
												System.out.println(
														"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
												String airinfo = scanner.next();
												if (airinfo.contains("15") || airinfo.contains("19")
														|| airinfo.contains("HD") || airinfo.contains("재")
														|| airinfo.contains("생") || airinfo.contains("수")
														|| airinfo.contains("해") || airinfo.contains("자")
														|| airinfo.contains("없음")) {
													query = "insert into " + tablename + " values ('" + time + "', '"
															+ airname + "', '" + airinfo + "');";
													statement.execute(query); // 쿼리 실행
													System.out.println("추가되었습니다");
													scanner.nextLine();
												} else {
													System.out.println("세부정보가 틀립니다");
												}
											} else if (modify3.equals("2")) {
												System.out.println("");
												System.out.println("제목 앞 부분을 입력 하세요");
												query = "delete from " + tablename + " where airname like concat('%"
														+ scanner.nextLine() + "', '%');";
												statement.execute(query); // 쿼리 실행
												System.out.println("삭제되었습니다");

											} else if (modify3.equals("3")) {
												break;
											} else {
												System.out.println("다시 입력하세요");
											}
										}

									} else if (modify2.equals("4")) {
										break;
									}
								} else if (modify.equals("5")) {
									break;
								} else {
									System.out.println("다시 입력하세요");
								}
							}
						} else {
							System.out.println("비밀번호가 맞지 않습니다");
						}
					} else {
						System.out.println("ID가 존재하지 않습니다");
					}

				} else if (go.equals("1")) {
					while (true) {
						System.out.println("######################################");
						System.out.println("############### TV 편성표 ##############");
						System.out.println("######################################");
						System.out.println("[1] KBS1");
						System.out.println("[2] KBS2");
						System.out.println("[3] MBC");
						System.out.println("[4] SBS");
						System.out.println("[5] 처음 화면으로 가기");
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
						} else if (num.equals("5")) {
							break;
						} else {
							System.out.println("다시 번호를 입력하세요");
						}

						while (true) {
							if (database.equals("kbs1")) { // kbs1 채널로 들어왔을 때
								System.out.println("[1] 5월 19일 KBS1 TV 편성표");
								System.out.println("[2] 5월 20일 KBS1 TV 편성표");
								System.out.println("[3] 5월 21일 KBS1 TV 편성표");
								System.out.println("[4] 채널 선택으로 되돌아가기");
								System.out.print("Input number : ");
								String select = scanner.nextLine(); // 날짜를 고르기
								if (select.equals("1")) {
									query = "select * from date_0519 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query); // 쿼리 실행
									resultSet = statement.getResultSet(); // 결과값 얻기
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("2")) {
									query = "select * from date_0520 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("3")) {
									query = "select * from date_0521 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("4")) {
									break;
								} else {
									System.out.println("다시 번호를 입력하세요");
								}

							} else if (database.equals("kbs2")) {
								System.out.println("[1] 5월 19일 KBS2 TV 편성표");
								System.out.println("[2] 5월 20일 KBS2 TV 편성표");
								System.out.println("[3] 5월 21일 KBS2 TV 편성표");
								System.out.println("[4] 채널 선택으로 되돌아가기");
								System.out.print("Input number : ");
								String select = scanner.nextLine();
								if (select.equals("1")) {
									query = "select * from date_0519 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("2")) {
									query = "select * from date_0520 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("3")) {
									query = "select * from date_0521 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("4")) {
									break;
								} else {
									System.out.println("다시 번호를 입력하세요");
								}
							} else if (database.equals("mbc")) {
								System.out.println("[1] 5월 19일 MBC TV 편성표");
								System.out.println("[2] 5월 20일 MBC TV 편성표");
								System.out.println("[3] 5월 21일 MBC TV 편성표");
								System.out.println("[4] 채널 선택으로 되돌아가기");
								System.out.print("Input number : ");
								String select = scanner.nextLine();
								if (select.equals("1")) {
									query = "select * from date_0519 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("2")) {
									query = "select * from date_0520 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("3")) {
									query = "select * from date_0521 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("4")) {
									break;
								} else {
									System.out.println("다시 번호를 입력하세요");
								}
							} else if (database.equals("sbs")) {
								System.out.println("[1] 5월 19일 SBS TV 편성표");
								System.out.println("[2] 5월 20일 SBS TV 편성표");
								System.out.println("[3] 5월 21일 SBS TV 편성표");
								System.out.println("[4] 채널 선택으로 되돌아가기");
								System.out.print("Input number : ");
								String select = scanner.nextLine();
								if (select.equals("1")) {
									query = "select * from date_0519 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("2")) {
									query = "select * from date_0520 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("3")) {
									query = "select * from date_0521 order by time";
									System.out.println(
											"연령등급: 15, 19, HD: HD방송, 재: 재방송, 생: 생방송, 수: 수어방송, 해: 화면해설, 자: 자막방송");
									statement.execute(query);
									resultSet = statement.getResultSet();
									ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
									columnSize = rsmd.getColumnCount();
								} else if (select.equals("4")) {
									break;
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

					}
				} else {
					System.out.println("다시 입력하세요");
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
