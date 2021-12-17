package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.enums.Categoria;

import java.util.Scanner;

public class NovaReceitaView {
    Scanner scanner;
    Receita receita;
    String nome;
    Categoria categoria;

    public NovaReceitaView() {
        this.scanner = new Scanner(System.in);
    }

    public void askNome() {
        do {
            System.out.println("Qual o nome da receita?");

            nome = scanner.nextLine();

            if (nome.isBlank()) {
                System.out.println("Nome inválido!");
                continue;
            }
            break;
        } while (true);
    }

    public void askCategoria() {
        Categoria[] categoriaValues = Categoria.values();

        do {
            System.out.println("Qual a categoria da receita?");
            for (Categoria cat : categoriaValues) {
                System.out.printf("%d - %s", cat.ordinal(), cat.name());
            }

            int op = scanner.nextInt();

            if (op < 0 || op >= categoriaValues.length) {
                System.out.println("Categoria inválida!");
                continue;
            }

            categoria = categoriaValues[op];
            break;
        } while (true);
    }
}
