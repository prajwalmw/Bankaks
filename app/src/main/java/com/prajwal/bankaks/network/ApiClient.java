package com.prajwal.bankaks.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prajwal Waingankar
 * on 03-Dec-20.
 * Github: prajwalmw
 */


public class ApiClient {
    private static Retrofit retrofit = null;
    static OkHttpClient.Builder client = new OkHttpClient.Builder();

    /**
     * This function creates the Retrofit instance & states the baseUrl
     * @return Retrofit
     */
    public static Retrofit getApiClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api-staging.bankaks.com/task/") // Baseurl for the test
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
