package app;

import Interfaces.Combustible;
import Interfaces.Mantenimiento;
import model.Automovil;
import model.Bicicleta;
import model.Motocicleta;
import model.Vehiculo;

public class SistemaVehiculos {
    public static void main(String[] args) {
        //crear instancias de vehículos
        Vehiculo auto = new Automovil("Toyota", "Corolla", 2020, 40.0);
        Vehiculo bici = new Bicicleta("Trek", "Mountain", 2022, 21);
        Vehiculo moto = new Motocicleta("Honda", "CBR", 2023, 600);

        //probar polimorfismo básico
        System.out.println("=== Pruebas individuales ===");
        auto.mover();
        System.out.println(auto.obtenerDetalles());
        ((Combustible) auto).recargarCombustible();
        System.out.println("Nivel de combustible: " + ((Combustible) auto).obtenerNivelCombustible());

        bici.mover();
        System.out.println(bici.obtenerDetalles());

        moto.mover();
        System.out.println(moto.obtenerDetalles());
        ((Combustible) moto).recargarCombustible();

        //probar mantenimiento
        System.out.println("\n=== Pruebas de mantenimiento ===");
        ((Mantenimiento) auto).realizarMantenimiento();
        ((Mantenimiento) moto).realizarMantenimiento();

        //probar polimorfismo avanzado
        System.out.println("\n=== Pruebas con arreglo polimórfico ===");
        Vehiculo[] vehiculos = {auto, bici, moto};
        procesarVehiculos(vehiculos);
    }

    //metodo para procesar vehículos usando polimorfismo
    public static void procesarVehiculos(Vehiculo[] vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("\n--- Procesando vehículo ---");
            vehiculo.mover();
            System.out.println(vehiculo.obtenerDetalles());

            if (vehiculo instanceof Combustible) {
                Combustible combustibleVehiculo = (Combustible) vehiculo;
                System.out.println("Nivel de combustible: " + combustibleVehiculo.obtenerNivelCombustible());
                combustibleVehiculo.recargarCombustible();
            }

            if (vehiculo instanceof Mantenimiento) {
                Mantenimiento mantenimientoVehiculo = (Mantenimiento) vehiculo;
                mantenimientoVehiculo.realizarMantenimiento();
            }
        }
    }
}