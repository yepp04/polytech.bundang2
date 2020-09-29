package k04_200513;

class Counter {
	private long count;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public synchronized void add(long i) {
		System.out.println("더하기");
		count += i;
	}

	public synchronized void mul(long i) {
		System.out.println("곱하기");
		count *= i;
	}
}

public class Main3 {
	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.add(30);
		System.out.println(counter.getCount());
		counter.mul(23);
		System.out.println(counter.getCount());
	}
}