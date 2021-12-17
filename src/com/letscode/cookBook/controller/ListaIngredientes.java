package com.letscode.cookBook.controller;

import com.letscode.cookBook.domain.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class ListaIngredientes {
    private List<Ingrediente> ingredientes;

    public ListaIngredientes() {
        ingredientes = new ArrayList<>();
    }

    public void addIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public boolean checkIngredienteExists(String nome) {
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public Ingrediente[] getIngredientes() {
        Ingrediente[] ingredientesArray = new Ingrediente[ingredientes.size()];

        for (int i = 0; i < ingredientes.size(); i ++) {
            ingredientesArray[i] = ingredientes.get(i);
        }

        return ingredientesArray;
    }
}
