package com.example.receitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MutableLiveData<String> ingrediente1 = new MutableLiveData<>();
    private TextView ingredientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReceitaApplication app = (ReceitaApplication)getApplication();
        ingredientes = (TextView) findViewById(R.id.textView);

        ingrediente1.observe(this, (v) -> ingredientes.setText(v));

        app.executor.execute(() -> {
            try {
                Meals receita = app.getReceitasRepo().buscaReceita();
                for(int i = 0; i< receita.meals.length;i++) {
                    Log.d("ReceitaRETORNO", String.valueOf(receita.meals[0].strMeal));
                    Log.d("ReceitaRETORNO", String.valueOf(receita.meals[0].strIngredient1));
                    ingrediente1.postValue(String.valueOf(receita.meals[0].strIngredient1+" \n"+ receita.meals[0].strIngredient2+" \n"));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
