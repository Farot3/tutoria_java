package com.mycompany.tutoria_java2;

public class Carro extends Automovil{
    
    private String modelo;
    private String tipocombustible;

    public Carro(String modelo, String tipocombustible, String nombre, String marca, int anio, double velocidad) {
        super(nombre, marca, anio, velocidad);
        this.modelo = modelo;
        this.tipocombustible = tipocombustible;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipocombustible() {
        return tipocombustible;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipocombustible(String tipocombustible) {
        this.tipocombustible = tipocombustible;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("¡BRUM BRUM! 🚗");
    }
    
    @Override
    public void MostrarInfo(){
        super.MostrarInfo();
        System.out.println("modelo: " + modelo);
        System.out.println("tipoCombustible: " + tipocombustible);
        System.out.println("-----------------------------------------");
    }
    
}
