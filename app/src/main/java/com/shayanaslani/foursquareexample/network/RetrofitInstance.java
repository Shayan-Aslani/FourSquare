package com.shayanaslani.foursquareexample.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.shayanaslani.foursquareexample.model.Venue;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance instance;
    private Retrofit mRetrofit;

    private static final String CLIENT_ID = "KTTXWN1GWGYFI3FIW4ZY4CQHZB2WFTQN010JDAAVDUWDUQ5Y";
    private static final String CLIENT_SECRET = "0JC24S425NU40IQ1HABWGCMI5WW3B5V2LPKTP3PWREDE0RQ2";
    private static final String VERSION = "20200220";
    private static final String BASE_URL = "https://api.foursquare.com/v2/venues/";

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance(BASE_URL);
        }
        return instance;
    }

    private static Converter.Factory createGsonConverter() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<Venue>>() {}.getType(), new VenueListDeserializer())
                .registerTypeAdapter(Venue.class , new VenueDetailDeserializer())
                .create();

        return GsonConverterFactory.create(gson);
    }


    public Retrofit getRetrofit(){
        return mRetrofit;
    }

    private RetrofitInstance(String baseUrl) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(CLIENT_ID, CLIENT_SECRET, VERSION))
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(createGsonConverter())
                .client(client)
                .build();
    }

    private static class BasicAuthInterceptor implements Interceptor {

        private String clientId, clientSecret, version;

        public BasicAuthInterceptor(String clientId, String clientSecret, String version) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.version = version;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            HttpUrl url = request.url().newBuilder()
                    .addQueryParameter("client_id", clientId)
                    .addQueryParameter("client_secret", clientSecret)
                    .addQueryParameter("v", version)
                    .build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        }
    }
}
