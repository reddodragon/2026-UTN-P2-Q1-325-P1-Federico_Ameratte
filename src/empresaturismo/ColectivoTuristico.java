
package empresaturismo;


public class ColectivoTuristico extends Vehiculo {
    
    public int cantidadPisos;
    
    
    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos){
        
        super(patente, marca, capacidadPasajeros, anioFabricacion);
                
        this.cantidadPisos = cantidadPisos;
    }
    
    public int getCantidadPisos(){
        return cantidadPisos;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Colectivo Turistico");
        System.out.println("Patente: " + getPatente());
        System.out.println("marca: " + getMarca());
        System.out.println("Capacidad de Pasajeros: " + getCapacidadPasajeros());
        System.out.println("Anio de Fabricacion: " + getAnioFabricacion());
                System.out.println("Cantidad de Pisos: " + getCantidadPisos());
        System.out.println("----------------------------------");
    }
    
    
    @Override
    
    public void realizarServicio(){
        System.out.println("El colectivo Turistico " + getPatente() + " Realiza una excursion");
        
    }
}
