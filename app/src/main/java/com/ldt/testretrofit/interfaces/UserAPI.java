package com.ldt.testretrofit.interfaces;

import com.ldt.testretrofit.entity.APIResponse;
import com.ldt.testretrofit.entity.APIResponseList;
import com.ldt.testretrofit.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ldt on 27/08/2017.
 */

public interface UserAPI {

    @GET("user/getUser/")
    Call<User> getUser();

    @GET("user/getUsers/")
    Call<APIResponse<List<User>>> getUsers();

    @GET("user/getUserError/")
    Call<APIResponse<User>> getUserError();
}
