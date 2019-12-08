package com.example.endterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.endterm.adapter.GitHubRepoAdapter;
import com.example.endterm.api.model.GitHubRepo;
import com.example.endterm.api.service.GitHubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements InterfaceJ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Generator NewsGenerator = Generator.getInstance();

        final RecyclerView recyclerView = findViewById(R.id.main_content_recList);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<GitHubRepo>> call = client.reposForUser("users");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(NewsGenerator.getNewsList(),this, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void startDetailsActivity(int NewsId) {
        Intent intent = new Intent(this, Detail.class).putExtra("NewsId",NewsId);
        startActivity(intent);
    }

    @Override
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
