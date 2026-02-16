
package com.mycompany.tutoria_java2;


public class Tutoria_java2 {

    public static void main(String[] args) {
        
        System.out.println("bienvenido a POO");
        
        
        System.out.println("Creación de objetos");
        Carro carro1 = new Carro("2005", "Super", "Volvo", "Volvo", 2005, 500);
        Carro carro2 = new Carro("2010", "Regular", "montero IO", "Mitsubishi", 2010, 300);
        
        System.out.println("la marca del "+ carro2.getNombre() + " es " + carro2.getMarca());
        
        
        carro2.setMarca("Toyota");
        
        System.out.println("la nueva marca de " + carro2.getNombre() + " es " + carro2.getMarca());
        
        carro2.MostrarInfo();
        carro1.MostrarInfo();
        
        
        System.out.println("velocidad anterior es: " + carro1.getVelocidad());
        carro1.acelerar(25.87);
        System.out.println(carro1.getVelocidad());
        
        
        System.out.println(carro2.getVelocidad());
        carro2.frenar(85.7);
        System.out.println("el carro " + carro2.getNombre() + " ha desacelerado a " + carro2.getVelocidad());
    
        
        Moto moto1 = new Moto(3, 3, "java", "Suzuki", 2015, 580);
        moto1.MostrarInfo();
        
        
        Propietario propietario1 = new Propietario("carlos", "123456789");
        
        propietario1.agregarVehiculos(moto1);
        propietario1.agregarVehiculos(carro1);
        
        propietario1.Informacion();
        propietario1.MostrarAutomoviles();
        
        
        moto1.hacerSonido();
        carro1.hacerSonido();
    }
}
