package com.letscode.cookBook.view;

import com.letscode.cookBook.controller.Catalogo;
import com.letscode.cookBook.domain.Ingrediente;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.domain.Rendimento;
import com.letscode.cookBook.enums.Categoria;

import java.util.Scanner;

public class NovaReceitaView {
    private String nome;
    private Categoria categoria;
    private Ingrediente[] ingredientes;
    private String[] modoPreparo;
    private Rendimento rendimento;
    private Catalogo catalogoController;

    public NovaReceitaView(Catalogo catalogoController) {
        this.catalogoController = catalogoController;
    }

    public Receita askReceita() {
        askNome();
        askCategoria();
        askIngredientes();
        askModoPreparo();
        askRendimento();

        Receita receita = new Receita(nome, categoria);
        receita.setIngredientes(ingredientes);
        receita.setModoPreparo(modoPreparo);
        receita.setRendimento(rendimento);

        return receita;
    }

    private void askNome() {
        do {
            System.out.println("Qual o nome da receita?");

            nome = new Scanner(System.in).nextLine();

            if (nome.isBlank()) {
                System.out.println("Nome inválido!");
                continue;
            }
            if (catalogoController.getReceita(nome) != null) {
                System.out.println("Já existe uma receita com esse nome.");
                continue;
            }
            break;
        } while (true);
    }

    private void askCategoria() {
        int op;
        Categoria[] categoriaValues = Categoria.values();

        do {
            System.out.println("Qual a categoria da receita?");
            for (Categoria cat : categoriaValues) {
                System.out.printf("%d - %s%n", cat.ordinal(), cat.name());
            }

            try {
                op = new Scanner(System.in).nextInt();
            }
            catch (Exception e) {
                op = -1;
            }

            if (op < 0 || op >= categoriaValues.length) {
                System.out.println("Categoria inválida!");
                continue;
            }

            categoria = categoriaValues[op];
            break;
        } while (true);
    }

    private void askIngredientes() {
        ingredientes = new NovaListaIngredientesView().askIngredientes();
    }

    private void askModoPreparo() {
        modoPreparo = new NovoModoPreparoView().askModoPreparo();
    }

    private void askRendimento() {
        rendimento = new NovoRendimentoView().askRendimento();
    }
}
