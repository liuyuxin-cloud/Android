package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvmdemo.databinding.ActivityMainBinding;
import com.example.mvvmdemo.viewmodels.MainViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding dataBinding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new MainViewModel();

        User user = new User("admin", "123456");
        mainViewModel.getUser().setValue(user);
        MutableLiveData<User> user1 = mainViewModel.getUser();
        user1.observe(this, user2 -> dataBinding.setViewModel(mainViewModel));

        dataBinding.btnLogin.setOnClickListener(v->{
            if(mainViewModel.user.getValue().getAccount().isEmpty()){
                Toast.makeText(MainActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                return;
            }
            if(mainViewModel.user.getValue().getPwd().isEmpty()){
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

        });
    }
}