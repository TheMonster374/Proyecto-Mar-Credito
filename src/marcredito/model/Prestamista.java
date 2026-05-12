package marcredito.model;

/**
 * Clase que representa un prestamista (hereda Usuario).
 */
public class Prestamista extends Usuario {

    public Prestamista(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    /**
     * Método básico para validación simple del monto.
     */
    public boolean puedeFinanciar(double monto) {
        return monto > 0;
    }

    /**
     * Método para mostrar cómo sería un acuerdo (texto).
     */
    public String generarAcuerdo(double interesPorcentaje, int plazoMeses) {
        return "Acuerdo: interes=" + interesPorcentaje + "%, plazo=" + plazoMeses + " meses";
    }

    /**
     * Método básico para simular la financiación de un préstamo.
     */
    public void financiarPrestamo(double monto) {
        System.out.println(getNombre() + " financiara un prestamo por: " + monto);
    }
}
