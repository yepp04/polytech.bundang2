package biz_200625_lec10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//BIZ프로그래밍 10강 JAVA DB 다루기 실습 200625 강진성
public class K04_AdvantageTraining {

	public static void k04_CreateTable(Connection k04_conn) throws SQLException, ClassNotFoundException {
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("create table stock_daily_price(stnd_iscd varchar(12)," + "bsop_date int,"
				+ "shrn_iscd varchar(8)," + "stck_prpr int," + "stck_oprc int," + "stck_hgpr int," + "stck_lwpr int,"
				+ "prdy_vrss_sign varchar(2)," + "prdy_vrss int," + "prdy_ctrt float," + "prdy_vol long,"
				+ "acml_vol long," + "acml_tr_pbmn long," + "askp1 int," + "bidp1 int," + "total_askp_rsqn long,"
				+ "total_bidp_rsqn long," + "seln_cntg_smtn long," + "shnu_cntg_smtn long," + "seln_tr_pbmn long,"
				+ "shnu_tr_pbmn long," + "seln_cntg_csnu int," + "shnu_cntg_csnu int," + "w52_hgpr int,"
				+ "w52_lwpr int," + "w52_hgpr_date int," + "w52_lwpr_date int," + "ovtm_untp_bsop_hour int,"
				+ "ovtm_untp_prpr int," + "ovtm_untp_prdy_vrss int," + "ovtm_untp_prdy_vrss_sign varchar(10),"
				+ "ovtm_untp_askp1 int," + "ovtm_untp_bidp1 int," + "ovtm_untp_vol long," + "ovtm_untp_tr_pbmn long,"
				+ "ovtm_untp_oprc int," + "ovtm_untp_hgpr int," + "ovtm_untp_lwpr int," + "mkob_otcp_vol long,"
				+ "mkob_otcp_tr_pbmn long," + "mkfa_otcp_vol long," + "mkfa_otcp_tr_pbmn long,"
				+ "mrkt_div_cls_code varchar(10)," + "pstc_dvdn_amt long," + "lstn_stcn long," + "stck_sdpr int,"
				+ "stck_fcam float," + "wghn_avrg_stck_prc double," + "issu_limt_rate float," + "frgn_limt_qty long,"
				+ "oder_able_qty long," + "frgn_limt_exhs_cls_code varchar(10)," + "frgn_hldn_qty float,"
				+ "frgn_hldn_rate float," + "hts_frgn_ehrt float," + "itmt_last_nav float," + "prdy_last_nav float,"
				+ "trc_errt float," + "dprt float," + "ssts_cntg_qty long," + "ssts_tr_pbmn long,"
				+ "frgn_ntby_qty long," + "flng_cls_code varchar(10)," + "prtt_rate float," + "acml_prtt_rate float,"
				+ "stdv float," + "beta_cfcn float," + "crlt_cfcn float," + "bull_beta float," + "bear_beta float,"
				+ "bull_dvtn float," + "bear_dvtn float," + "bull_crlt float," + "bear_crlt float," + "stck_mxpr int,"
				+ "stck_llam int," + "icic_cls_code varchar(10)," + "itmt_vol long," + "itmt_tr_pbmn long,"
				+ "fcam_mod_cls_code varchar(10)," + "revl_issu_reas_code varchar(10)," + "orgn_ntby_qty long,"
				+ "adj_prpr int," + "fn_oprc int," + "fn_hgpr int," + "fn_lwpr int," + "fn_prpr int,"
				+ "fn_acml_vol long," + "fn_acml_tr_pbmn long," + "fn_prtt_rate float,"
				+ "fn_flng_cls_code varchar(10)," + "buyin_nor_prpr int," + "buyin_nor_prdy_vrss int,"
				+ "buyin_nor_vol long," + "buyin_nor_tr_pbmn long," + "buyin_tod_prpr int," + "buyin_tod_prdy_vrss int,"
				+ "buyin_tod_vol long," + "buyin_tod_tr_pbmn long,"
				+ "constraint pk primary key(stnd_iscd, bsop_date, shrn_iscd));");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음
	}

	public static void k04_DeleteTable(Connection k04_conn) throws SQLException, ClassNotFoundException { // 메인 메서드
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		k04_stmt.execute("delete from stock_daily_price;");
		// execute 함수는 모든 구문을 수행할 수 있다. 수행결과로 Boolean 타입의 값을 반환한다.
		k04_stmt.close(); // Statement 닫음
	}

	public static void k04_InsertTable(Connection k04_conn) throws ClassNotFoundException, SQLException, IOException {
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		File k04_f = new File("c:\\users\\kopo\\desktop\\StockDailyPrice.csv");
		// 파일 변수 생성
		BufferedReader k04_br = new BufferedReader(new FileReader(k04_f));
		// 버퍼리더로 파일 읽어들임
		String k04_readtxt; // 스트링 변수 선언
		int k04_LineCnt = 0; // 인트변수 초기화, 나중에 번호매기는 용으로 쓰임
		int k04_multiIn = 0; // insert쿼리를 멀티로 넣을 때 개수 변수
		int k04_multi = 1000; // 1000개씩 넣는 것을 1000씩 더하는 변수, LineCnt와 비교하기위함(마지막 1000개이하)
		String k04_Query1000 = "";
		String k04_QueryTxt = ""; // querytxt 변수 초기화
		while ((k04_readtxt = k04_br.readLine()) != null) {// 한 줄을 읽었을 때 null값이 아니면 반복
			StringBuffer k04_s = new StringBuffer(); // 스트링버퍼 변수 생성
			String[] k04_field = k04_readtxt.split(",");// ,로 구분한 값을 field배열에 저장

			k04_s.append("'" + k04_field[0] + "'");// 1번째배열값 추가
			for (int k04_i = 1; k04_i < k04_field.length; k04_i++) { // 배열길이만큼 for문 실행
				if (k04_field.length == 99) { // 배열값이 99이면
					if (k04_i == 2 || k04_i == 7 || k04_i == 30 || k04_i == 42 || k04_i == 51 || k04_i == 62
							|| k04_i == 76 || k04_i == 79 || k04_i == 80 || k04_i == 90) {
						// varchar가 포함된 컬럼 값들을 구분해주었다
						if (k04_field[k04_i].equals("")) {
							k04_field[k04_i] = "0"; // 만약 null값이면 0으로 입력
						}
						k04_s.append(",'" + k04_field[k04_i] + "'"); // 필드앞뒤로 ''추가해줌(varchar)
					} else { // varchar값이 아니면
						if (k04_field[k04_i].equals("")) {
							k04_field[k04_i] = "0"; // null값이면 0입력
						}
						k04_s.append("," + k04_field[k04_i] + ""); // 콤마와 필드입력
					}
				} else if (k04_field.length != 99) { // 배열값이 99가 아니면
					if (k04_i == k04_field.length - 1) { // i가 그 배열값보다 1작을때
						k04_s.append(",'" + k04_field[k04_i] + "'");// varchar 추가하고
						for (int k04_j = 0; k04_j < 99 - k04_field.length; k04_j++) {// 99에서 배열값길이뺀만큼
							k04_s.append(",0"); // 콤마와 0을 추가
						}
						break; // 그리고 멈춘다
					}
					if (k04_i == 2 || k04_i == 7 || k04_i == 30 || k04_i == 42 || k04_i == 51 || k04_i == 62
							|| k04_i == 76 || k04_i == 79 || k04_i == 80 || k04_i == 90) {
						// varchar가 포함된 컬럼 값들을 구분해주었다
						if (k04_field[k04_i].equals("")) {
							k04_field[k04_i] = "0"; // 만약 null값이면 0으로 입력
						}
						k04_s.append(",'" + k04_field[k04_i] + "'"); // 버퍼 추가
					} else { // varchar값이 아니면
						if (k04_field[k04_i].equals("")) {
							k04_field[k04_i] = "0"; // null값이면 0입력
						}
						k04_s.append("," + k04_field[k04_i]); // 콤마와 필드입력
					}
				}
			}
			if (k04_multiIn == 0) { // 쿼리가 0개일 때
				k04_Query1000 = "(" + k04_s.toString() + ")"; // 처음 쿼리 입력
			} else if (k04_multiIn > 0) { // 쿼리가 1개 이상일 때
				k04_Query1000 = k04_Query1000 + "," + "(" + k04_s.toString() + ")";
			} // 그 쿼리에 콤마 추가해서 뒤에 쿼리 추가
			if (k04_LineCnt != 0 && k04_LineCnt % 100000 == 0) {
				System.out.printf("."); // 다음의 내용을 출력한다
				if (k04_LineCnt % 500000 == 0) {
					System.out.printf("\n"); // 다음의 내용을 출력한다
				}
			}
			k04_QueryTxt = // querytxt는 format형 string이다
					"insert into stock_daily_price values " + k04_Query1000 + ";"; // 복합쿼리
			if (k04_multiIn != 0 && k04_multiIn % 999 == 0) {
				k04_stmt.execute(k04_QueryTxt); // 쿼리를 실행한다
				k04_multiIn = -1; // -1로 초기화하는 이유는 이후에 1추가해서 0이되기 때문에
				k04_Query1000 = ""; // 1000개의 쿼리도 초기화 해줌
				k04_multi = k04_multi + 1000; // 카운트 1000추가
			}
			if (k04_LineCnt > k04_multi) {
				k04_QueryTxt = // querytxt는 format형 string이다
						"insert into stock_daily_price values (" + k04_s.toString() + ");"; // 복합쿼리
				k04_stmt.execute(k04_QueryTxt); // 쿼리를 실행한다
			}
			k04_multiIn++;// 카운트 1 추가
			k04_LineCnt++; // 카운트 1 추가
		}
		k04_br.close(); // 버퍼리더 닫기
		k04_stmt.close(); // Statement 닫음
		System.out.println(k04_LineCnt); // 총 갯수 추가

	}

	public static void k04_SelectTable(Connection k04_conn) throws SQLException {
		int k04_no = 1; // 1부터 시작
		Statement k04_stmt = k04_conn.createStatement(); // 연결된 데이터베이스로 SQL문을 보내기위한 SQLServerStatement 개체를 만든다
		ResultSet k04_rset = k04_stmt.executeQuery("select * from stock_daily_price where shrn_iscd = 'A005930';");
		// 삼성전자 검색
//		ResultSet k04_rset = k04_stmt.executeQuery("select * from stock_daily_price where bsop_date = 19890830;");
		// 특정날짜 검색
		// 주로 select구문을 수행할 때 사용하며 ResultSet 객체에 결과값을 담았다.
		while (k04_rset.next()) { // ResultSet 객체를 한 줄씩 읽어라
			StringBuffer k04_getSelect = new StringBuffer(); // 스트링버퍼 변수 선언
			k04_getSelect.append(k04_rset.getString(1)); // 먼저 1번째 값을 가져온다
			for (int k04_i = 1; k04_i < 99; k04_i++) { // 2번부터 99번까지의 값을 가져온다
				k04_getSelect.append("," + k04_rset.getString(k04_i + 1)); // 콤마와 겟스트링으로
			}

			System.out.printf("[" + k04_no + "]" + k04_getSelect.toString() + "\n");
			// 결과값 출력
			k04_no++; // 번호에 1 더하기
		}
		k04_rset.close(); // ResultSet 닫음
		k04_stmt.close(); // Statement 닫음
	}

	public static Connection k04_Connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 불러온다(초기화)
		Connection k04_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.24:3306/kopo04", "root",
				"rkdwlstjd");
		return k04_conn;
	}

	public static void main(String[] args) throws IOException {
		try {
//			long start = System.currentTimeMillis(); // 시작시간
			k04_Connection(); // mysql 접속
//			System.out.println(start); // 시작시간 출력
//			k04_CreateTable(k04_Connection()); // 테이블 생성
//			k04_InsertTable(k04_Connection()); // 테이블에 내용 삽입
//			k04_SelectTable(k04_Connection()); // 테이블에서 내용 검색
//			k04_DeleteTable(k04_Connection()); // 테이블 내용 삭제
//			long end = System.currentTimeMillis(); // 마침시간
//			System.out.println(end); // 마침시간 출력

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				k04_Connection().close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
