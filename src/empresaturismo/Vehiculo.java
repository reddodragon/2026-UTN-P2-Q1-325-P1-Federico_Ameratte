
package empresaturismo;


public abstract class Vehiculo {
    
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;
    
    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion){
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }
    
    public String getPatente(){
        return patente;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public int getCapacidadPasajeros(){
        return capacidadPasajeros;
    }
    
    public int getAnioFabricacion(){
        return anioFabricacion;
    }
    
    public abstract  void mostrarInformacion();
    
    public abstract void realizarServicio();
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehiculo) {
            Vehiculo otro = (Vehiculo) obj;
            return this.patente.equalsIgnoreCase(otro.patente);
        }

        return false;
    }
    
    @Override
    public int hashCode(){
        return patente.toLowerCase().hashCode();
    }
    
    
    
}
