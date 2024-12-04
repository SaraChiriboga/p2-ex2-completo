package udla.sara.chiriboga.exa.pro2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        int op, op1; //declaracion de variables e instancias
        boolean iteracion = true;
        Venta local = new Venta();
        Producto producto1 = new Producto(null, null, 0, 0, null, null) {
            @Override
            public void iEmpleado() {

            }
        }; //uso de un metodo comun para acceder a clases abstracta
        Empleado empleado1 = new Empleado(null, null, 0, null) {
            @Override
            public void iEmpleado() {

            }
        };
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector

        while (iteracion){ //inicio del programa
            System.out.println("========== TVentas ==========");
            System.out.printf("1. Gestion de empleados\n2. Gestion de productos\n3. Gestion de ventas\nRespuesta:"); //REQUERIMIENTOS FUNCIONALES
            op = Integer.parseInt(sc.readLine());


            if (op == 1){ //GESTION DE EMPLEADOS
                System.out.println("====== Se encuentra gestionando los empleados ====== ");
                System.out.printf("1. Agregar empleado\n2. Eliminar empleado\n3. Actualizar empleado\n4. Ver empleados\nRespuesta:");
                op1 = Integer.parseInt(sc.readLine());

                if(op1 == 1){
                    empleado1.addEmpleado(empleado1);
                }else if (op1 == 2){
                    empleado1.deleteEmpleado();
                }else if (op1 == 3){
                    empleado1.editEmpleado();
                }else{empleado1.printEmpleados();}
            }

            if(op == 2){ //GESTION DE PRODUCTOS
                System.out.println("====== Se encuentra gestionando los productos ====== ");
                System.out.printf("1. Agregar productos\n2. Eliminar productos\n3. Actualizar productos\n4. Ver productos\nRespuesta:");
                op1 = Integer.parseInt(sc.readLine());
                if (op1 == 1){
                    producto1.addProducto(producto1);
                } else if (op1 == 2) {
                    producto1.deleteProducto();
                } else if (op1 == 3){
                    producto1.editProducto();
                }else {producto1.printProductos();}
            }

            if (op == 3){ //GESTION DE VENTAS
                System.out.println("====== Se encuentra gestionando las ventas ====== ");
                System.out.printf("1. Inicir venta\n2. Ver ventas\nRespuesta:"); //**POR PROTOCOLO DE SEGURIDAD, LO APROPIADO ES QUE SOLO EXISTA UNA OPCIÓN PARA AGREGAR VENTAS
                op1 = Integer.parseInt(sc.readLine());

                if (op1 == 1){
                    local.iniciarVenta();
                }else {local.printVentas();}
            }

            System.out.printf("Desea volver al menú principal?\n1. SI\n2. NO\nRespuesta: ");
            int menu = Integer.parseInt(sc.readLine()); //ITERACION
            if (menu == 2){break;} //sale del programa
        }
    }
}
