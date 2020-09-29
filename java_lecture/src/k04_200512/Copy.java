package k04_200512;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Copy {
	public static void main(String[] args) throws IOException {
		String imageUrl = "https://alimipro.com/favicon.ico";
		String savePath = "C:\\Users\\kopo\\Desktop\\";
		String saveFileName = "icon.ico";
		String fileFormat = "ico";

		File saveFile = new File(savePath + saveFileName);

		copy(imageUrl, saveFile, fileFormat);

	}

	public static void copy(String imageUrl, File saveFile, String fileFormat) {

		URL url = null;
		BufferedImage bi = null;

		try {
			url = new URL(imageUrl);
			bi = ImageIO.read(url);
			ImageIO.write(bi, fileFormat, saveFile);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
