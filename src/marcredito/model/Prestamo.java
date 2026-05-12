package marcredito.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un préstamo.
 */
public class Prestamo {

    private final double monto;
    private final int plazoMeses;
    private final double interes;
    private final Solicitante solicitante;
    private final Prestamista prestamista;
    private final List<Pago> pagos;

    public Prestamo(double monto, int plazoMeses, double interes,
                    Solicitante solicitante, Prestamista prestamista) {
        this.monto = monto;
        this.plazoMeses = plazoMeses;
        this.interes = interes;
        this.solicitante = solicitante;
        this.prestamista = prestamista;
        this.pagos = new ArrayList<Pago>();
    }

    public void registrarPago(Pago pago) {
        pagos.add(pago);
    }

    public double calcularTotalPagar() {
        return monto + (monto * interes / 100);
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public Prestamista getPrestamista() {
        return prestamista;
    }

    public List<Pago> getPagos() {
        return new ArrayList<Pago>(pagos);
    }

    public String resumen() {
        return "Prestamo de " + monto + " a " + plazoMeses + " meses con interes " + interes + "%";
    }
}
