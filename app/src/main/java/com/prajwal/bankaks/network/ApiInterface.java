package com.prajwal.bankaks.network;

import com.prajwal.bankaks.model.Main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.*;

/**
 * Created by Prajwal Waingankar
 * on 03-Dec-20.
 * Github: prajwalmw
 */


public interface ApiInterface {

    @GET("{type}")
    Call<Main> getDynamicUI(@Path("type") int option);
}
