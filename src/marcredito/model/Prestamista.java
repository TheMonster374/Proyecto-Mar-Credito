package marcredito.model;

import java.io.Serializable;

public class Prestamista extends Usuario implements Serializable {

    public Prestamista(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    public boolean puedeFinanciar(double monto) {
        return monto > 0;
    }

    public String generarAcuerdo(double interesPorcentaje, int plazoMeses) {
        return "Acuerdo: interes=" + interesPorcentaje + "%, plazo=" + plazoMeses + " meses";
    }

    public void financiarPrestamo(double monto) {
        System.out.println(getNombre() + " financiará un préstamo por: " + monto);
    }
}