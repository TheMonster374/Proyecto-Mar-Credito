package marcredito.service;

import java.util.ArrayList;
import java.util.List;
import marcredito.model.Prestamo;
import marcredito.model.Usuario;

/**
 * Servicio principal para gestionar usuarios y préstamos del sistema.
 */
public class SistemaBanco {

    private final List<Usuario> usuarios = new ArrayList<Usuario>();
    private final List<Prestamo> prestamos = new ArrayList<Prestamo>();

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    /**
     * Obtiene todos los préstamos asociados al usuario indicado.
     */
    public List<Prestamo> obtenerPrestamosDeUsuario(Usuario usuario) {
        List<Prestamo> resultado = new ArrayList<Prestamo>();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getSolicitante().getId().equals(usuario.getId())) {
                resultado.add(prestamo);
            }
        }

        return resultado;
    }
}
