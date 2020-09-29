package lastquestion;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderService {
	String BASE_URL = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/";

	@GET("storesByGeo/json?lat=37.385805&lng=127.121272&m=5000")
	Call<StoreData> storeInfos();

}
