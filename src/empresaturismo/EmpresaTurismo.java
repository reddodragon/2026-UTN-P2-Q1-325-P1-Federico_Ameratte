
package empresaturismo;

import java.util.ArrayList;

public class EmpresaTurismo {
    
    private ArrayList<Vehiculo> vehiculos;

    public EmpresaTurismo() {
        vehiculos = new ArrayList<>();
    }
    
        public void agregarNave(Vehiculo nave) {
        if (vehiculos.contains(nave)) {
            System.out.println("Ya existe una nave con ese nombre y anio de lanzamiento.");
        } else {
            vehiculos.add(nave);
            System.out.println("Nave agregada correctamente.");
        }
    }

    public void mostrarNaves() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay naves registradas.");
        } else {
            for (Vehiculo vehiculo : vehiculos) {
                vehiculo.mostrarInformacion();
            }
        }
    }
    
}
