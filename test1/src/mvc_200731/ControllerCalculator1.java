package mvc_200731;

public class ControllerCalculator1 {

	public void multiply(String x) {
		for (int i = 2; i < 10; i++) {
			int answer = Integer.parseInt(x) * i;
			System.out.println(x + " X " + i + " = " + answer);
		}
	}
}
