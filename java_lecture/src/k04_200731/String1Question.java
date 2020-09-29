package k04_200731;

public class String1Question {
	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa를 " + stringCount(src, "aa") + "개 찾았습니다.");
	}

	static int stringCount(String src, String key) {
		return stringCount(src, key, 0);
	}

	static int stringCount(String src, String key, int pos) {
		int count = 0;
		int index = 0;

		if (key == null || key.length() == 0) {
			return 0;
		} else {
			for (index = 0; index < src.length(); index++) {
				if (src.substring(index, index + key.length()).equals(key)) {
					count++;
					if (index >= src.length() - key.length()) {
						break;
					}
				}
			}
			// while((index=src.indexOf(key,pos)) != -1) {
			// count++;
			// pos = index + key.length();
			// }
			return count;
		}
	}
}
