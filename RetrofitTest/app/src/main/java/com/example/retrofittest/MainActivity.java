package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {//用来显示github用户的开源仓库名称
    private static final String TAG = "tag" ;
    public List<GitHubRepoList> repo;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        new Thread() {
            @Override
            public void run() {
                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.build();

                GitHubClient client = retrofit.create(GitHubClient.class);
                Call<List<GitHubRepoList>> call = client.reposForUser("liuyuxin-cloud");

                call.enqueue(new Callback<List<GitHubRepoList>>() {

                    @Override
                    public void onResponse(Call<List<GitHubRepoList>> call, Response<List<GitHubRepoList>> response) {
                        List<GitHubRepoList> repos = response.body();
                        try{
                        mRecyclerView.setAdapter(new ReposListFragment.ReposAdapter());
                        }
                        catch (RuntimeException e) {
                            Log.d(TAG,"problem");
                        };
                        Toast.makeText(MainActivity.this, "succeed", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepoList>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, Log.getStackTraceString(t));
                    }
                });
            }

        }.start();
    }
}