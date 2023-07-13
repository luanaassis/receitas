package com.example.receitas;

import java.io.IOException;

public class ReceitasRepo {
    private Receitaapi api;
    public ReceitasRepo(Receitaapi api) {
        this.api = api;
    }
    public Meals buscaReceita() throws IOException {
        return api.buscaReceita().execute().body();
    }
}
