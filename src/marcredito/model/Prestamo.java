package marcredito.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prestamo {

    private String idPrestamo;
    private final double monto;
    private String estado;

    private final Acuerdo acuerdo;
    private final Solicitante solicitante;
    private final Prestamista prestamista;

    private final List<Pago> pagos = new ArrayList<>();

    /**
     * Crea un préstamo.
     *
     * @param monto monto prestado
     * @param acuerdo acuerdo del préstamo
     * @param solicitante solicitante
     * @param prestamista prestamista
     */
    public Prestamo(double monto, Acuerdo acuerdo, Solicitante solicitante,  Prestamista prestamista) {

        this.idPrestamo = generarId();
        this.monto = monto;

        this.estado = "Pendiente";

        this.acuerdo = acuerdo;
        this.solicitante = solicitante;
        this.prestamista = prestamista;
    }

    /**
     * Genera ID tipo P1234
     */
    private String generarId() {

        Random random = new Random();

        int numero = 1000 + random.nextInt(9000);

        return "P" + numero;
    }

    /**
     * Registrar pago
     * @param pago
     */
    public void registrarPago(Pago pago) {
        pagos.add(pago);
    }

    /**
     * Total a pagar
     * @return 
     */
    public double calcularTotalPagar() {

        return monto +
                (monto * acuerdo.getInteres() / 100);
    }

    /**
     * Resumen
     * @return 
     */
    public String resumen() {

        return "Prestamo: monto=" + monto
                + ", plazo=" + acuerdo.getPlazoMeses()
                + " meses, interes=" + acuerdo.getInteres()
                + "%, estado=" + estado
                + ", solicitante=" + solicitante.getNombre()
                + ", prestamista=" + prestamista.getNombre();
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public double getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Acuerdo getAcuerdo() {
        return acuerdo;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public Prestamista getPrestamista() {
        return prestamista;
    }

    public List<Pago> getPagos() {
        return pagos;
    }
}
