package udla.sara.chiriboga.exa.pro2;

public class Calzado extends Producto{ //clase hija de prooducto
    private int numero; //atributos

    public Calzado(String codigo, String nombre, double precio, int cantidad, String tipo, String infExtra) {
        super(codigo, nombre, precio, cantidad, tipo, infExtra);
    } //constructor

    //implementacion de metodo abstracto de clase abstracta
    @Override
    public void iEmpleado() {

    }

    //metodos
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
