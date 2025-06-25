package com.mycompany.sistemagestionboletoscine_kembly;

import javax.swing.*;

public class SistemaGestionBoletosCine_Kembly {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazBoletos();
        });
    }
}