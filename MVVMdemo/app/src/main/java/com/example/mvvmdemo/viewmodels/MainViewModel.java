package com.example.mvvmdemo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdemo.User;

public class MainViewModel extends ViewModel {

    public MutableLiveData<User> user;

    public MutableLiveData<User> getUser(){
        if(user == null){
            user = new MutableLiveData<>();
        }
        return user;
    }
}
