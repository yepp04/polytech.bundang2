package k04_200513;

public class Main {
	public static void main(String[] args) {
		Thread thread = new Thread(new PrintThread()); // 프린트 스레드의 성질을 가진 스레드 인스턴스
		thread.start(); // 스레드 시작

		Thread thread2 = new Thread(new PrintThread2()); // 러너블을 구현하는 프린트스레드2의 성질을 가진 스레드2
		thread2.start(); // 스레드 시작

		Thread thread3 = new Thread(new Runnable() { // 러너블 인터페이스의 성질을 가진 스레드3 인스턴스
			@Override
			public void run() { // 익명클래스를 활용하여 런을 재정의
				for (int i = 0; i < 10; i++) {
					System.out.println(i + "------");
				}
			}
		});
		thread3.start(); // 스레드 시작

		Thread thread4 = new Thread(() -> { // 스레드 인스턴스 생성
			for (int i = 0; i < 10; i++) {
				System.out.println(i + " +++++ ");
				try {
					Thread.sleep(300); // 0.3초 정지
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread4.start(); // 스레드 시작

		new Thread(() -> { // 스레드 인스턴스
			for (int i = 0; i < 10; i++) {
				System.out.println(i + " ----- ");
				try {
					Thread.sleep(1000); // 1초 정지
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start(); // 스레드 시작
	}
}

class PrintThread2 implements Runnable { // 러너블 인터페이스는 run을 속성으로 가지고 있다

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " ==== ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class PrintThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}