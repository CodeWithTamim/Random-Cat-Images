package com.cwtstudio.randomcatimages.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.cwtstudio.randomcatimages.Adapters.RVAdapter;
import com.cwtstudio.randomcatimages.Models.CatsModel;
import com.cwtstudio.randomcatimages.R;
import com.cwtstudio.randomcatimages.Rests.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        callApi();




    }

    private void callApi() {
        RetrofitClient.ApiService apiService = RetrofitClient.getRetrofitInstance().create(RetrofitClient.ApiService.class);
        apiService.getResponse().enqueue(new Callback<List<CatsModel>>() {
            @Override
            public void onResponse(Call<List<CatsModel>> call, Response<List<CatsModel>> response) {
                if (response.isSuccessful()) {
                    List<CatsModel> catslist = response.body();
                    adapter = new RVAdapter(catslist,MainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<CatsModel>> call, Throwable t) {
                showToast(t.getLocalizedMessage());

            }
        });


    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}