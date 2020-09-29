package lastquestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		// https://forms.gle/hFcBgarXsnsTJnv29
		retrofit();
	}

	public static void retrofit() throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(JsonPlaceHolderService.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		JsonPlaceHolderService service = retrofit.create(JsonPlaceHolderService.class);

		StoreData storeData = service.storeInfos().execute().body(); // 이게 Call 해준 거랑 똑같음

		for (Store store : storeData.getStores()) { // 현재 위치에서 가게 위치의 거리를 set 해줌
			double distanceKiloMeter = distance(37.385805, 127.121272, store.getLat(), store.getLng(), "kilometer");
			store.setDistance(distanceKiloMeter);
		}

		Collections.sort(storeData.getStores()); // 오름차순으로 정렬

		int count = 0; // 재고 매장 수 카운트 위한 변수
		for (Store store : storeData.getStores()) { // 스토어데이터 클래스 덩어리를 스토어를 통해서 읽기
			if (store.getRemainStat() == null) { // 참이면 다음 반복으로 넘어간다
				continue;
			}
			String status; // 재고상태를 입력 시킬 변수
			switch (store.getRemainStat()) { // 재고상태 입력 및 재고 있는 매장 카운트
			case "plenty":
				status = "충분";
				count++;
				break;
			case "some":
				status = "여유";
				count++;
				break;
			case "few":
				status = "소진임박";
				count++;
				break;
			default:
				status = "재고없음";
				break;
			}
			System.out.printf("%.1f %-10.4s %-10.9s\n", store.getDistance(), status, store.getName()); // 거리, 재고상태, 이름
		}
		System.out.println("======================");
		System.out.println("마스크 재고 있는 매장 수 : " + count);
	}

	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		if (unit == "kilometer") {
			dist = dist * 1.609344;
		} else if (unit == "meter") {
			dist = dist * 1609.344;
		}

		return (dist);
	}

	// This function converts decimal degrees to radians
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// This function converts radians to decimal degrees
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	public static void okhttp() {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url(JsonPlaceHolderService.BASE_URL + "storesByGeo/json?lat=37.385805&lng=127.121272&m=5000").build();

		try (Response response = client.newCall(request).execute()) {
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void legacy() {
		try {
			URL url = new URL(JsonPlaceHolderService.BASE_URL + "storesByGeo/json?lat=37.385805&lng=127.121272&m=5000");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder stringBuilder = new StringBuilder();
			String temp;
			while ((temp = bufferedReader.readLine()) != null) {
				stringBuilder.append(temp).append("\n");
			}
			System.out.println(stringBuilder.toString());

			connection.disconnect();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
