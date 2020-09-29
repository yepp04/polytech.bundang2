package k04_200731;

public class lotto {

	public static void main(String[] args) {

		int temp;
		int no[] = { 0, 0, 0, 0, 0, 0 };
		int bonus = 0;
		for (int i = 0; i < 6; i++) {
			temp = (int) ((Math.random() * 45) + 1);
			boolean flag = true;

			// 중복확인

			for (int j = 0; j < i; j++) {
				if (no[j] == temp) {
					flag = false;
				}
			}
			if (flag) {
				no[i] = temp;
			} else {
				i--;
			}
		}

		// 정렬

		for (int i = 0; i < no.length; i++) {
			for (int j = 0; j < no.length; j++) {
				if (no[i] < no[j]) {
					temp = no[i];
					no[i] = no[j];
					no[j] = temp;
				}
			}
		}

//보너스번호

		boolean flag_bonus = true;
		for (int i = 0; i < 1; i++) {
			flag_bonus = true;
			temp = (int) ((Math.random() * 45) + 1);
			for (int j = 0; j < no.length; j++) {
				if (no[j] == temp) {
					flag_bonus = false;
				}
			}
			if (flag_bonus) {
				bonus = temp;
			} else {
				i--;
			}
		}
		for (int i = 0; i < no.length; i++) {
			System.out.print(no[i] + " ");
		}
		System.out.print("+ " + bonus);
	}
}
