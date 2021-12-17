package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Ingrediente;
import com.letscode.cookBook.enums.TipoMedida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddListaIngredientesView {
    private String nome;
    private double quantidade;
    private TipoMedida tipoQuantidade;
    private List<Ingrediente> listaIngredientes;

    public AddListaIngredientesView() {
        listaIngredientes = new ArrayList<>();
    }

    public Ingrediente[] askIngredientes() {
        int op;

        do {
            Ingrediente ingrediente = askIngrediente();
            listaIngredientes.add(ingrediente);

            System.out.print("Adicionar mais um ingrediente? [0 - Não / qualquer coisa - Sim] ");
            try {
                op = new Scanner(System.in).nextInt();
            }
            catch (Exception e) {
                op = 1;
            }
        } while (op != 0);

        Ingrediente[] ingredientesArray = new Ingrediente[listaIngredientes.size()];

        for (int i = 0; i < listaIngredientes.size(); i ++) {
            ingredientesArray[i] = listaIngredientes.get(i);
        }

        return ingredientesArray;
    }

    private Ingrediente askIngrediente() {
        askNome();
        askTipoQuantidade();
        askQuantidade();

        return new Ingrediente(nome, quantidade, tipoQuantidade);
    }

    private void askNome() {
        do {
            System.out.println("Qual o nome do ingrediente?");

            nome = new Scanner(System.in).nextLine();

            if (nome.isBlank()) {
                System.out.println("Nome inválido!");
                continue;
            }
            break;
        } while (true);
    }

    private void askTipoQuantidade() {
        int op;
        TipoMedida[] tipoQuantidadeValues = TipoMedida.values();

        do {
            System.out.println("Qual o tipo da quantidade do ingrediente?");
            for (TipoMedida tipo : tipoQuantidadeValues) {
                System.out.printf("%d - %s%n", tipo.ordinal(), tipo.name());
            }

            try {
                op = new Scanner(System.in).nextInt();
            }
            catch (Exception e) {
                op = -1;
            }

            if (op < 0 || op >= tipoQuantidadeValues.length) {
                System.out.println("Tipo inválido!");
                continue;
            }

            tipoQuantidade = tipoQuantidadeValues[op];
            break;
        } while (true);
    }

    private void askQuantidade() {
        do {
            System.out.println("Qual a quantidade do ingrediente?");

            try {
                quantidade = new Scanner(System.in).nextDouble();
            }
            catch (Exception e) {
                quantidade = -1;
            }

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida!");
                continue;
            }
            break;
        } while (true);
    }
}
