package source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main4 {

	public static void main(String[] args) {
//		legacy();
//		okhttp();
		retrofit();

	}

	public static void retrofit() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(JsonPlaceHolderService.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		JsonPlaceHolderService service = retrofit.create(JsonPlaceHolderService.class);

		Call<List<Post>> fetchPosts = service.fetchPosts();

		try {
			System.out.println(fetchPosts.execute().body());
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
