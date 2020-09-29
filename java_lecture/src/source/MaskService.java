package source;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MaskService {
	String BASE_URL = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/";

	@GET("storesByGeo/json?lat=37.385992&lng=127.121282&m=5000")
	Call<StoreData> fetchStoreData();
}
