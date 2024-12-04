package udla.sara.chiriboga.exa.pro2;

public class Ropa extends Producto{ //clase hija de producto
    private String talla; //atributos

    public Ropa(String codigo, String nombre, double precio, int cantidad, String tipo, String infExtra) {
        super(codigo, nombre, precio, cantidad, tipo, infExtra);
    }//constructor

    @Override
    public void iEmpleado() { //implementaición de metodo abstracto

    }

    //getter y setter
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
