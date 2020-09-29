package k04_200513;

public class Main2 {
	static int a;
	static int b;

	public void syncExam() {
		System.out.println("시작");

		synchronized (this) {
			a += 2;
			b = a * 4;
		}
		System.out.println("끝");
	}

	public synchronized void syncExam2() {
		System.out.println("시작2");
		a += 2;
		b = a * 4;
		System.out.println("끝2");
	}

	public static void main(String[] args) {
		Main2 main = new Main2();
		main.syncExam();
		main.syncExam2();
		System.out.println(a);
		System.out.println(b);

	}
}
