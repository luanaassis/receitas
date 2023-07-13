package com.example.receitas;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReceitaApplication extends Application {
    public Executor executor = Executors.newFixedThreadPool(1);
    private ReceitasRepo receitasRepo;
    public ReceitasRepo getReceitasRepo() {
        if (receitasRepo != null) return receitasRepo;

        Receitaapi api = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Receitaapi.class);

        receitasRepo = new ReceitasRepo(api);
        return receitasRepo;
    }
}
