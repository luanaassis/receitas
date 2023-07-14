package com.example.receitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
                for(int i = 0; i< receita.meals.length;i++) {
                    TextView nomeReceita = findViewById(R.id.nomeReceita);
                    nomeReceita.setText(String.valueOf(receita.meals[0].strMeal));
                    Log.d("ReceitaRETORNO", String.valueOf(receita.meals[0].strMeal));
                    Log.d("ReceitaRETORNO", String.valueOf(receita.meals[0].strIngredient1));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
