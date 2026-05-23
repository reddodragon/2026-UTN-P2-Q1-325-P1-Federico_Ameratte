package empresaturismo;


public class VanEjecutiva extends Vehiculo {
    
    public boolean aireAcondicionado;
    
    
    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado){
        
        super(patente, marca, capacidadPasajeros, anioFabricacion);
                
        this.aireAcondicionado = aireAcondicionado;
    }
    
    public boolean getAireacondicionado(){
        return aireAcondicionado;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Colectivo Turistico");
        System.out.println("Patente: " + getPatente());
        System.out.println("marca: " + getMarca());
        System.out.println("Capacidad de Pasajeros: " + getCapacidadPasajeros());
        System.out.println("Anio de Fabricacion: " + getAnioFabricacion());
        if (aireAcondicionado){
            System.out.println("Cuenta con Aire Acondicionado: SI");
        }else{
           System.out.println("Cuenta con Aire Acondicionado: NO"); 
        }
        System.out.println("----------------------------------");
    }
    
    
    @Override
    
    public void realizarServicio(){
        System.out.println("La Van Ejecutiva " + getPatente() + " Realiza un translado");
        
    }
}
