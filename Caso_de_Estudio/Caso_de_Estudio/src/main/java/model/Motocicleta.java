package model;

import Interfaces.Combustible;
import Interfaces.Mantenimiento;

public class Motocicleta extends Vehiculo implements Combustible, Mantenimiento {
    private int cilindrada;
    private double nivelCombustible;

    public Motocicleta(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
        this.nivelCombustible = 20.0; // Este es el tanque inicial de 20 litros
    }

    @Override
    public void mover() {
        if (nivelCombustible > 0) {
            System.out.println("La motocicleta " + marca + " " + modelo + " está acelerando con " + cilindrada + " cc.");
            nivelCombustible -= 0.3;
        } else {
            System.out.println("La motocicleta " + marca + " " + modelo + " no tiene combustible.");
        }
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Cilindrada: " + cilindrada + " cc, Combustible: " + nivelCombustible + " litros";
    }

    @Override
    public void recargarCombustible() {
        nivelCombustible = 20.0;
        System.out.println("La motocicleta " + marca + " " + modelo + " ha sido recargada con combustible.");
    }

    @Override
    public double obtenerNivelCombustible() {
        return nivelCombustible;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Cambiando aceite de la motocicleta " + marca + " " + modelo);
    }
}