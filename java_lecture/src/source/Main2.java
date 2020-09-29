package source;

public class Main2 {
	int count = 0;

	public void increase() {
		synchronized (this) {
			while (count < 10) {
				count++;
				System.out.println(count + "=====" + Thread.currentThread().getId());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void decrease() {
		while (count > 0) {
			count--;
			System.out.println(count);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Main2 main = new Main2();

		new Thread(() -> main.increase()).start();
		new Thread(() -> main.increase()).start();

		new Thread(() -> main.decrease()).start();
		new Thread(() -> main.decrease()).start();

//		Scanner scanner = new Scanner(System.in);
//
//		Thread thread = new PrintThread();
//		thread.start();
//
//		Thread thread2 = new Thread(new PrintThread2());
//		thread2.start();
//
//		Thread thread3 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					System.out.println(i + " ***** ");
//					try {
//						Thread.sleep(200);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		thread3.start();
//
//		Thread thread4 = new Thread(() -> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(i + " +++++ ");
//				try {
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		thread4.start();
//
//		new Thread(() -> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(i + " ----- ");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();

	}
}

class PrintThread2 implements Runnable {

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
