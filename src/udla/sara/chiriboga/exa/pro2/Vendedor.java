package udla.sara.chiriboga.exa.pro2;

public class Vendedor extends Empleado{ //clase hija de empleado
    private double comision; //atributo

    public Vendedor(String id, String nombre, double salario, String tipo) {
        super(id, nombre, salario, tipo);
    }//constructor

    //metodos getter y setter con modificacion en set
    public double getComision() {
        return comision;
    }

    public void setComision(double precioventa) {
        this.comision = precioventa * 0.07;
    } //supongamos que tienen una comision del 7%

    //implementacion de metodo abstracto
    @Override
    public void iEmpleado() {

    }
}
