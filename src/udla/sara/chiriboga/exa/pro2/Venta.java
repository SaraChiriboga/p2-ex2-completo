package udla.sara.chiriboga.exa.pro2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String id; //atributos
    private String fecha;
    private Empleado empleado = new Empleado(null, null, 0, null) {
        @Override
        public void iEmpleado() {

        }
    }; //acceso a empleado
    private List<Producto> productosVendidos = new ArrayList<>();
    private List<String> ventas = new ArrayList<>(); //almacenamiento de historial
    private double total;

    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector

    //metodos getter y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    //METODO PROPIOS
    public void agregarProdducto(Producto producto, int cantidad){ //metodo para agregar productos a una venta
        producto.setCantidad(cantidad);
        productosVendidos.add(producto);
    }

    public double getTotal(){ //total de venta
        double sumaTotal = 0;
        for (Producto producto : productosVendidos){
            sumaTotal = sumaTotal + producto.getPrecio();
        }
        return sumaTotal;
    }

    public String facturar() throws IOException { //en caso de que se quiera facturar
        System.out.println("Nombre: ");
        String nombre = sc.readLine();
        System.out.println("ID: ");
        String id = sc.readLine();
        return nombre + "\t" + id;
    }

    public void iniciarVenta() throws IOException { //crear una venta
        boolean repeat = true;
        Ropa venta = new Ropa(null, null, 0 ,0 ,null, null);

        //registro de productos
        while (repeat){
            System.out.println("Nombre del producto: ");
            venta.setNombre(sc.readLine());
            System.out.println("Codigo:");
            venta.setCodigo(sc.readLine());
            System.out.println("Precio por unidad: ");
            venta.setPrecio(Double.parseDouble(sc.readLine()));
            System.out.println("Cantidad: ");
            venta.setCantidad(Integer.parseInt(sc.readLine()));

            venta.setPrecio(venta.getPrecio() * venta.getCantidad());

            Ropa nuevo = new Ropa(venta.getCodigo(), venta.getNombre(), venta.getPrecio() ,venta.getCantidad() ,null, null);
            agregarProdducto(nuevo, venta.getCantidad());

            System.out.println("Agregar?: 1. SI - 2. NO");
            int siono = Integer.parseInt(sc.readLine());
            if (siono == 2){
                break;
            }
        }

        //calculo de total
        total = getTotal();
        System.out.println("Total: " + total);

        //facturación?
        System.out.println("Datos de facturación: 1. SI - 2. NO");
        String datos;
        int facturacion = Integer.parseInt(sc.readLine());
        if (facturacion == 1){
            datos = facturar();
        }else {datos = "Consumidor final \t 99999999999";}

        //quien hizo la venta? SE ASUME QUE UN VENDEDOR
        Vendedor vendedor = new Vendedor(null,null,0, null);
        vendedor.setComision(getTotal());
        double comisionganada = vendedor.getComision();
        System.out.println("Iniciales del empleado: ");
        String emp = sc.readLine();
        empleado.setNombre(emp);
        System.out.println("Fecha de venta: ");
        setFecha(sc.readLine());

        //confirmacion de venta
        System.out.println("Confirma esta venta?: 1. SI - 2.NO");
        int confi = Integer.parseInt(sc.readLine());
        if (confi == 1){
            System.out.println("ID de la compra: ");
            setId(sc.readLine());
            StringBuilder sb = new StringBuilder();
            String ventaconfirmada = String.valueOf(sb.append(getId()).append("\t").append(total).append("\t").append(datos).append("\t").append(empleado.getNombre()).append("\t").append(getFecha()).append("\t").append(comisionganada));
            ventas.add(ventaconfirmada);
            System.out.println("Venta confirmada!");
            productosVendidos.clear(); //evitar sumas de compras independientes
        }

    }

    public void printVentas(){ //imprimir historial de ventas
        ventas.forEach(System.out::println);
    }
}
