/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionboletoscine_kembly;

//boleto
public class Boleto {
    private int codigo__boleto;
    private String nombre__comprador;
    private Pelicula pelicula;
    private int sala;
    private double precio__boleto;
    private String asiento__reservado;
    private String horario__funcion;
    private boolean pago__realizado;

    //constructor
    public Boleto(int codigo__boleto, String nombre__comprador, Pelicula pelicula, 
                  int sala, double precio__boleto, String asiento__reservado, 
                  String horario__funcion, boolean pago__realizado) {
        this.codigo__boleto = codigo__boleto;
        this.nombre__comprador = nombre__comprador;
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio__boleto = precio__boleto;
        this.asiento__reservado = asiento__reservado;
        this.horario__funcion = horario__funcion;
        this.pago__realizado = pago__realizado;
    }

    //getters
    public int getCodigo__boleto() { 
        return codigo__boleto; 
    }
    
    public String getNombre__comprador() { 
        return nombre__comprador; 
    }
    
    public Pelicula getPelicula() { 
        return pelicula; 
    }
    
    public int getSala() { 
        return sala; 
    }
    
    public double getPrecio__boleto() { 
        return precio__boleto; 
    }
    
    public String getAsiento__reservado() { 
        return asiento__reservado; 
    }
    
    public String getHorario__funcion() { 
        return horario__funcion; 
    }
    
    public boolean isPago__realizado() { 
        return pago__realizado; 
    }
    
    //setters
    public void setCodigo__boleto(int codigo__boleto) { 
        this.codigo__boleto = codigo__boleto; 
    }
    
    public void setNombre__comprador(String nombre__comprador) { 
        this.nombre__comprador = nombre__comprador; 
    }
    
    public void setPelicula(Pelicula pelicula) { 
        this.pelicula = pelicula; 
    }
    
    public void setSala(int sala) { 
        this.sala = sala; 
    }
    
    public void setPrecio__boleto(double precio__boleto) { 
        this.precio__boleto = precio__boleto; 
    }
    
    public void setAsiento__reservado(String asiento__reservado) { 
        this.asiento__reservado = asiento__reservado; 
    }
    
    public void setHorario__funcion(String horario__funcion) { 
        this.horario__funcion = horario__funcion; 
    }
    
    public void setPago__realizado(boolean pago__realizado) { 
        this.pago__realizado = pago__realizado; 
    }
}