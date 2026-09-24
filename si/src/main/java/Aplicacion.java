import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        //Menú interactivo
        Scanner sc = new Scanner(System.in);

        Supermercado supermercado= new Supermercado("MarketPlus", "Carrera 18", 314678);

        int opcion;
        do{
            System.out.println("----Menú MARKETPLUS----");
            System.out.println("1. Agregar cliente: ");
            System.out.println("2. Eliminar cliente:");

            System.out.println("0. salir.");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Agregando cliente...");

                    System.out.print("Introduzca el nombre completo: ");
                    String nombreCompleto = sc.nextLine();

                    System.out.print("Introduzca el documento de identidad: ");
                    int documento = sc.nextInt();

                    System.out.print("Introduzca el número de teléfono: ");
                    int telefono = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Introduzca el correo electrónico: ");
                    String correo = sc.nextLine();

                    Clientes cliente = new Clientes(nombreCompleto, documento, telefono, correo);

                    if (supermercado.agregarClientes(cliente)){
                        System.out.println("Cliente agregado correctamente: "+ cliente.getNombreCompleto()+", "+ cliente.getDocumentoIdentidad());
                    } else{
                        System.out.println("Este cliente ya existe.");
                    }
                    break;

                case 2:
                    System.out.println("Eliminando cliente...");

                    System.out.print("Introduzca el documento del cliente a eliminar: ");
                    int documentoIdentidad = sc.nextInt();

                    if (supermercado.eliminarCliente(documentoIdentidad)){
                        System.out.println("Cliente con número de documento: "+documentoIdentidad+" fue eliminado correctamente. " );
                    } else{
                        System.out.println("Este cliente no existe.");
                    }
                    break;

                case 0:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opción no válida...");
            }

        } while (opcion != 0);
        sc.close();
    }
}
