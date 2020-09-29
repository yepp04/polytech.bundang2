package javaTestProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {

		try {

			String strFile = "C:\\Users\\kopo\\Desktop\\SW\\자바\\testProject\\log.csv";

			BufferedReader br = new BufferedReader(new FileReader(strFile));
			BufferedWriter bwMale = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\kopo\\Desktop\\SW\\자바\\testProject\\male.csv"), "MS949"));
			BufferedWriter bwFemale = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\kopo\\Desktop\\SW\\자바\\testProject\\female.csv"), "MS949"));
			BufferedWriter bwLastLoginDate = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\kopo\\Desktop\\SW\\자바\\testProject\\last_login.csv"), "MS949"));
			BufferedWriter bwLastLoginTime = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\kopo\\Desktop\\SW\\자바\\testProject\\am.csv"), "MS949"));
			BufferedWriter bwPoint = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\kopo\\Desktop\\SW\\자바\\testProject\\best.csv"), "MS949"));

			// 현재 날짜 5월인 것
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(now);
			int month = calendar.get(Calendar.MONTH) + 1; // 1월이 0부터 시작
			int year = calendar.get(Calendar.YEAR); // 1월이 0부터 시작
			SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");

			// 인스턴스 생성 및 리스트 생성
			Member member = null;
			PointMember pointMember = null;
			ArrayList<Member> lines = new ArrayList<>(); // 3번 최근 접속용 리스트
			ArrayList<PointMember> points = new ArrayList<>(); // 5번 포인트용 리스트

			String strLine = "";
			StringTokenizer st = null;
			StringTokenizer date = null;

			// 파일을 읽고 스트링토크나이저로 분리 저장
			br.readLine();
			while ((strLine = br.readLine()) != null) {
				st = new StringTokenizer(strLine);

				while (st.hasMoreTokens()) {
					String id = st.nextToken(",");
					String firstName = st.nextToken(",");
					String lastName = st.nextToken(",");
					String email = st.nextToken(",");
					String gender = st.nextToken(",");
					if (gender.equals("Male")) {
						gender = "남";
					} else if (gender.equals("Female")) {
						gender = "여";
					}
					String signUpDate = st.nextToken(",");
					String lastLoginDate = st.nextToken(",");
					String lastLoginTime = st.nextToken(",");
					String point = st.nextToken(",");

					// 3번 최근 접속용 리스트 생성자
					member = new Member(id, firstName, lastName, email, gender, signUpDate, sdf.parse(lastLoginDate),
							lastLoginTime, point);

					// 5번 포인트용 리스트 생성자
					pointMember = new PointMember(id, firstName, lastName, email, gender, signUpDate, lastLoginDate,
							lastLoginTime, Double.parseDouble(point));

					// 각각 입력
					lines.add(member);
					points.add(pointMember);

					// 남자, 여자(male.csv, female.csv)
					if (member.getGender().equals("남")) {
						bwMale.write(id + "," + firstName + " " + lastName + "," + email + "," + gender + ","
								+ signUpDate + "," + lastLoginDate + "," + lastLoginTime + "," + point);
						bwMale.newLine();
					} else if (member.getGender().equals("여")) {
						bwFemale.write(id + "," + firstName + " " + lastName + "," + email + "," + gender + ","
								+ signUpDate + "," + lastLoginDate + "," + lastLoginTime + "," + point);
						bwFemale.newLine();
					}

					// 새벽시간대(AM12:00~ 6:00) 접속한 사람들(am.csv)
					if (member.getLastLoginTime()
							.matches("[1][2][:]\\d{2} [A][M]|[1-5][:]\\d{2} [A][M]|[6][:][0][0] [A][M]")) {
						bwLastLoginTime.write(id + "," + firstName + " " + lastName + "," + email + "," + gender + ","
								+ signUpDate + "," + lastLoginDate + "," + lastLoginTime + "," + point);
						bwLastLoginTime.newLine();
					}

				}
			}

			// 마지막 접속 날짜(last_login.csv)
			Collections.sort(lines);

			for (int i = 0; i < lines.size(); i++) {
				String lastLoginDate = sdf.format(lines.get(i).getLastLoginDate());
				StringTokenizer login = new StringTokenizer(lines.get(i).toString());
				String id = login.nextToken(",");
				String name = login.nextToken(",");
				String email = login.nextToken(",");
				String gender = login.nextToken(",");
				String signUpDate = login.nextToken(",");
				String lastLoginDate2 = login.nextToken(",");
				String lastLoginTime = login.nextToken(",");
				String point = login.nextToken(",");

				date = new StringTokenizer(lastLoginDate);
				String m = date.nextToken("/");
				String d = date.nextToken("/");
				String yyyy = date.nextToken("/");

				// 조건: 현재 년도가 같고 현재 5월이면 3~5월 내에 접속한 멤버, 만약 지금이 1월이나 2월이면 작년 년도가 같고 11월 12월인 예외도
				// 처리
				if (yyyy.equals(String.valueOf(year)) && m.equals(String.valueOf(month))
						|| yyyy.equals(String.valueOf(year)) && m.equals(String.valueOf(month - 1))
						|| yyyy.equals(String.valueOf(year)) && m.equals(String.valueOf(month - 2))) {

					bwLastLoginDate.write(id + "," + name + "," + email + "," + gender + "," + signUpDate + ","
							+ lastLoginDate + "," + lastLoginTime + "," + point);
					bwLastLoginDate.newLine();

				} else if (month == 1) {
					if (yyyy.equals(String.valueOf(year)) && m.equals(String.valueOf(month))
							|| yyyy.equals(String.valueOf(year - 1)) && m.equals(String.valueOf(month + 11))
							|| yyyy.equals(String.valueOf(year - 1)) && m.equals(String.valueOf(month + 10))) {

						bwLastLoginDate.write(id + "," + name + "," + email + "," + gender + "," + signUpDate + ","
								+ lastLoginDate + "," + lastLoginTime + "," + point);
						bwLastLoginDate.newLine();

					}
				} else if (month == 2) {
					if (yyyy.equals(String.valueOf(year)) && m.equals(String.valueOf(month))
							|| yyyy.equals(String.valueOf(year - 1)) && m.equals(String.valueOf(month - 1))
							|| yyyy.equals(String.valueOf(year - 1)) && m.equals(String.valueOf(month + 10))) {

						bwLastLoginDate.write(id + "," + name + "," + email + "," + gender + "," + signUpDate + ","
								+ lastLoginDate + "," + lastLoginTime + "," + point);
						bwLastLoginDate.newLine();

					}
				}
			}
			// 포인트 많은 순으로 자르기
			Collections.sort(points);
			for (int i = 0; i < 100; i++) {
				StringTokenizer login = new StringTokenizer(points.get(i).toString());
				String id = login.nextToken(",");
				String name = login.nextToken(",");
				String email = login.nextToken(",");
				String gender = login.nextToken(",");
				String signUpDate = login.nextToken(",");
				String lastLoginDate = login.nextToken(",");
				String lastLoginTime = login.nextToken(",");
				String point = login.nextToken(",");
				bwPoint.write(id + "," + name + "," + email + "," + gender + "," + signUpDate + "," + lastLoginDate
						+ "," + lastLoginTime + "," + point);
				bwPoint.newLine();
			}

			// 모두 입력
			bwMale.flush();
			bwFemale.flush();
			bwLastLoginDate.flush();
			bwLastLoginTime.flush();
			bwPoint.flush();

			// 트라이 닫히면서 전부 자동으로 닫힘
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
