package com.ldt.testretrofit.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ldt.testretrofit.entity.APIResponse;
import com.ldt.testretrofit.entity.User;
import com.ldt.testretrofit.interfaces.UserAPI;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ldt on 27/08/2017.
 */

public class UserController {
    static final String BASE_URL = "http://10.0.5.177:8081/";
    private static final String TAG = UserController.class.getSimpleName();

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    UserAPI userAPI = retrofit.create(UserAPI.class);

    public void getUser() {
        Call<User> call = userAPI.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: success");
                    Log.d(TAG, "onResponse: " + response.body().getName());
                } else {
                    Log.d(TAG, "onResponse: failed");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public APIResponse<List<User>> getUsers() {
        Log.d(TAG, "getUsers: ");
        Call<APIResponse<List<User>>> call = userAPI.getUsers();
        APIResponse<List<User>> result = null;
        try {
            result = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
//        call.enqueue(new Callback<APIResponse<List<User>>>() {
//            @Override
//            public void onResponse(Call<APIResponse<List<User>>> call, Response<APIResponse<List<User>>> response) {
//                if (response.isSuccessful()) {
//                    Log.d(TAG, "onResponse: success");
//                    Log.d(TAG, "onResponse: " + response.body().getData().size());
//                    t.response(response.body().getData());
//
//                } else {
//                    Log.d(TAG, "onResponse: failed ");
//                    Log.d(TAG, "onResponse: failed " + response.body().getData().size());
//                    Log.d(TAG, "onResponse: failed " + response.message());
//                    Log.d(TAG, "onResponse: failed " + new Gson().toJson(response));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<APIResponse<List<User>>> call, Throwable t) {
//                Log.d(TAG, "onFailure: ");
//                t.printStackTrace();
//            }
//        });
    }

    public void getUserError() {
        Call<APIResponse<User>> call = userAPI.getUserError();
        call.enqueue(new Callback<APIResponse<User>>() {
            @Override
            public void onResponse(Call<APIResponse<User>> call, Response<APIResponse<User>> response) {
                Log.d(TAG, "onResponse: success " + new Gson().toJson(response));
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " );
                    APIResponse<User> obj = response.body();
                    Log.d(TAG, "onResponse: " + obj.getMessage());
                    Log.d(TAG, "onResponse: " + obj.getCode());
                    Log.d(TAG, "onResponse: " + obj.getData().getName());
//                    try {
//                        JsonObject dataObj = obj;
//                        Log.d(TAG, "onResponse: success " + dataObj.toString());
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//
//                    try {
//                        String code = String.valueOf(obj.get ("code"));
//                        Log.d(TAG, "onResponse: success " + code);
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }

                } else {
                    Log.d(TAG, "onResponse: failed2");
                    Log.d(TAG, "onResponse: failed2 " + response.message());
                }
            }

            @Override
            public void onFailure(Call<APIResponse<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
