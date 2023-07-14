package com.example.receitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MutableLiveData<String> nomeReceita = new MutableLiveData<>();
    private MutableLiveData<String> modoPreparo = new MutableLiveData<>();
    private MutableLiveData<String> ingredientesMedidas = new MutableLiveData<>();

    private MutableLiveData<String> urlImagem = new MutableLiveData<>();
    private TextView nome;
    private TextView preparo;
    private TextView ingredientes;
    private ImageView imagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReceitaApplication app = (ReceitaApplication)getApplication();
        nome = (TextView) findViewById(R.id.nomeReceita);
        preparo = (TextView) findViewById(R.id.preparo);
        ingredientes = (TextView) findViewById(R.id.textView);
        imagem = (ImageView) findViewById(R.id.imageView);
        nomeReceita.observe(this,(v) -> nome.setText(v));
        modoPreparo.observe(this,(v) -> preparo.setText(v));
        ingredientesMedidas.observe(this, (v) -> ingredientes.setText(v));
        getUrlImagem().observe(this,
                (v) -> Picasso.get().load(v).into(imagem));
        app.executor.execute(() -> {
            try {
                Meals receita = app.getReceitasRepo().buscaReceita();
                    nomeReceita.postValue(String.valueOf(receita.meals[0].strMeal));
                    urlImagem.postValue(String.valueOf(receita.meals[0].strMealThumb));
                    modoPreparo.postValue(String.valueOf(receita.meals[0].strInstructions));
                    ingredientesMedidas.postValue(String.valueOf(receita.meals[0].strIngredient1+" - "+receita.meals[0].strMeasure1 +" \n"+
                            receita.meals[0].strIngredient2+" - "+receita.meals[0].strMeasure2 +" \n"+
                            receita.meals[0].strIngredient3+" - "+receita.meals[0].strMeasure3 +" \n"+
                            receita.meals[0].strIngredient4+" - "+receita.meals[0].strMeasure4 +" \n"+
                            receita.meals[0].strIngredient5+" - "+receita.meals[0].strMeasure5 +" \n"+
                            receita.meals[0].strIngredient6+" - "+receita.meals[0].strMeasure6 +" \n"+
                            receita.meals[0].strIngredient7+" - "+receita.meals[0].strMeasure7 +" \n"+
                            receita.meals[0].strIngredient8+" - "+receita.meals[0].strMeasure8 +" \n"+
                            receita.meals[0].strIngredient9+" - "+receita.meals[0].strMeasure9 +" \n"+
                            receita.meals[0].strIngredient10+" - "+receita.meals[0].strMeasure10 +" \n"+
                            receita.meals[0].strIngredient11+" - "+receita.meals[0].strMeasure11 +" \n"+
                            receita.meals[0].strIngredient12+" - "+receita.meals[0].strMeasure12 +" \n"+
                            receita.meals[0].strIngredient13+" - "+receita.meals[0].strMeasure13 +" \n"+
                            receita.meals[0].strIngredient14+" - "+receita.meals[0].strMeasure14 +" \n"+
                            receita.meals[0].strIngredient15+" - "+receita.meals[0].strMeasure15 +" \n"+
                            receita.meals[0].strIngredient16+" - "+receita.meals[0].strMeasure16 +" \n"+
                            receita.meals[0].strIngredient17+" - "+receita.meals[0].strMeasure17 +" \n"+
                            receita.meals[0].strIngredient18+" - "+receita.meals[0].strMeasure18 +" \n"+
                            receita.meals[0].strIngredient19+" - "+receita.meals[0].strMeasure19 +" \n"+
                            receita.meals[0].strIngredient20+" - "+receita.meals[0].strMeasure20));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public LiveData<String> getUrlImagem() {
        return urlImagem;
    }
}
