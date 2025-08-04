//Autor: Fabricio Estrada 25230 est25230@uvg.edu.gt
//Historial de modificaciones --> 00 -- 27/07/25
//Programa: Ejercicio1 Boletos eras tour

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        localidad[] localidades = {
            new localidad("Localidad 1", 100),
            new localidad("Localidad 5", 500),
            new localidad("Localidad 10", 1000)
        };

        usuario comprador = null;
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Cantidad boletos: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Presupuesto: ");
                    double presupuesto = sc.nextDouble();
                    comprador = new usuario(nombre, email, cantidad, presupuesto);
                    System.out.println("Ticket generado: " + comprador.getTicket());
                    break;

                case 2:
                    if (comprador == null) {
                        System.out.println("Debe ingresar un comprador primero.");
                        break;
                    }
                    if (!comprador.validarID()) {
                        System.out.println("El ticket no fue aprobado para la compra.");
                        break;
                    }
                    int indice = random.nextInt(3);
                    localidad seleccionada = localidades[indice];
                    System.out.println("Se le asignó la localidad: " + seleccionada.getNombre());

                    if (!seleccionada.validar_espacio(comprador.getCantidadBoletos())) {
                        System.out.println("No hay suficiente espacio");
                    }

                    if (!seleccionada.validar_presupuesto(comprador.getPresupuesto())) {
                        System.out.println("Presupuesto insuficiente para esta localidad.");
                        break;
                    }

                    int vendidos = seleccionada.venderBoletos(comprador.getCantidadBoletos());
                    System.out.println("Boletos vendidos: " + vendidos);
                    break;

                case 3:
                    for (localidad loc : localidades) {
                        System.out.println(loc.getNombre() + ": Vendidos = " + loc.getBoletosVendidos() + ", Disponibles = " + loc.getEspacioDisponible());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese nombre de la localidad (1, 5 o 10): ");
                    String nombreLoc = sc.nextLine();
                    for (localidad loc : localidades) {
                        if (loc.getNombre().contains(nombreLoc)) {
                            System.out.println(loc.getNombre() + ": Disponibles = " + loc.getEspacioDisponible());
                        }
                    }
                    break;

                case 5:
                    double total = 0;
                    for (localidad loc : localidades) {
                        total += loc.getBoletosVendidos() * loc.getPrecio();
                    }
                    System.out.println("Total generado: $" + total);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
            }

        } while(opcion != 6);
    }
}
