package k04_200512;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex8_1 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://alimipro.com/favicon.ico"); // url 입력
		String copyFilePath = "C:\\Users\\kopo\\Desktop\\icon.ico"; // 파일 위치 지정
		File copyFile = new File(copyFilePath); // 새로운 파일 생성

		try {
			InputStream is = url.openStream(); // url을 연다
			InputStreamReader isr = new InputStreamReader(is); // 연 url을 읽는다
			FileOutputStream fos = new FileOutputStream(copyFile); // 내용을 입력할 인스턴스 생성
			int fileByte; // 바이너리 내용을 받을 필드 생성
			while ((fileByte = isr.read()) != -1) { // 하나씩 읽어서 fos에 쓴다
				fos.write(fileByte);
			}
			isr.close(); // 닫는다
			fos.close(); // 닫는다
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
