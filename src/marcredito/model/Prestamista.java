package marcredito.model;

public class Prestamista extends Usuario {

    public Prestamista(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    // Este método es un avance de estructura.
    // Cuando se implemente el modelo (Prestamo/Acuerdo), aquí se validará y gestionará la financiación real.
    public boolean puedeFinanciar(double monto) {
        return monto > 0;
    }

    // Aún no existe la clase Acuerdo en el modelo.
    // Este método solo representa la responsabilidad del prestamista.
    public String generarAcuerdo(double interesPorcentaje, int plazoMeses) {
        return "Acuerdo: interes=" + interesPorcentaje + "%, plazo=" + plazoMeses + " meses";
    }

    // Nota: Financiar un préstamo real requerirá un objeto Prestamo cuando exista en el modelo.
    public void financiarPrestamo(double monto) {
        System.out.println(getNombre() + " financiara un prestamo por: " + monto);
    }
}
