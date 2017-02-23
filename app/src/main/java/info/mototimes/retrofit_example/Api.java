package info.mototimes.retrofit_example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rjhdby on 23.02.17.
 */

public interface Api {
    @GET("getform.php")
    Call<ResponseBody> getData(@Query("key") String key);
}
