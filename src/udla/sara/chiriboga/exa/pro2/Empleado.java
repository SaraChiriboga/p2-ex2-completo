package udla.sara.chiriboga.exa.pro2;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

abstract public class Empleado {
    private String id; //atributos
    private String nombre;
    private double salario;
    private String tipo;
    private List<Empleado> empleados = new ArrayList<>();

    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    //constructor para evitar replicación de objetos al agregar a lista tipo Empleado
    public Empleado(String id, String nombre, double salario, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.tipo = tipo;
    }
    /*este constructor va a ser heredado en la clase vendedor y gerente, por lo tanto, puedo crear una instancia de esas clases que no son
    abstractas y usarlos para evitar replicar los objetos dentro de mi lista empleados a través de una asignación de memoria (ver metodo addEmpleado())*/


    abstract public void iEmpleado(); //metodo abstracto

    //getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void addEmpleado(Empleado empleado) throws IOException { //metodo para agregar empleados
        System.out.println("Nombre: ");
        empleado.setNombre(sc.readLine());
        System.out.println("ID: ");
        empleado.setId(sc.readLine());
        System.out.println("Salario: ");
        empleado.setSalario(Double.parseDouble(sc.readLine()));
        System.out.println("Vendedor o Gerente? (1. Vendedor - 2. Gerente)");
        int tipo = Integer.parseInt(sc.readLine());
        if (tipo == 1){
            empleado.setTipo("Vendedor");
        }else {empleado.setTipo("Gerente");}
        System.out.println("Empleado agregado con éxito!");

        //creacion de nuevo objeto
        Vendedor nuevo = new Vendedor(empleado.getId(), empleado.getNombre(), empleado.getSalario(), empleado.getTipo());
        empleados.add(nuevo);
    }

    public void deleteEmpleado() throws IOException { //metodo para eliminar empleado
        System.out.println("ID del empleado: ");
        String delete = sc.readLine();

        for (Empleado eliminar : empleados){
            if (eliminar.getId().equals(delete)){
                empleados.remove(eliminar);
            } else {
                System.out.println("No se encontró un empleado con tal ID");
            }
        }
    }

    public void editEmpleado() throws IOException { //metodo para actualizar empleado en base a su id
        System.out.println("ID del empleado: ");
        String acc = sc.readLine();

        for (Empleado actualizar : empleados){
            if (actualizar.getId().equals(acc)){
                System.out.println("Se encuentra actualizando información sobre **" + actualizar.getNombre() + "**");
                System.out.println("Nombre: ");
                actualizar.setNombre(sc.readLine());
                System.out.println("ID: ");
                actualizar.setId(sc.readLine());
                System.out.println("Salario: ");
                actualizar.setSalario(Double.parseDouble(sc.readLine()));
                System.out.println("Vendedor o Gerente? (1. Vendedor - 2. Gerente)");
                int tipo = Integer.parseInt(sc.readLine());
                if (tipo == 1){
                    actualizar.setTipo("Vendedor");
                }else {actualizar.setTipo("Gerente");}
            }
        }
    }

    public void printEmpleados(){ //metodo para imprimir todos los empleados del local
        System.out.println("Nombre\tID del empleado\tSalario\tTipo de empleado");
        for (Empleado print : empleados){
            System.out.println(print.getNombre() + "\t" + print.getId() + "\t" + print.getSalario() + "\t" + print.getTipo());
        }
    }
}
