package com.ldt.testretrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ldt.testretrofit.R;
import com.ldt.testretrofit.controller.UserController;
import com.ldt.testretrofit.entity.APIResponse;
import com.ldt.testretrofit.entity.User;
import com.ldt.testretrofit.interfaces.IResponse;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnGetUser) void getUser(){
        Log.d(TAG, "getUser: ");
        UserController userController = new UserController();
        userController.getUser();
    }

    @OnClick(R.id.btnGetUsers) void getUsers(){
        Log.d(TAG, "getUsers: ");
        UserController userController = new UserController();
        APIResponse<List<User>> response = userController.getUsers();
        Log.d(TAG, "getUsers: " + response.getCode());
        Log.d(TAG, "getUsers: " + response.getMessage());
        Log.d(TAG, "getUsers: " + response.getData().size());

//        userController.getUsers(new IResponse<List<User>>() {
//            @Override
//            public void response(List<User> users) {
//                Log.d(TAG, "response: " + users.size());
//            }
//        });
    }

    @OnClick(R.id.btnGetUserError) void getUserError(){
        Log.d(TAG, "getUsers: ");
        UserController userController = new UserController();
        userController.getUserError();
    }
}
