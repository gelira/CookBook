package com.letscode.cookBook.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NovoModoPreparoView {
    private List<String> modoPreparo;

    public NovoModoPreparoView() {
        modoPreparo = new ArrayList<>();
    }

    public String[] askModoPreparo() {
        System.out.println("[MODO DE PREPARO]");
        int op;

        do {
            System.out.println("Nova instrução do modo de preparo:");

            String instrucao = new Scanner(System.in).nextLine();
            modoPreparo.add(instrucao);

            System.out.print("Adicionar mais uma instrução? [0 - Não / qualquer coisa - Sim] ");
            try {
                op = new Scanner(System.in).nextInt();
            }
            catch (Exception e) {
                op = 1;
            }
        } while (op != 0);

        String[] modoPreparoArray = new String[modoPreparo.size()];

        for (int i = 0; i < modoPreparo.size(); i ++) {
            modoPreparoArray[i] = modoPreparo.get(i);
        }

        return modoPreparoArray;
    }
}
