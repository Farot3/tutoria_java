
package com.mycompany.tutoria_java2;

public abstract class Automovil {
    private String nombre;
    private String marca;
    private int anio;
    private double velocidad;

    public Automovil(String nombre, String marca, int anio, double velocidad) {
        this.nombre = nombre;
        this.marca = marca;
        this.anio = anio;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    
    public abstract void hacerSonido();
    
    
    public void frenar(double decremento){
        this.velocidad -= decremento;
        if(this.velocidad < 0){
            this.velocidad = 0;
        }
        
        System.out.println(marca + " " + nombre + "... a desacelerado a " + decremento + "km/h");
    }
    
    public void acelerar(double incremento){
        this.velocidad += incremento;
        
        System.out.println(marca + " " + nombre + " ha acelerado a " + incremento + "km/h");
        
    }
    
    public void MostrarInfo(){
        System.out.println("---------------------");
        System.out.println("marca "+ marca);
        System.out.println("nombre " + nombre);
        System.out.println("anio " + anio);
        System.out.println("---------------------");
    }
}
