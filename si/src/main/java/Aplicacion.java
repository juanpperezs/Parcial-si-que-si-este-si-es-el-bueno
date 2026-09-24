import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        //Menú interactivo
        Scanner sc = new Scanner(System.in);

        Supermercado supermercado= new Supermercado("MarketPlus", "Carrera 18", 314678);

        Clientes cliente1= new Clientes("Cesar Augusto", 10934,319717, "crisansi");
        supermercado.agregarClientes(cliente1);

        int opcion;
        do{
            System.out.println("----Menú MARKETPLUS----");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Consultar las compras de un cliente");

            System.out.println("-----------------------------------------");
            System.out.println("6. Agregar producto");
            System.out.println("7. Actualizar producto");
            System.out.println("8. Eliminar producto");
            System.out.println("9. Mostrar todos los productos");
            System.out.println("10. Mostrar productos por categorias");

            System.out.println("--------------------------------------");
            System.out.println("11. Crear nueva compra");
            System.out.println("12. Agregar producto a una compra existente");
            System.out.println("13. Confirmar compra");
            System.out.println("14. Mostrar todas las compras");
            System.out.println("15. Ver detalles de una compra");

            System.out.println("--------------------------------------");
            System.out.println("16. Consultar valor acumulado de una fecha específica");
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
                    System.out.println("------Mostrar todos los clientes------");
                    for(Clientes clientesLista: supermercado.getListaClientes()){
                        System.out.println(clientesLista);
                    }
                    break;

                case 5:
                    System.out.println("-----Consultar compras de clientes-----");

                    System.out.print("Ingrese el documento del cliente a consultar: ");
                    int documentoConsulta = sc.nextInt();
                    sc.nextLine();

                    Clientes clienteConsulta= supermercado.buscarCliente(documentoConsulta);

                    if (clienteConsulta == null){
                        System.out.print("Este cliente no existe... Agrégelo en la opción 1.");
                    } else if (clienteConsulta.getComprasRealizadas().isEmpty()){
                        System.out.println("El cliente "+clienteConsulta.getNombreCompleto()+" no tiene compras realizadas.");
                        System.out.print("¿Desea realizar una compra para este cliente? (Si/No): ");
                        String respuesta = sc.nextLine();
                        if (respuesta.equalsIgnoreCase("Si")){
                            System.out.println("Perfecto, en este caso puede realizar la compra en la opción 11");
                        } else if (respuesta.equalsIgnoreCase("No")){
                            break;
                        }
                    } else {
                        System.out.println("Compras de: "+clienteConsulta.getNombreCompleto());
                        for (Compras compras: clienteConsulta.getComprasRealizadas()){
                            System.out.println(compras);
                        }
                    }
                    break;

                case 6:
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
                case 7:
                    System.out.println("Actualizando producto...");

                    System.out.print("Introduzca el codigo de producto a actualizar: ");
                    int codigoBusqueda= sc.nextInt();

                    System.out.print("Introduzca el nuevo codigo del producto: ");
                    int codigoActualizado = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introduzca el nuevo nombre del producto: ");
                    String nuevoNombreProducto= sc.nextLine();

                    System.out.print("Introduzca el nuevo precio del producto: ");
                    int nuevoPrecio = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introduzca la nueva cantidad disponible del producto: ");
                    int nuevaCantidad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Escoja el tipo de producto (1. Alimento - 2. Bebida - 3. Producto de aseo - 4. Cuidado personal): ");
                    int opcionProductoActualizado = sc.nextInt();
                    Categoria tipoProductoActualizado= null;

                    if (opcionProductoActualizado == 1){
                        tipoProductoActualizado= Categoria.ALIMENTO;
                    } else if (opcionProductoActualizado == 2){
                        tipoProductoActualizado= Categoria.BEBIDA;
                    } else if (opcionProductoActualizado == 3) {
                        tipoProductoActualizado= Categoria.PRODUCTO_ASEO;
                    } else if (opcionProductoActualizado == 4){
                        tipoProductoActualizado= Categoria.CUIDADO_PERSONAL;
                    } else {
                        System.out.println("Tipo de producto invalido.");
                        //break;?
                    }
                    if (tipoProductoActualizado != null){
                        Producto producto = new Producto(codigoActualizado, nuevoNombreProducto, nuevoPrecio, nuevaCantidad, tipoProductoActualizado);
                        if (supermercado.agregarProducto(producto)){
                            System.out.println("Producto agregado correctamente: "+ producto.getNombreProducto()+", "+producto.getCodigoProducto()+", "+producto.getCategoria());
                        } else{
                            System.out.println("Este producto ya existe.");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Eliminando producto...");

                    System.out.print("Introduzca el codigo de producto a eliminar: ");
                    codigoProducto = sc.nextInt();

                    if (supermercado.eliminarProducto(codigoProducto)){
                        System.out.println("Producto con el codigo: "+codigoProducto+" fue eliminado correctamente. " );
                    } else{
                        System.out.println("Este producto no existe.");
                    }
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    System.out.println("------Mostrar todas las compras------");
                    for(Compras comprasLista: supermercado.getListaCompras()){
                        System.out.println(comprasLista);
                    }
                    break;
                case 15:
                    break;
                case 16:
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
