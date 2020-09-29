package source2;

public class Main {
	public static void main(String[] args) {
		String name1 = "노트북1";
		String name2 = "노트북2";
		int weight1 = 1000; // 낮으면 좋은거
		int weight2 = 1400; // 낮으면 좋은거
		int screen1 = 14; // 높으면 좋은거
		int screen2 = 15; // 높으면 좋은거
		int capacity1 = 340; // 높으면 좋은거
		int capacity2 = 320; // 높으면 좋은거
		int price1 = 80; // 낮으면 좋은거
		int price2 = 70; // 낮으면 좋은거

		String result1 = "";
		String result2 = "";
		int count1 = 0;
		int count2 = 0;

		if (weight1 > weight2) {
			result1 = name1 + " : ";
			result2 = name2 + " : 무게(20점) ";
			count2 = +20;
		} else if (weight2 > weight1) {
			result1 = name1 + " : 무게(20점) ";
			result2 = name2 + " : ";
			count1 = +20;
		} else {
			result1 = name1 + " : ";
			result2 = name2 + " : ";
		}
		if (result1.contains("무게") && screen1 > screen2) {
			result1 = result1 + "+ 화면(20점) ";
			count1 = +20;
		} else if (!result1.contains("무게") && screen1 > screen2) {
			result1 = result1 + "화면(20점) ";
			count1 = +20;
		}
		if (result2.contains("무게") && screen2 > screen1) {
			result2 = result2 + "+ 화면(20점) ";
			count2 = +20;
		} else if (!result2.contains("무게") && screen2 > screen1) {
			result2 = result2 + "화면(20점) ";
			count2 = +20;
		}

		if ((result1.contains("무게") || result1.contains("화면")) && capacity1 > capacity2) {
			result1 = result1 + "+ 용량(20점) ";
			count1 = +20;
		} else if (!(result1.contains("무게") || result1.contains("화면")) && capacity1 > capacity2) {
			result1 = result1 + "용량(20점) ";
			count1 = +20;
		}
		if ((result2.contains("무게") || result2.contains("화면")) && capacity2 > capacity1) {
			result2 = result2 + "+ 용량(20점) ";
			count1 = +20;
		} else if (!(result1.contains("무게") || result1.contains("화면")) && capacity2 > capacity1) {
			result2 = result2 + "용량(20점) ";
			count1 = +20;
		}

		if ((result1.contains("무게") || result1.contains("화면") || result1.contains("용량")) && price1 > price2) {
			result1 = result1 + "+ 가격(40점) ";
			count1 = +40;
			result1 = result1 + "= " + count1 + "점";
			result2 = result2 + "= " + count2 + "점";
		} else if (!(result1.contains("무게") || result1.contains("화면") || result1.contains("용량")) && price1 > price2) {
			result1 = result1 + "가격(40점) ";
			count1 = +40;
			result1 = result1 + "= " + count1 + "점";
			result2 = result2 + "= " + count2 + "점";
		}
		if ((result2.contains("무게") || result2.contains("화면") || result2.contains("용량")) && price2 > price1) {
			result2 = result2 + "+ 가격(40점) ";
			count2 = +40;
			result1 = result1 + "= " + count1 + "점";
			result2 = result2 + "= " + count2 + "점";
		} else if (!(result2.contains("무게") || result2.contains("화면") || result2.contains("용량")) && price2 > price1) {
			result2 = result2 + "가격(40점) ";
			count2 = +40;
			result1 = result1 + "= " + count1 + "점";
			result2 = result2 + "= " + count2 + "점";
		}

		System.out.println(result1);
		System.out.println(result2);
		System.out.print("최종 추천 : ");
		if (count1 > count2) {
			System.out.println(name1);
		} else if (count2 > count1) {
			System.out.println(name2);
		} else {
			System.out.println("동일한 점수입니다.");
		}

	}
}
