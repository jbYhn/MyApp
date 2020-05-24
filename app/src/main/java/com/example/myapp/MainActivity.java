package com.example.myapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.icndb.com/";

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();

        List<Joke> jokeList = getDataFromCache();
        if (jokeList != null) {
            showList(jokeList);
        }
        else {
            makeApiCall();
        }

    }

    private List<Joke> getDataFromCache() {
        String jsonPokemon = sharedPreferences.getString("jsonPokemonList", null);
        if (jsonPokemon == null) {
            return null;
        }
        else {
            Type listType = new TypeToken<List<Joke>>(){}.getType();
            return gson.fromJson(jsonPokemon, listType);
        }



    }

    private void showList(List<Joke> jokeList) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new ListAdapter(jokeList);
        recyclerView.setAdapter(mAdapter);
    }

    protected void makeApiCall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JokeAPI jokeApi = retrofit.create(JokeAPI.class);

        Call<RestJokeResponse> call = jokeApi.getJokeResponse();
        call.enqueue(new Callback<RestJokeResponse>() {
            @Override
            public void onResponse(Call<RestJokeResponse> call, Response<RestJokeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Joke> jokeList = response.body().getValue();
                    Toast.makeText(getApplicationContext(), "API success" ,Toast.LENGTH_SHORT).show();
                    showList(jokeList);
                }
                else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<RestJokeResponse> call, Throwable t) {
                Throwable tab = t;
                showError();
            }
        });
    }

    private void saveList(RestJokeResponse joke) {
        String jsonString = gson.toJson(joke);

        sharedPreferences
                .edit()
                .putString("jsonJokeList", jsonString)
                .apply();

        Toast.makeText(getApplicationContext(), "Joke Sauvegarde", Toast.LENGTH_SHORT).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }


}


