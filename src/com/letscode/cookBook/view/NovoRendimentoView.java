package com.letscode.cookBook.view;

import com.letscode.cookBook.domain.Rendimento;
import com.letscode.cookBook.enums.TipoRendimento;

import java.util.Scanner;

public class NovoRendimentoView {
    private int quantidade;
    private TipoRendimento tipoRendimento;

    public Rendimento askRendimento() {
        System.out.println("[RENDIMENTO]");
        askTipoRendimento();
        askQuantidade();

        return new Rendimento(quantidade, tipoRendimento);
    }

    private void askTipoRendimento() {
        int op;
        TipoRendimento[] tipoRendimentoValues = TipoRendimento.values();

        do {
            System.out.println("Qual o tipo de rendimento da receita?");
            for (TipoRendimento tipo : tipoRendimentoValues) {
                System.out.printf("%d - %s%n", tipo.ordinal(), tipo.name());
            }

            try {
                op = new Scanner(System.in).nextInt();
            }
            catch (Exception e) {
                op = -1;
            }

            if (op < 0 || op >= tipoRendimentoValues.length) {
                System.out.println("Tipo inválido!");
                continue;
            }

            tipoRendimento = tipoRendimentoValues[op];
            break;
        } while (true);
    }

    private void askQuantidade() {
        do {
            System.out.println("Qual a quantidade do rendimento dessa receita?");

            try {
                quantidade = new Scanner(System.in).nextInt();
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
