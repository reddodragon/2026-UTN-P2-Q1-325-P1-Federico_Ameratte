package empresaturismo;

import java.util.ArrayList;

public class EmpresaTurismo {

    private ArrayList<Vehiculo> vehiculos;

    public EmpresaTurismo() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            System.out.println("Ya existe un vehiculo con esa patente.");
        } else {
            vehiculos.add(vehiculo);
            System.out.println("Vehiculo agregado correctamente.");
        }
    }

    public void mostrarVehiculo() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }

    public void realizarServicio() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.realizarServicio();
        }
    }

    public Vehiculo buscarPorPatente(String patente) {

        patente = patente.trim();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().trim().equalsIgnoreCase(patente)) {
                return vehiculo;
            }
        }

        return null;
    }

    public void mostrarBusquedaPatente(String patente) {

        Vehiculo encontrado = buscarPorPatente(patente);

        if (encontrado == null) {
            System.out.println("No se encontro un vehiculo con esa patente.");
        } else {
            System.out.println("Vehiculo encontrado:");
            encontrado.mostrarInformacion();
        }
    }

    public void mostrarCapacidadMayor(int valor) {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos ingresados.");
            return;
        }

        boolean encontro = false;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCapacidadPasajeros() > valor) {
                vehiculo.mostrarInformacion();
                encontro = true;
            }
        }

        if (!encontro) {
            System.out.println("No hay vehiculos con capacidad mayor a: " + valor);
        }
    }

    public void mostrarOrdenadosPorAnioDesc() {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos ingresados.");
            return;
        }

        ArrayList<Vehiculo> copia = copiarLista();

        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {

                if (copia.get(j).getAnioFabricacion() < copia.get(j + 1).getAnioFabricacion()) {
                    Vehiculo aux = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, aux);
                }
            }
        }

        for (Vehiculo vehiculo : copia) {
            vehiculo.mostrarInformacion();
        }
    }

    public void mostrarOrdenadoPorCapacidadDesc() {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos ingresados.");
            return;
        }

        ArrayList<Vehiculo> copia = copiarLista();

        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {

                if (copia.get(j).getCapacidadPasajeros() < copia.get(j + 1).getCapacidadPasajeros()) {
                    Vehiculo aux = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, aux);
                }
            }
        }
        
       
        for (Vehiculo vehiculo : copia) {
            vehiculo.mostrarInformacion();
        }
    }

    public ArrayList<Vehiculo> copiarLista() {

        ArrayList<Vehiculo> copia = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculos) {
            copia.add(vehiculo);
        }

        return copia;
    }
}