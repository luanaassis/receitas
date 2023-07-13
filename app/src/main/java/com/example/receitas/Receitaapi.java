package com.example.receitas;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Receitaapi {
    @GET("random.php")
    Call<Meals> buscaReceita();
}
