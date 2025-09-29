package model;

import Interfaces.Combustible;
import Interfaces.Mantenimiento;

public class Automovil extends Vehiculo implements Combustible, Mantenimiento {
    private double nivelCombustible;

    public Automovil(String marca, String modelo, int anio, double nivelCombustible){
        super(marca, modelo, anio);
        this.nivelCombustible = nivelCombustible;
    }

    @Override
    public void mover(){
        if(this.nivelCombustible > 0){
            System.out.println("El automóvil " + marca + " " + modelo + " está conduciendo.");
            nivelCombustible -= 0.5;
        }else{
            System.out.println("El automóvil " + marca + " " + modelo + " no tiene combustible.");
        }
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Combustible: " + nivelCombustible + " litros";
    }

    @Override
    public void recargarCombustible() {
        nivelCombustible = 50.0;
        System.out.println("El automóvil " + marca + " " + modelo + " ha sido recargado con combustible.");
    }

    @Override
    public double obtenerNivelCombustible() {
        return nivelCombustible;
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Revisando motor del automóvil " + marca + " " + modelo);
    }
}