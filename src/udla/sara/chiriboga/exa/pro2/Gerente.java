package udla.sara.chiriboga.exa.pro2;

public class Gerente extends Empleado{ //clase hija de empleado
    private double bonoAnual;

    public Gerente(String id, String nombre, double salario, String tipo) {
        super(id, nombre, salario, tipo);
    } //constructor

    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double salario) { //supongamos que reciben el 10% de su salario
        this.bonoAnual = salario * 0.10;
    }

    //implementación de metodo abstracto
    @Override
    public void iEmpleado() {

    }
}
