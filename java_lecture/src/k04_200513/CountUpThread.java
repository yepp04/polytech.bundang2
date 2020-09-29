package k04_200513;

public class CountUpThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 51; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		new CountUpThread().start();
		new CountUpThread().start();
		new CountUpThread().start();
	}
}