package com.cwtstudio.randomcatimages.Rests;

import com.cwtstudio.randomcatimages.Models.CatsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.thecatapi.com";
    private static  Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }




    public interface ApiService {
        ///v1/images/search?limit=10

        @GET("/v1/images/search?limit=100")
        Call<List<CatsModel>> getResponse();



    }

}
