
package com.mycompany.tutoria_java2;

import java.util.List;
import java.util.ArrayList;

public class Propietario {
    private String nombre;
    private String Cedula;
    private List<Automovil> automoviles;

    public Propietario(String nombre, String Cedula) {
        this.nombre = nombre;
        this.Cedula = Cedula;
        this.automoviles = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public List<Automovil> getAutomoviles() {
        return automoviles;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void agregarVehiculos(Automovil automoviles1){
        automoviles.add(automoviles1);
        
        System.out.println("Ahora el propietario de " + automoviles1.getMarca() + " es de " + nombre);
        
    }
    
    public void MostrarAutomoviles(){
        System.out.println("sus automoviles de " + nombre + " son ");
        if(automoviles.isEmpty()){
            System.out.println("no tiene ningun automovil");
        } else{
            for(int i = 0; i < automoviles.size(); i ++){
                System.out.println((i+1) + ". " + automoviles.get(i).getNombre() + " " +
                        automoviles.get(i).getMarca() + " " +
                        automoviles.get(i).getAnio());
            }
        }
        
    }
    
    public void Informacion(){
        System.out.println("Información del propietario");
        System.out.println("nombre " + nombre);
        System.out.println("cedula " + Cedula);
        System.out.println("Cantidad de automoviles " + automoviles.size());
    }
    
}
