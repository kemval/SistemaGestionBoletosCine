/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionboletoscine_kembly;

import java.io.*;
import java.util.*;
import java.util.List;

//clase para geenrar los reportes y las facturas

public class GeneradorReportes {
    private GestorBoletos gestor;
    
    public GeneradorReportes(GestorBoletos gestor) {
        this.gestor = gestor;
    }
    
    public String generarReporteGeneral() throws IOException {
        if (gestor.getTotalBoletos() == 0) {
            throw new IllegalStateException("No hay boletos para generar reporte");
        }
        
        String nombreArchivo = obtenerNombreArchivo("reporte_boletos", ".txt");
        FileWriter writer = new FileWriter(nombreArchivo);
        
        writer.write("===== REPORTE GENERAL DE BOLETOS DE CINE =====\n");
        writer.write("Total de boletos vendidos: " + gestor.getTotalBoletos() + "\n");
        writer.write(String.format("Promedio de precios: ₡%.2f\n", gestor.calcularPromedioPrecios()));
        writer.write(String.format("Total recaudado: ₡%.2f\n", gestor.calcularTotalRecaudado()));
        
        // Películas más populares
        Map<String, Integer> estadisticas = gestor.obtenerEstadisticasPeliculas();
        List<Map.Entry<String, Integer>> peliculasOrdenadas = new ArrayList<>(estadisticas.entrySet());
        peliculasOrdenadas.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        writer.write("\nPelículas más populares:\n");
        int posicion = 1;
        for (Map.Entry<String, Integer> entrada : peliculasOrdenadas) {
            writer.write(posicion + "- " + entrada.getKey() + ": " + entrada.getValue() + " boletos\n");
            posicion++;
        }
        
        writer.write("\nReporte generado correctamente");
        writer.close();
        
        return nombreArchivo;
    }
    
    public String generarFactura(int codigoBoleto) throws IOException {
        Boleto boleto = gestor.buscarBoleto(codigoBoleto);
        if (boleto == null) {
            throw new IllegalArgumentException("No se encontró boleto con código: " + codigoBoleto);
        }
        
        String nombreArchivo = "factura_" + boleto.getNombre__comprador().replaceAll("\\s+", "") + ".txt";
        FileWriter writer = new FileWriter(nombreArchivo);
        
        writer.write("====== FACTURA DE COMPRA DE BOLETO ======\n");
        writer.write("Nombre del comprador: " + boleto.getNombre__comprador() + "\n");
        writer.write("Película: " + boleto.getPelicula().getNombre() + "\n");
        writer.write("Sala: " + boleto.getSala() + "\n");
        writer.write("Horario: " + boleto.getHorario__funcion() + "\n");
        writer.write("Asiento: " + boleto.getAsiento__reservado() + "\n");
        writer.write(String.format("Precio: ₡%.2f\n", boleto.getPrecio__boleto()));
        writer.write("Pago realizado: " + (boleto.isPago__realizado() ? "Sí" : "No") + "\n");
        writer.write("\nGracias por su compra.\n");
        writer.write("Disfrute la función");
        
        writer.close();
        return nombreArchivo;
    }
    
    private String obtenerNombreArchivo(String nombreBase, String extension) {
        String nombreArchivo = nombreBase + extension;
        File archivo = new File(nombreArchivo);
        int contador = 1;
        
        while (archivo.exists()) {
            nombreArchivo = nombreBase + contador + extension;
            archivo = new File(nombreArchivo);
            contador++;
        }
        
        return nombreArchivo;
    }
}