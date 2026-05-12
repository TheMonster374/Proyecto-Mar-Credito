package marcredito.model;

public class Prestamista extends Usuario {

    /**
     * Crea un prestamista.
     *
     * @param id identificador
     * @param nombre nombre del prestamista
     * @param correo correo del prestamista
     */
    public Prestamista(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    /**
     * Indica si puede financiar un monto.
     *
     * @param monto monto solicitado
     * @return true si el monto es mayor a 0
     */
    public boolean puedeFinanciar(double monto) {
        return monto > 0;
    }

    /**
     * Genera una descripción de acuerdo.
     *
     * @param interesPorcentaje interés del acuerdo
     * @param plazoMeses plazo del acuerdo
     * @return texto del acuerdo
     */
    public String generarAcuerdo(double interesPorcentaje, int plazoMeses) {
        return "Acuerdo: interes=" + interesPorcentaje + "%, plazo=" + plazoMeses + " meses";
    }

    /**
     * Imprime un mensaje de financiación.
     *
     * @param monto monto a financiar
     */
    public void financiarPrestamo(double monto) {
        System.out.println(getNombre() + " financiará un préstamo por: " + monto);
    }
}
