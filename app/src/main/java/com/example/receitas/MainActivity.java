package com.example.receitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReceitaApplication app = (ReceitaApplication)getApplication();

        app.executor.execute(() -> {
            try {
                Meals receita = app.getReceitasRepo().buscaReceita();
                Log.d("Receita", receita.strMeal);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}