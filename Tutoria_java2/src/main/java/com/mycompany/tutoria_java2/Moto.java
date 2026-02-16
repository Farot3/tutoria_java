
package com.mycompany.tutoria_java2;


public class Moto extends Automovil{
    private int Maletas;
    private int cantidadLuces;

    public Moto(int Maletas, int cantidadLuces, String nombre, String marca, int anio, double velocidad) {
        super(nombre, marca, anio, velocidad);
        this.Maletas = Maletas;
        this.cantidadLuces = cantidadLuces;
    }

    public int getMaletas() {
        return Maletas;
    }

    public int getCantidadLuces() {
        return cantidadLuces;
    }

    public void setMaletas(int Maletas) {
        this.Maletas = Maletas;
    }

    public void setCantidadLuces(int cantidadLuces) {
        this.cantidadLuces = cantidadLuces;
    }

    @Override
    public void hacerSonido() {
        System.out.println("¡VROOM VROOM! 🏍️");
    }
    
    public void Datos(){
        System.out.println("la marca de la moto es: " + getMarca());
    }
    
    @Override
    public void MostrarInfo(){
        super.MostrarInfo();
        System.out.println("Maletas: " + Maletas);
        System.out.println("cantidadLuces: " + cantidadLuces);
    }
}
