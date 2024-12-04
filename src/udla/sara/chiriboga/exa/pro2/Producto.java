package udla.sara.chiriboga.exa.pro2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.List;

abstract public class Producto {
    private String codigo;
    private String nombre; //atributos
    private double precio;
    private int cantidad;
    private String tipo;
    private String InfExtra;
    private List<Producto> productos = new ArrayList<>();

    public Producto(String codigo, String nombre, double precio, int cantidad, String tipo, String infExtra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
        InfExtra = infExtra;
    } //constructor

    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector

    //GETTERS Y SETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public int getCantidad(){return cantidad;}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInfExtra() {
        return InfExtra;
    }

    public void setInfExtra(String infExtra) {
        InfExtra = infExtra;
    }

    //METODOS PROPIOS
    public void reducirCantidad(int cantidadVendida){ //reducir cantidad en stock
        setCantidad(cantidad - cantidadVendida);
    }

    public void addProducto(Producto producto) throws IOException { //agregar productos al stock
        boolean repeat = true;
        while (repeat){
            System.out.println("Nombre del producto: ");
            producto.setNombre(sc.readLine());
            System.out.println("Codigo: ");
            producto.setCodigo(sc.readLine());
            System.out.println("Precio por unidad: ");
            producto.setPrecio(Double.parseDouble(sc.readLine()));
            System.out.println("Cantidad: ");
            producto.setCantidad(Integer.parseInt(sc.readLine()));
            System.out.printf("Tipo: (1. Ropa - 2. Calzado - 3. Accesorios)\nRespuesta: ");
            int type = Integer.parseInt(sc.readLine());
            if (type == 1){
                Ropa ropa = new Ropa(null ,null ,0, 0, null, null);
                producto.setTipo("Ropa");
                System.out.printf("Talla: ");
                ropa.setTalla(sc.readLine());
                producto.setInfExtra(ropa.getTalla());
            } else if (type == 2) {
                Calzado calzado = new Calzado(null, null, 0, 0, null, null);
                producto.setTipo("Calzado");
                System.out.printf("Numero: ");
                calzado.setNumero(Integer.parseInt(sc.readLine()));
                producto.setInfExtra(String.valueOf(calzado.getNumero()));
            }else {
                Acccesorio accesorio = new Acccesorio(null, null, 0, 0 , null, null);
                producto.setTipo("Accesorio");
                System.out.printf("Tipo: ");
                accesorio.setTipo(sc.readLine());
                producto.setInfExtra(accesorio.getTipo());
            }
            Ropa nuevo = new Ropa(producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCantidad(), producto.getTipo(), producto.getInfExtra());
            productos.add(nuevo);
            System.out.println("Producto agregado con éxito!");

            System.out.println("Desea agregar un nuevo producto?: 1. SI - 2. NO");
            int siono = Integer.parseInt(sc.readLine());
            if (siono == 2){break;}
        }
    }

    public void deleteProducto() throws IOException { //eliminar productos del stock
        System.out.printf("Codigo del producto: ");
        String delete = sc.readLine();

        for (Producto producto : productos){
            if (producto.getCodigo().equals(delete)){
                productos.remove(producto);
            }
        }
    }

    public void editProducto() throws IOException { //editar productos en stock
        System.out.printf("Codigo del producto: ");
        String edit = sc.readLine();

        for(Producto producto : productos){
            if (producto.getCodigo().equals(edit)){
                System.out.println("Se encuentra actualizando información sobre **" + producto.getNombre() + "**");
                System.out.println("Nombre del producto: ");
                producto.setNombre(sc.readLine());
                System.out.println("Codigo: ");
                producto.setCodigo(sc.readLine());
                System.out.println("Precio por unidad: ");
                producto.setPrecio(Double.parseDouble(sc.readLine()));
                System.out.println("Cantidad: ");
                producto.setCantidad(Integer.parseInt(sc.readLine()));
                System.out.printf("Tipo: (1. Ropa - 2. Calzado - 3. Accesorios)\nRespuesta: ");
                int type = Integer.parseInt(sc.readLine());
                if (type == 1){
                    Ropa ropa = new Ropa(null ,null ,0, 0, null, null);
                    producto.setTipo("Ropa");
                    System.out.printf("Talla: ");
                    ropa.setTalla(sc.readLine());
                    producto.setInfExtra(ropa.getTalla());
                } else if (type == 2) {
                    Calzado calzado = new Calzado(null, null, 0, 0, null, null);
                    producto.setTipo("Calzado");
                    System.out.printf("Numero: ");
                    calzado.setNumero(Integer.parseInt(sc.readLine()));
                    producto.setInfExtra(String.valueOf(calzado.getNumero()));
                }else {
                    Acccesorio accesorio = new Acccesorio(null, null, 0, 0 , null, null);
                    producto.setTipo("Accesorio");
                    System.out.printf("Tipo: ");
                    accesorio.setTipo(sc.readLine());
                    producto.setInfExtra(accesorio.getTipo());
                }
            }
        }
    }

    public void printProductos(){ //impresión de stock
        System.out.println("Nombre\tCodigo\tPrecio c/u\tCantidad\tTipo\tInformación");
        for (Producto producto : productos){
            System.out.println(producto.getNombre() + "\t" + producto.getCodigo() + "\t" + producto.getPrecio() + "\t" + producto.getPrecio() + "\t" + producto.getCantidad() + "\t" + producto.getTipo() + "\t" + producto.getInfExtra());
        }
    }

    public abstract void iEmpleado(); //implementación de metodo abstracto
}
