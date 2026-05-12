package marcredito.model;

public class Pago {
    private final double valor;
    private final String fecha;

    /**
     * Crea un pago.
     *
     * @param valor valor del pago
     * @param fecha fecha del pago
     */
    public Pago(double valor, String fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }

    /**
     * Obtiene el valor pagado.
     *
     * @return valor del pago
     */
    public double getValor() {
        return valor;
    }

    /**
     * Obtiene la fecha del pago.
     *
     * @return fecha del pago
     */
    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Pago de " + valor + " en fecha " + fecha;
    }
}
