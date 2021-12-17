package com.letscode.cookBook.view;

import com.letscode.cookBook.controller.Catalogo;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.enums.Categoria;

import java.util.Scanner;

public class CatalogoView {
    private final Receita NONE_FOUND = new Receita("Nenhuma receita encontrada", Categoria.PRATO_UNICO);
    private Receita receita;
    private Catalogo controller;
    private int curIndex = -1;

    public CatalogoView() {
        controller = new Catalogo();
    }

    private void showHeader() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # ##    ###  #  # #  # ##  ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("", 80, true, '=');
    }

    private void showReceita() {
        System.out.println(receita == null ? NONE_FOUND : receita);
    }

    private void showAnterior() {
        if (curIndex > 0) {
            receita = controller.getReceita(curIndex - 1);
            if (receita != null) {
                curIndex--;
            }
        }
    }

    private void showSeguinte() {
        receita = controller.getReceita(curIndex + 1);
        if (receita != null) {
            curIndex++;
        }
    }

    private void add() {
        Receita novaReceita = new NovaReceitaView(controller).askReceita();
        controller.add(novaReceita);
    }

    private void del() {
        if (curIndex >= 0) {
            controller.del(receita.getNome());
            receita = null;
        }
    }

    private void search() {
        System.out.print("Nome da receita: ");
        String nome = new Scanner(System.in).nextLine();
        receita = controller.getReceita(nome);
    }

    private void showMenu() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("P: Receita anterior", 80, true);
        ScreenUtil.printTextLine("N: Receita seguinte", 80, true);
        ScreenUtil.printTextLine("+: Adicionar nova receita", 80, true);
        ScreenUtil.printTextLine("-: Remover receita", 80, true);
        ScreenUtil.printTextLine("S: Pesquisar receita", 80, true);
        ScreenUtil.printTextLine("Q: Sair", 80, true);
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#: ", 80);
    }

    public void show() {
        showHeader();

        String option;

        do {
            showReceita();
            showMenu();

            option = new Scanner(System.in).next();
            switch (option.toUpperCase()) {
                case "P":
                    showAnterior();
                    break;
                case "N":
                    showSeguinte();
                    break;
                case "+":
                    add();
                    break;
                case "-":
                    del();
                    break;
                case "S":
                    search();
                    break;
                case "Q":
                    System.out.println("Até mais! ;)");
                    return;
                default:
                    ScreenUtil.printTextLine("Opção inválida", 80);
            }
        } while (true);
    }
}
