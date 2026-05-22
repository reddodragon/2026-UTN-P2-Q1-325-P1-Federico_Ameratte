

package empresaturismo;


public class LanchaTuristica extends Vehiculo {
    
    public String tipoMotor;
    
    
    public LanchaTuristica(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoMotor){
        
        super(patente, marca, capacidadPasajeros, anioFabricacion);
                
        this.tipoMotor = tipoMotor;
    }
    
    public String getTipoMotor(){
        return tipoMotor;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Colectivo Turistico");
        System.out.println("Patente: " + getPatente());
        System.out.println("marca: " + getMarca());
        System.out.println("Capacidad de Pasajeros: " + getCapacidadPasajeros());
        System.out.println("Anio de Fabricacion: " + getAnioFabricacion());
        System.out.println("Tipo de motor: " + getTipoMotor());
        System.out.println("----------------------------------");
    }
    
    
    @Override
    
    public void realizarServicio(){
        System.out.println("La Lancha Turistica " + getPatente() + "Realiza un paseo");
        
    }
}
