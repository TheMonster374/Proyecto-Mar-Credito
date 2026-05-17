package marcredito.service;

import java.util.ArrayList;
import java.util.List;
import marcredito.model.Prestamo;
import marcredito.model.Usuario;

public class SistemaBanco {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Prestamo> prestamos = new ArrayList<>();

    /**
     * Agrega un usuario al sistema.
     *
     * @param usuario usuario a registrar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
        
    /**
     * Busca un usuario dentro del sistema por su ID.
     * @param id ID del usuario
     * @return el Usuario si se encuentra; si no se encuentra, retorna null
     */
    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Agrega un préstamo al sistema.
     *
     * @param prestamo préstamo a registrar
     */
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    /**
     * Obtiene los préstamos asociados a un usuario.
     *
     * @param usuario usuario a consultar
     * @return lista de préstamos del usuario
     */
       public List<Prestamo> obtenerPrestamosDeUsuario(Usuario usuario) {
        List<Prestamo> prestamosUsuario = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getSolicitante().getId().equals(usuario.getId())) {
                prestamosUsuario.add(prestamo);
            }
        }
        return prestamosUsuario;
    }
    
    /**
     * Carga usuarios registrados
     * 
     * @return 
    */
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    /**
     * Carga Prestamos creados
     * 
     * @return 
     */
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
