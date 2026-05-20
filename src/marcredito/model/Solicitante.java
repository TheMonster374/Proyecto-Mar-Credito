package marcredito.model;

import java.io.Serializable;

public class Solicitante extends Usuario implements Serializable {

    public Solicitante(String id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    public String solicitarPrestamo(double monto, int plazoMeses) {
        return "Solicitud: monto=" + monto + ", plazo=" + plazoMeses + " meses";
    }

    public void pagarCuota(double valor) {
        System.out.println(getNombre() + " pagará una cuota de: " + valor);
    }
}