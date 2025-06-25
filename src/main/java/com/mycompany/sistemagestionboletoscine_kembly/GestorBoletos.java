package com.mycompany.sistemagestionboletoscine_kembly;

import java.util.*;
import java.io.*;

//clase para la lógica de gestion de boletos

public class GestorBoletos {
    private ArrayList<Boleto> listaBoletos;
    
    public GestorBoletos() {
        this.listaBoletos = new ArrayList<>();
    }
    
    public boolean agregarBoleto(Boleto boleto) {
        // Verificar si ya existe el código
        if (existeCodigo(boleto.getCodigo__boleto())) {
            return false;
        }
        return listaBoletos.add(boleto);
    }
    
    public boolean existeCodigo(int codigo) {
        for (Boleto boleto : listaBoletos) {
            if (boleto.getCodigo__boleto() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public Boleto buscarBoleto(int codigo) {
        for (Boleto boleto : listaBoletos) {
            if (boleto.getCodigo__boleto() == codigo) {
                return boleto;
            }
        }
        return null;
    }
    
    public ArrayList<Boleto> getListaBoletos() {
        return listaBoletos;
    }
    
    public int getTotalBoletos() {
        return listaBoletos.size();
    }
    
    public double calcularTotalRecaudado() {
        double total = 0;
        for (Boleto boleto : listaBoletos) {
            total += boleto.getPrecio__boleto();
        }
        return total;
    }
    
    public double calcularPromedioPrecios() {
        if (listaBoletos.isEmpty()) return 0;
        return calcularTotalRecaudado() / listaBoletos.size();
    }
    
    public Map<String, Integer> obtenerEstadisticasPeliculas() {
        Map<String, Integer> contador = new HashMap<>();
        for (Boleto boleto : listaBoletos) {
            String pelicula = boleto.getPelicula().getNombre();
            contador.put(pelicula, contador.getOrDefault(pelicula, 0) + 1);
        }
        return contador;
    }
}
