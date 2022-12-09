package model;

import javax.swing.*;

public enum Status {
    ABERTO,
    ANDAMENTO,
    CONCLUIDO;

    public static Object getTipoById(Integer opcao) {
        if (opcao == 1) {
            return ABERTO;
        } else if (opcao == 2) {
            return ANDAMENTO;
        } else if (opcao == 3) {
            return CONCLUIDO;
        }
        return getTipoById(opcao);
    }
}
