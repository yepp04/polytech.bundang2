package source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		// https://forms.gle/hFcBgarXsnsTJnv29

		Retrofit retrofit = new Retrofit.Builder().baseUrl(MaskService.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		MaskService service = retrofit.create(MaskService.class);

		StoreData storeData = service.fetchStoreData().execute().body();

		for (Store store : storeData.getStores()) {
			double distanceKiloMeter = distance(37.385992, 127.121282, store.getLat(), store.getLng(), "kilometer");
			store.setDistance(distanceKiloMeter);
		}

		// 정렬
		Collections.sort(storeData.getStores());

		for (Store store : storeData.getStores()) {
			if (store.getRemainStat() == null) {
				continue;
			}

			String status = "충분";
			switch (store.getRemainStat()) {
			case "plenty":
				status = "여유";
				break;
			case "some":
				status = "소진임박";
				break;
			case "few":
				status = "재고없음";
				break;
			default:
				status = "충분";
				break;
			}
			System.out.printf("%.2fkm    %s    %s\n", store.getDistance(), status, store.getName());
		}

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

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// This function converts radians to decimal degrees
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

//	public static void retrofit2() {
//		Retrofit retrofit = new Retrofit.Builder().baseUrl(JsonPlaceHolderService.BASE_URL)
//				.addConverterFactory(GsonConverterFactory.create()).build();
//
//		JsonPlaceHolderService service = retrofit.create(JsonPlaceHolderService.class);
//
//		try {
//			Post post = service.getPost(10).execute().body();
//			System.out.println(post);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

	public static void retrofit() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(JsonPlaceHolderService.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		JsonPlaceHolderService service = retrofit.create(JsonPlaceHolderService.class);

		Call<List<Post>> fetchPosts = service.fetchPosts();

		try {
			List<Post> posts = fetchPosts.execute().body();
//			System.out.println(posts);

			// userId == 1
			posts.stream().filter(post -> post.getUserId() == 1).forEach(post -> {
				System.out.printf("%d : %s\n", post.getId(), post.getTitle());
			});

			// 원시적
//			List<Post> result = new ArrayList<Post>();
//			for (Post post : posts) {
//				if (post.getUserId() == 1) {
//					result.add(post);
//				}
//			}
//			for (Post post: result) {
//				System.out.println(post);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void okhttp() {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(JsonPlaceHolderService.BASE_URL + "posts").build();

		try (Response response = client.newCall(request).execute()) {
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void legacy() {
		try {
			URL url = new URL(JsonPlaceHolderService.BASE_URL + "posts");
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
