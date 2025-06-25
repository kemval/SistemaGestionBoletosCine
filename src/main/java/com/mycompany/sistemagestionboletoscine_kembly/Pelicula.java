/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionboletoscine_kembly;

//enum para las películas
public enum Pelicula {
    PELICULA_01("Pelicula 01"),
    PELICULA_02("Pelicula 02"),
    PELICULA_03("Pelicula 03"),
    PELICULA_04("Pelicula 04"),
    PELICULA_05("Pelicula 05");

    private final String nombre;

    Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}