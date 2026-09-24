import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        //Menú interactivo
        Scanner sc = new Scanner(System.in);

        Supermercado supermercado= new Supermercado("MarketPlus", "Carrera 18", 314678);

        int opcion;
        do{
            System.out.println("----Menú MARKETPLUS----");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Agregar producto");
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
                    //Agregar una decision para terminar el sistema con el documento
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

                case 3:
                    System.out.println("Actualizando cliente...");

                    System.out.print("Introduzca el documento del cliente a actualizar: ");
                    int documentoBusqueda= sc.nextInt();

                    System.out.print("Introduzca el nuevo número de documento del cliente: ");
                    int documentoActualizado = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introduzca el nuevo nombre del cliente: ");
                    String nuevoNombre= sc.nextLine();

                    System.out.print("Introduzca el nuevo teléfono del cliente: ");
                    int nuevoTelefono = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introduzca el nuevo correo del cliente: ");
                    String nuevoCorreo = sc.nextLine();

                    Clientes clientesActualizado= new Clientes (nuevoNombre, documentoActualizado, nuevoTelefono, nuevoCorreo);

                    if(supermercado.actualizarCliente (documentoBusqueda, clientesActualizado)){
                        System.out.println("Cliente actualizado correctamente.");
                    }else{
                        System.out.println("Cliente no encontrado");
                    }
                    break;


                case 4:
                    System.out.println("Agregando producto...");

                    System.out.print("Introduzca el código del producto: ");
                    int codigoProducto = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Introduzca el nombre del producto: ");
                    String nombreProducto = sc.nextLine();

                    System.out.print("Introduzca el precio por unidad del producto: ");
                    int precioUnitario = sc.nextInt();

                    System.out.print("Introduzca la cantidad de productos disponibles: ");
                    int cantidadProductos = sc.nextInt();

                    System.out.print("Escoja el tipo de producto (1. Alimento - 2. Bebida - 3. Producto de aseo - 4. Cuidado personal): ");
                    int opcionProducto = sc.nextInt();
                    Categoria tipoProducto= null;

                    if (opcionProducto == 1){
                        tipoProducto= Categoria.ALIMENTO;
                    } else if (opcionProducto == 2){
                        tipoProducto= Categoria.BEBIDA;
                    } else if (opcionProducto == 3) {
                        tipoProducto= Categoria.PRODUCTO_ASEO;
                    } else if (opcionProducto == 4){
                        tipoProducto= Categoria.CUIDADO_PERSONAL;
                    } else {
                        System.out.println("Tipo de producto invalido.");
                        //break;?
                    }

                    if (tipoProducto != null){
                        Producto producto = new Producto(codigoProducto, nombreProducto, precioUnitario, cantidadProductos, tipoProducto);
                        if (supermercado.agregarProducto(producto)){
                            System.out.println("Producto agregado correctamente: "+ producto.getNombreProducto()+", "+producto.getCodigoProducto()+", "+producto.getCategoria());
                        } else{
                            System.out.println("Este producto ya existe.");
                        }
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
