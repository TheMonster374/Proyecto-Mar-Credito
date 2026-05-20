package marcredito.model;

import java.util.List;
import marcredito.service.SistemaBanco;

public class PQRS {
    private final String tipo;
    private final String descripcion;
    private String estado;
    private final Usuario usuario;

    /**
     * Crea un PQRS.
     *
     * @param tipo tipo del caso
     * @param descripcion descripción del caso
     * @param usuario usuario relacionado
     */
    public PQRS(String tipo, String descripcion, Usuario usuario) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.estado = "Pendiente";
    }

    /**
     * Obtiene el tipo.
     *
     * @return tipo del PQRS
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene la descripción.
     *
     * @return descripción del PQRS
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el estado.
     *
     * @return estado actual
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene el usuario del caso.
     *
     * @return usuario asociado
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Marca el PQRS como resuelto.
     */
    public void resolver() {
        this.estado = "Resuelto";
    }

    /**
     * Procesa el PQRS según su tipo.
     *
     * @param sistema sistema banco para consultas
     */
    public void procesar(SistemaBanco sistema) {
        if (tipo == null) {
            System.out.println("Tipo no válido");
            return;
    }
        switch (tipo) {
            case "RECLAMO":
                List<Prestamo> prestamos = sistema.obtenerPrestamosDeUsuario(usuario);
                for (Prestamo prestamo : prestamos) {
                    System.out.println(prestamo.resumen());
                }
                break;
            case "PETICION":
                System.out.println("Procesando petición: " + descripcion);
                break;
            case "QUEJA":
                System.out.println("Procesando queja: " + descripcion);
                break;
            case "SUGERENCIA":
                System.out.println("Procesando sugerencia: " + descripcion);
                break;
            default:
                System.out.println("Tipo no válido");
                break;
        }
    }
}