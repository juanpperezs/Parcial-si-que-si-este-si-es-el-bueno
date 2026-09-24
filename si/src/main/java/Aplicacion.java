import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
                    sc.nextLine();
                    //Condición para terminar si se crea un nuevo usuario con igual documento ya registrado
                    if (supermercado.verificarClientes(documento)){
                        System.out.println("El documento ingresado ya está registrado en otro cliente.");
                        System.out.println("No se puede crear. Use otro documento o actualice la información desde la opción 3.");
                        break;
                    }

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

                    //Condición para determinar si el usuario a actualizar existe
                    Clientes clienteExistente= supermercado.buscarCliente(documentoBusqueda);
                    if (clienteExistente== null){
                        System.out.println("Este cliente no existe.");
                        break;
                    }
                    System.out.println("Cliente encontrado.");

                    System.out.print("Introduzca el nuevo número de documento del cliente: ");
                    int documentoActualizado = sc.nextInt();
                    sc.nextLine();

                    //Condición para determinar si el nuevo documento ya está en uso por otro cliente
                    if (documentoActualizado!= documentoBusqueda && supermercado.verificarClientes(documentoActualizado)){
                        System.out.println("El documento ingresado ya está asociado a otro cliente.");
                        break;
                    }

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
                    sc.nextLine();

                    Producto existente= supermercado.buscarProducto(codigoBusqueda);
                    if (existente == null){
                        System.out.println("Producto no encontrado con el código: "+codigoBusqueda);
                        break;
                    }

                    System.out.println("Producto sin actualizar: "+existente.getNombreProducto()+", precio: "+existente.getPrecioUnitario()+", unidades disponibles: "+existente.getCantidadDisponible());

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
                        break;
                    }

                    Producto productoActualizado= new Producto(codigoBusqueda, nuevoNombreProducto, nuevoPrecio, nuevaCantidad, tipoProductoActualizado);

                    if (supermercado.actualizarProducto(codigoBusqueda, productoActualizado)){
                        System.out.println("Producto actualizado correctamente.");
                    } else {
                        System.out.println("No se pudo actualizar.");
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
                    for(Producto productoLista: supermercado.getListaProductos()){
                        System.out.println(productoLista);
                    }
                        break;
                case 10:
                    System.out.println("Mostrando productos por categoria...");

                    System.out.print("Ingrese que categoría desea inspeccionar (1.ALIMENTO, 2.BEBIDA, 3.PRODUCTO DE ASEO, 4.CUIDADO PERSONAL): ");
                    int opcionCategoria = sc.nextInt();
                    sc.nextLine();

                    Categoria categoria= null;
                    if (opcionCategoria == 1){
                        categoria= Categoria.ALIMENTO;
                    } else if (opcionCategoria == 2){
                        categoria= Categoria.BEBIDA;
                    } else if (opcionCategoria == 3) {
                        categoria= Categoria.PRODUCTO_ASEO;
                    } else if (opcionCategoria == 4){
                        categoria= Categoria.CUIDADO_PERSONAL;
                    } else {
                        System.out.println("Tipo de producto invalido.");
                    }

                    List<Producto> productosFiltrados= supermercado.getProductosPorCategoria(categoria);

                    System.out.println("\n--- Productos en la categoria: "+categoria+"---");
                    if (productosFiltrados.isEmpty()){
                        System.out.println("No hay productos en la categoria: "+categoria);
                    }else{
                        for (Producto producto: productosFiltrados){
                            System.out.println("Codigo: "+producto.getCodigoProducto()+
                                                "\nNombre: "+producto.getNombreProducto()+
                                                "\nPrecio: "+producto.getPrecioUnitario()+
                                                "\nStock: "+producto.getCantidadDisponible());
                        }
                    }
                    break;

                case 11:
                    System.out.println("Creando compra...");


                    int codigoCompra = 1 + (int)(Math.random() * 100);
                    System.out.println("Código de compra asignado: " + codigoCompra);

                    System.out.print("Introduzca la fecha de realizacion (AAAA-MM-DD): ");
                    LocalDate fechaRealizacion = LocalDate.parse(sc.nextLine());

                    System.out.print("Escoja el metodo de pago (1. Tarjeta - 2. Transferencia - 3. Efectivo): ");
                    int opcionCompras = sc.nextInt();
                    sc.nextLine();

                    MetodoPago metodoPago = null;
                    if (opcionCompras == 1) {
                        metodoPago = MetodoPago.TARJETA;
                    } else if (opcionCompras == 2) {
                        metodoPago = MetodoPago.TRANSFERENCIA;
                    } else if (opcionCompras == 3) {
                        metodoPago = MetodoPago.EFECTIVO;
                    } else {
                        System.out.println("Método de pago inválido.");

                        System.out.print("Introduzca el nombre del producto comprado: ");
                        String productoComprado = sc.nextLine();

                        System.out.print("Introduzca el valor total: ");
                        int valorTotal = sc.nextInt();
                        sc.nextLine();

                        Compras compras = new Compras(codigoCompra, fechaRealizacion, metodoPago, productoComprado, valorTotal);

                        if (supermercado.agregarCompras(compras)) {
                            System.out.println("¡Compra agregada correctamente!");
                        } else {
                            System.out.println("Esta compra ya existe.");
                        }
                        break;
                    }

                case 12:
                    System.out.println("Agregando producto a compra existente...");

                    System.out.print("Introduzca el codigo de la compra existente: ");
                    int codigoCompraBuscada = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introduzca el codigo del producto que desea agregar: ");
                    int codigoProductoAgregado = sc.nextInt();
                    sc.nextLine();

                    if (supermercado.agregarProductoACompra(codigoCompraBuscada, codigoProductoAgregado)) {
                        System.out.println("¡Producto agregado a la compra exitosamente!");
                    } else {
                        System.out.println("No se encontro la compra o el producto no es valido.");
                    }
                    break;

                case 13:
                    System.out.println("Confirmando compra...");

                    System.out.println("Ingrese el código de producto a confirmar");
                    int codigoConfirmacion = sc.nextInt();

                    System.out.println("Ingrese el código de la compra");
                    int codigoCompraConfirmado = sc.nextInt();

                    System.out.println("Ingrese la cantidad a comprar");
                    int cantidadDeseada = sc.nextInt();
                    sc.nextLine();

                    System.out.println("¿Desea confirmar la compra? (S/N): ");
                    String confirmacion = sc.nextLine();

                    if (confirmacion.equalsIgnoreCase("s")) {
                        boolean esConfirmada = supermercado.confirmarCompra(codigoConfirmacion, codigoCompraConfirmado, cantidadDeseada);

                        if (esConfirmada == true) {
                            System.out.println("¡Compra confirmada e inventario actualizado con éxito!");
                        } else {
                            System.out.println("No se pudo procesar la compra (verifique códigos o stock insuficiente).");
                        }
                    } else {
                        System.out.println("Compra cancelada por el usuario.");
                    }
                    break;

                case 14:
                    System.out.println("------Mostrar todas las compras------");
                    for(Compras comprasLista: supermercado.getListaCompras()){
                        System.out.println(comprasLista);
                    }
                    break;

                case 15:
                    System.out.println("--- Ver Detalles de Compra ---");
                    System.out.println("Ingrese el código de la compra: ");
                    int codigoDetallesCompra = sc.nextInt();
                    sc.nextLine();

                    Compras compraMostrada = supermercado.verDetalleCompra(codigoDetallesCompra);

                    System.out.println("Código: " + compraMostrada.getCodigoCompra());
                    System.out.println("Fecha: " + compraMostrada.getFechaRealizacion());
                    System.out.println("Método de Pago: " + compraMostrada.getMetodoPago());
                    System.out.println("Valor Total: " + compraMostrada.getValorTotal());
                    break;

                case 16:
                    System.out.println("Mostrando todas las compras desde una fecha...");

                    System.out.println("Introduzca la fecha de realizacion (AAAA-MM-DD): ");
                    LocalDate fechaConsulta = LocalDate.parse(sc.nextLine());

                    int totalVendido= supermercado.valorAcumuladoPorFecha(fechaConsulta);

                    System.out.println("El total vendido en esa fecha es: " + totalVendido);

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