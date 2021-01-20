package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {//用来显示github用户的开源仓库名称
    private TextView mTextView;
    private static final String TAG = "tag" ;
    public List<GitHubRepo> repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.list_view);
        new Thread() {
            @Override
            public void run() {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();

                GitHubClient client = retrofit.create(GitHubClient.class);
                Call<List<GitHubRepo>> call = client.reposForUser("liuyuxin-cloud");

                call.enqueue(new Callback<List<GitHubRepo>>() {

                    @Override
                    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                        repo = response.body();
                        Log.d(TAG, "123");

                        Toast.makeText(MainActivity.this, "succeed", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, Log.getStackTraceString(t));
                    }
                });
            }

        }.start();
    }
}