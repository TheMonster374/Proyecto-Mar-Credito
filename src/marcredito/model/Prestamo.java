package marcredito.model;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    Acuerdo acuerdo;
    private final double monto;       
    private final Solicitante solicitante;
    private final Prestamista prestamista;
    private final List<Pago> pagos = new ArrayList<>();

    /**
     * Crea un préstamo.
     *
     * @param monto monto prestado
     * @param acuerdo
     * @param solicitante solicitante del préstamo
     * @param prestamista prestamista del préstamo
     */
    
    public Prestamo(double monto, Acuerdo acuerdo, Solicitante solicitante, Prestamista prestamista) {    
        this.monto = monto;
        this.acuerdo = acuerdo;
        this.solicitante = solicitante;
        this.prestamista = prestamista;
    }

    /**
     * Registra un pago en el préstamo.
     *
     * @param pago pago realizado
     */
    public void registrarPago(Pago pago) {
        pagos.add(pago);
    }

    /**
     * Calcula el total a pagar con interés.
     *
     * @return total a pagar
     */
    public double calcularTotalPagar() {
        return monto + (monto * acuerdo.getInteres() / 100);
    }

    /**
     * Obtiene el solicitante.
     *
     * @return solicitante del préstamo
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }

    /**
     * Genera un resumen del préstamo.
     *
     * @return resumen del préstamo
     */
    public String resumen() {
        return "Prestamo: monto=" + monto
                + ", plazo=" + acuerdo.getPlazoMeses()
                + " meses, interes=" + acuerdo.getInteres()
                + "%, solicitante=" + solicitante.getNombre()
                + ", prestamista=" + prestamista.getNombre()
                + ", pagos registrados=" + pagos.size();
    }
}
