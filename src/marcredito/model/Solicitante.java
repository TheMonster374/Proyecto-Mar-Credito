package marcredito.model;

/**
 * Clase que representa un solicitante (hereda Usuario).
 */
public class Solicitante extends Usuario {

    public Solicitante(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    /**
     * Método para mostrar la solicitud de préstamo como texto.
     */
    public String solicitarPrestamo(double monto, int plazoMeses) {
        return "Solicitud: monto=" + monto + ", plazo=" + plazoMeses + " meses";
    }

    /**
     * Método básico para simular el pago de una cuota.
     */
    public void pagarCuota(double valor) {
        System.out.println(getNombre() + " pagara una cuota de: " + valor);
    }
}
