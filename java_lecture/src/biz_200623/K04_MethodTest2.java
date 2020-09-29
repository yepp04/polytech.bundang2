package biz_200623;

//BIZ프로그래밍 6강 객체지향 조금만 알기 실습 200623 강진성
public class K04_MethodTest2 {

	static int k04_iStatic;

	public static void k04_add(int k04_i) {
		k04_iStatic++;
		k04_i++;
		System.out.printf("add메소드에서->k04_iStatic=[%d]\n", k04_iStatic);
		System.out.printf("add메소드에서->k04_i[%d]\n", k04_i);
	}

	public static int k04_add2(int k04_i) {
		k04_iStatic++;
		k04_i++;
		System.out.printf("add메소드에서->k04_iStatic=[%d]\n", k04_iStatic);
		System.out.printf("add메소드에서->k04_i[%d]\n", k04_i);
		return k04_i;
	}

	public static void main(String[] args) {
		int k04_iMain;
		k04_iMain = 1;
		k04_iStatic = 1;

		System.out.printf("***************************************\n");
		System.out.printf("메소드호출전 메인에서->k04_iStatic=[%d]\n", k04_iStatic);
		System.out.printf("메소드호출전 메인에서->k04_iMain=[%d]\n", k04_iMain);
		System.out.printf("***************************************\n");

		k04_add(k04_iMain);

		System.out.printf("***************************************\n");
		System.out.printf("메소드호출전 메인에서->k04_iStatic=[%d]\n", k04_iStatic);
		System.out.printf("메소드호출전 메인에서->k04_iMain=[%d]\n", k04_iMain);
		System.out.printf("***************************************\n");

		k04_add2(k04_iMain);

		System.out.printf("***************************************\n");
		System.out.printf("메소드호출전 메인에서->k04_iStatic=[%d]\n", k04_iStatic);
		System.out.printf("메소드호출전 메인에서->k04_iMain=[%d]\n", k04_iMain);
		System.out.printf("***************************************\n");

	}
}
