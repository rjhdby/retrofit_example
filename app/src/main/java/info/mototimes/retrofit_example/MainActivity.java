package info.mototimes.retrofit_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder().baseUrl("http://www.chat.pareto-marketing.ru/").addConverterFactory(GsonConverterFactory.create()).build();
        api63 = retrofit.create(Api.class);

        get();
    }

    private static Api      api63;
    private        Retrofit retrofit;


    public static Api getApi() {
        return api63;
    }

    public void get() {
        Call<ResponseBody> response = getApi().getData("1234");
        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> p1, Response<ResponseBody> response) {
                try {
                    Log.d("RESPONSE", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> p1, Throwable p2) {
            }
        });
    }
}
