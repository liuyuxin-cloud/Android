package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {//用来显示github用户的开源仓库名称
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.list_view) ;
        Retrofit.Builder builder = new Retrofit.Builder()               
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<GitHubRepo> call = client.reposForUser("liuyuxin-cloud");

        call.enqueue(new Callback<GitHubRepo>() {
            @Override
            public void onResponse(Call<GitHubRepo> call, Response<GitHubRepo> response) {
                GitHubRepo repos = response.body();
                mTextView.setText((CharSequence) repos);

            }

            @Override
            public void onFailure(Call<GitHubRepo> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}