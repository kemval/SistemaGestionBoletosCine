/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionboletoscine_kembly;

//Clase para validar datos 

public class ValidadorDatos {
    
    public static String validarBoleto(String nombre, String precio, String asiento) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre del comprador es obligatorio.";
        }
        
        if (precio == null || precio.trim().isEmpty()) {
            return "El precio es obligatorio.";
        }
        
        try {
            double precioDouble = Double.parseDouble(precio.trim());
            if (precioDouble <= 0) {
                return "El precio debe ser mayor a cero.";
            }
        } catch (NumberFormatException e) {
            return "El precio debe ser un número válido.";
        }
        
        if (asiento == null || asiento.trim().isEmpty()) {
            return "El asiento es obligatorio.";
        }
        
        return null; 
    }
    
    public static boolean esNumeroValido(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
