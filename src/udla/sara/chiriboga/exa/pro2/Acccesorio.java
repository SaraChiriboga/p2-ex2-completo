package udla.sara.chiriboga.exa.pro2;

public class Acccesorio extends Producto{ //clase hija de producto
    private String tipo; //atributo

    public Acccesorio(String codigo, String nombre, double precio, int cantidad, String tipo, String infExtra) {
        super(codigo, nombre, precio, cantidad, tipo, infExtra);
    } //constructor

    //metodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //implementacion de metodo abstracto de clase abstracta
    @Override
    public void iEmpleado() {

    }
}
