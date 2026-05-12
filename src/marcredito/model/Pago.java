package marcredito.model;

/**
 * Clase que representa un pago realizado a un préstamo.
 */
public class Pago {

    private final double valor;
    private final String fecha;

    /**
     * Constructor básico.
     */
    public Pago(double valor, String fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Pago de " + valor + " en fecha " + fecha;
    }
}
