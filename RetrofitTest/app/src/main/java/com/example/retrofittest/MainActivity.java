package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {//用来显示github用户的开源仓库名称
    private static final String TAG = "tag" ;
    public List<GitHubRepo> repo;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listView = (ListView)findViewById(R.id.listView);

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
                        List<GitHubRepo> repos = response.body();
                        try{
                        listView.setAdapter(new GitHubRepoAdapter(MainActivity.this,android.R.layout.simple_list_item_1,repos));
                        }
                        catch (RuntimeException e) {
                            Log.d(TAG,"problem");
                        };
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