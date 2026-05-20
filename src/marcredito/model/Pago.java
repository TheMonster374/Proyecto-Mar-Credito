package marcredito.model;

import java.io.Serializable;

public class Pago implements Serializable {
    private final double valor;
    private final String fecha;

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