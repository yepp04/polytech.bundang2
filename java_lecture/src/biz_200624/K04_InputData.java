package biz_200624;

//BIZ프로그래밍 6강 실습 200624 강진성
public class K04_InputData {
	String[] k04_name;
	int[] k04_kor;
	int[] k04_eng;
	int[] k04_mat;
	int[] k04_sum;
	double[] k04_ave;

	public K04_InputData(int k04_iPerson) {
		// TODO Auto-generated constructor stub
		k04_name = new String[k04_iPerson];
		k04_kor = new int[k04_iPerson];
		k04_eng = new int[k04_iPerson];
		k04_mat = new int[k04_iPerson];
		k04_sum = new int[k04_iPerson];
		k04_ave = new double[k04_iPerson];
	}

	public void k04_SetData(int k04_i, String k04_name1, int k04_kor1, int k04_eng1, int k04_mat1) {
		k04_name[k04_i] = k04_name1;
		k04_kor[k04_i] = k04_kor1;
		k04_eng[k04_i] = k04_eng1;
		k04_mat[k04_i] = k04_mat1;
		k04_sum[k04_i] = k04_kor[k04_i] + k04_eng[k04_i] + k04_mat[k04_i];
		k04_ave[k04_i] = k04_sum[k04_i] / 3.0;
	}

	public static void main(String[] args) {
		int k04_iPerson = 10;
		K04_InputData k04_inData = new K04_InputData(k04_iPerson);
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) {
			String k04_name = String.format("홍길%02d", k04_i);
			int k04_kor = (int) (Math.random() * 100);
			int k04_eng = (int) (Math.random() * 100);
			int k04_mat = (int) (Math.random() * 100);
			k04_inData.k04_SetData(k04_i, k04_name, k04_kor, k04_eng, k04_mat);

		}
		for (int k04_i = 0; k04_i < k04_iPerson; k04_i++) {
			System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n", k04_i, k04_inData.k04_name[k04_i],
					k04_inData.k04_kor[k04_i], k04_inData.k04_eng[k04_i], k04_inData.k04_mat[k04_i],
					k04_inData.k04_sum[k04_i], k04_inData.k04_ave[k04_i]);
		}
	}
}
