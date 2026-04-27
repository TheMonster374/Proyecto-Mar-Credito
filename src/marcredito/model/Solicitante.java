package marcredito.model;

public class Solicitante extends Usuario {

    public Solicitante(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    // Este método es un avance de estructura.
    // Cuando exista la clase Prestamo, se creará y asociará el préstamo real al solicitante.
    public String solicitarPrestamo(double monto, int plazoMeses) {
        return "Solicitud: monto=" + monto + ", plazo=" + plazoMeses + " meses";
    }

    // Cuando exista la clase Pago (y la relación con Prestamo), este método registrará pagos reales.
    public void pagarCuota(double valor) {
        System.out.println(getNombre() + " pagara una cuota de: " + valor);
    }
}
