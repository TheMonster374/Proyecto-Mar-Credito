package marcredito.model;

public class Solicitante extends Usuario {

    /**
     * Crea un solicitante.
     *
     * @param id identificador
     * @param nombre nombre del solicitante
     * @param correo correo del solicitante
     */
    public Solicitante(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    /**
     * Genera una solicitud de préstamo.
     *
     * @param monto monto solicitado
     * @param plazoMeses plazo en meses
     * @return texto de solicitud
     */
    public String solicitarPrestamo(double monto, int plazoMeses) {
        return "Solicitud: monto=" + monto + ", plazo=" + plazoMeses + " meses";
    }

    /**
     * Imprime un mensaje de pago de cuota.
     *
     * @param valor valor de la cuota
     */
    public void pagarCuota(double valor) {
        System.out.println(getNombre() + " pagará una cuota de: " + valor);
    }
}
