package marcredito.model;

import java.util.List;
import marcredito.service.SistemaBanco;

/**
 * Clase para manejar Peticiones, Quejas, Reclamos y Sugerencias.
 */
public class PQRS {

    private final String tipo;
    private final String descripcion;
    private String estado;
    private final Usuario usuario;

    public PQRS(String tipo, String descripcion, Usuario usuario) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.estado = "Pendiente";
    }

    public String getTipo() {
        return tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void resolver() {
        this.estado = "Resuelto";
    }

    public void procesar(SistemaBanco sistema) {
        switch (this.tipo) {
            case "RECLAMO":
                System.out.println("Reclamo - prioridad alta");
                List<Prestamo> prestamos = sistema.obtenerPrestamosDeUsuario(usuario);
                for (Prestamo prestamo : prestamos) {
                    System.out.println("Préstamo asociado:");
                    System.out.println(prestamo.resumen());
                }
                break;
            case "QUEJA":
                System.out.println("Queja registrada");
                break;
            case "PETICION":
                System.out.println("Petición procesada");
                break;
            case "SUGERENCIA":
                System.out.println("Sugerencia recibida");
                break;
            default:
                System.out.println("Tipo no válido: " + this.tipo);
        }
    }
}
