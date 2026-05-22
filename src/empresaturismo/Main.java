
package empresaturismo;

import java.util.Scanner;
public class Main {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        EmpresaTurismo empresa = new EmpresaTurismo();

        int opcion = 0;

        while (opcion != 8) {

            System.out.println("===== SISTEMA DE EXPEDICIONES ESPACIALES =====");
            System.out.println("1. Agregar Vehiculo");
            System.out.println("2. Mostrar Todos los vehiculos");
            System.out.println("3. realizar Servicio Turistico");
            System.out.println("4. Buscar Vehiculo por Patente");
            System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor ingresado");
            System.out.println("6. Mostrar vehiculos ordenados por anioo de fabricacion descendente");
            System.out.println("7. Mostrar vehiculos ordenados por capacidad de pasajeros descendente");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    agregarVehiculo(sc, empresa);
                    break;

                case 2:
                    empresa.mostraVehiculo();
                    break;

                case 3:
                    empresa.realizarServicio();
                    break;

                case 4:
                    buscarVehiculo(sc, empresa);
                    break;

                case 5:
                    mostrarCapacidad(sc, empresa);
                    break;

                case 6:
                    empresa.mostrarOrdenadosPorAnioDesc();
                    break;
                    
                case 7:
                    empresa.mostrarOrdenadoPorCapacidadDesc();
                    break;
                    
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            System.out.println();
        }

        sc.close();
    }
    
    public static void agregarVehiculo(Scanner sc, EmpresaTurismo empresa){
        
        System.out.println("Selecciona un tipo de vehículo:");
        System.out.println("1. Colectivo Turistico");
        System.out.println("2. Van Ejecutiva");
        System.out.println("3. Lancha Turistica");
        System.out.print("Tipo: ");
        
        int tipo = leerEntero(sc);
        
        if( tipo < 1 || tipo > 3 ){
            System.out.println("Tipo invalido");
            return;
        }
        
        String patente = leerTexto(sc, "Patente");
        String marca = leerTexto(sc, "Marca");
        
        int capacidadPasajeros = leerEntero(sc);
        
        if(capacidadPasajeros <= 0){
            System.out.println("La capacidad de pasajeros debe ser mayor a 0");
            return;
        }
        
        int anioFabricacion = leerAnioFabricacion(sc);
        
        switch (tipo) {
            
            case 1: 
                agregarColectivo(sc, empresa, patente, marca, capacidadPasajeros, anioFabricacion);
                break;
            
            case 2:
                agregarVan(sc, empresa, patente, marca, capacidadPasajeros, anioFabricacion);
                break;
            
            case 3:
                agregarLancha(sc, empresa, patente, marca, capacidadPasajeros, anioFabricacion);
                
        }
            
    }
    
    public static void agregarColectivo(Scanner sc, EmpresaTurismo empresa, String patente, String marca, int capacidadPasajeros, int anioFabricacion){
        
        System.out.println("Cantidad de pisos (1 o 2): ");
        int cantidadPisos = leerEntero(sc);
        
        if ( cantidadPisos != 1 && cantidadPisos != 2 ){
            System.out.println("La cantidad de pisos solo puede ser 1 o 2. ");
            return;
        }
        
        ColectivoTuristico colectivo = new ColectivoTuristico(patente, marca, capacidadPasajeros, anioFabricacion, cantidadPisos );
        
        empresa.agregarVehiculo(colectivo);
        
    }
        
    public static void agregarVan (Scanner sc, EmpresaTurismo empresa, String patente, String marca, int capacidadPasajeros, int anioFabricacion){
        
        System.out.println("Tiene aire acondicionado?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        System.out.print("Opcion: ");
        
        int opcionAire = leerEntero(sc);
        boolean aireAcondicionado;
        
        if ( opcionAire == 1 ){
            aireAcondicionado = true;
        } else if (opcionAire == 2){
            aireAcondicionado = false;
        }else {
            System.out.println("Opcion invalida");
            return;
        }
        
        VanEjecutiva van  = new VanEjecutiva(patente, marca, capacidadPasajeros, anioFabricacion, aireAcondicionado );
        
        empresa.agregarVehiculo(van);
        
    }
    
    public static void agregarLancha(Scanner sc, EmpresaTurismo empresa, String patente, String marca, int capacidadPasajeros, int anioFabricacion){
        
        String tipoMotor = elegirTipoMotor(sc);
        
        if(tipoMotor.isEmpty()){
            return;
        }
               
        
        LanchaTuristica lancha = new LanchaTuristica(patente, marca, capacidadPasajeros, anioFabricacion, tipoMotor );
        
        empresa.agregarVehiculo(lancha);
        
    }
    
    
    public static void buscarVehiculo(Scanner sc, EmpresaTurismo empresa){
        
        String patente = leerTexto(sc, "Ingrese patente a buscar");
        
        empresa.mostrarBusquedaPatente(patente);
        
    }
    
    public static void mostrarCapacidad (Scanner sc, EmpresaTurismo empresa){
        
        System.out.println("Ingrese Capacidad minima: ");
        int valor = leerEntero(sc);
        
        if(valor < 0 ){
            System.out.println("La capacidad minima no puede ser menor a 0");
            return;
        }
        
        empresa.mostrarCapacidadMayor(valor);
    }
    
    
    
    public static String elegirTipoMotor(Scanner sc){
    
        System.out.println("Seleccione el tipo de motor de la lancha: ");
        System.out.println("1. NAFTA");
        System.out.println("2. DIESEL");
        System.out.println("3. ELECTRICO");
        System.out.print("Opcion:  ");
        
        int opcion = leerEntero(sc);
        
        if(opcion == 1){
            return "NAFTA";
        }else if(opcion == 2) {
            return "DIESEL";
        }else if(opcion == 3) {
            return "ELECTRICO";
        }else{
            System.out.println("Tipo de motor invalido");
            return "";
        }
    
    }
    
    public static int leerAnioFabricacion (Scanner sc){
    
        int anioActual = 2026;
        
        System.out.print("Anio de Fabricacion: ");
        int anio = leerEntero(sc);
        
        while(anio < 1990 || anio > anioActual){
            
            System.out.println("Anio invalido, debe estar entre 1990 y " + anioActual);
            System.out.println("Anio de Fabricacion: ");
            anio = leerEntero(sc);
                
        }
        return anio;
    }
    
    public static String leerTexto(Scanner sc, String mensaje){
    
        System.out.println(mensaje);
        String texto = sc.nextLine();
        
        while (texto.isEmpty()){
            System.out.println("El texto no puede estar vacío");
            System.out.println(mensaje);
            texto = sc.nextLine();
        }
        
        return texto;
    }
    
    public static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Ingrese un numero valido.");
            sc.nextLine();
            System.out.print("Ingrese nuevamente: ");
        }

        int numero = sc.nextInt();
        sc.nextLine();

        return numero;
    }

}
