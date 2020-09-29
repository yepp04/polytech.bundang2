package test;

import java.util.Scanner;

public class Solut {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int a = scanner.nextInt();
		int num = 1;
		for (int i = 1; i < a; i++) {
			num = num + 2;
		}
		for (int i = 0; i < num; i++) {
			sb.append("*");
		}
		System.out.println(sb);
		for (int i = 0; i < a - 1; i++) {
			sb = sb.delete(sb.length() - 2, sb.length());
			sb.insert(0, " ");
			System.out.println(sb);
		}
		for (int i = 0; i < a - 1; i++) {
			sb.delete(0, 1);
			sb.append("**");
			System.out.println(sb);
		}
	}
}