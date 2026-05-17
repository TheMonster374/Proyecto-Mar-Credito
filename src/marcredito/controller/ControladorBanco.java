package marcredito.controller;

import java.util.Collections;
import java.util.List;
import marcredito.model.*;
import marcredito.persistence.Persistencia;
import marcredito.service.SistemaBanco;

/**
 * Controlador del sistema (parte "Controller" del MVC).
 * 
 * Se encarga de recibir datos desde la Vista (por ejemplo un JFrame),
 * crear objetos del Modelo y usar el Servicio (SistemaBanco) para guardarlos
 * o consultarlos.
 */
public class ControladorBanco {

    private final SistemaBanco sistema;

    /**
     * Crea el controlador usando un SistemaBanco.
     * @param sistema servicio que guarda y consulta usuarios y préstamos
     */
    public ControladorBanco(SistemaBanco sistema) {
        this.sistema = sistema;
    }

    /**
     * Registra un solicitante en el sistema.
     * @param id identificación del usuario
     * @param nombre nombre del usuario
     * @param correo correo del usuario
     */
    public void registrarSolicitante(String id, String nombre, String correo) {

        Solicitante s = new Solicitante(id, nombre, correo);

        sistema.agregarUsuario(s);

        Persistencia.guardarUsuarios(sistema.getUsuarios());
    }

    /**
     * Registra un prestamista en el sistema.
     * @param id identificación del usuario
     * @param nombre nombre del usuario
     * @param correo correo del usuario
     */
    public void registrarPrestamista(String id, String nombre, String correo) {

        Prestamista p = new Prestamista(id, nombre, correo);

        sistema.agregarUsuario(p);

        Persistencia.guardarUsuarios(sistema.getUsuarios());
    }

    /**
     * Busca un usuario por su ID.
     * @param id ID a buscar
     * @return el Usuario si existe; si no existe, retorna null
     */
    public Usuario buscarUsuarioPorId(String id) {
        return sistema.buscarUsuarioPorId(id);
    }

    /**
     * Crea un préstamo y lo registra en el sistema.
     * 
     * Si el solicitante o prestamista no existen (o no son del tipo correcto),
     * no se crea el préstamo.
     *
     * @param monto valor del préstamo
     * @param plazoMeses plazo del préstamo en meses
     * @param interes interés en porcentaje (%)
     * @param idSolicitante ID del solicitante
     * @param idPrestamista ID del prestamista
     */
    public void crearPrestamo(double monto, int plazoMeses, double interes, String idSolicitante, String idPrestamista) {

        Usuario uSol = sistema.buscarUsuarioPorId(idSolicitante);
        Usuario uPre = sistema.buscarUsuarioPorId(idPrestamista);

        if (!(uSol instanceof Solicitante)) return;
        if (!(uPre instanceof Prestamista)) return;

        Acuerdo acuerdo = new Acuerdo(interes, plazoMeses);

        Prestamo prestamo = new Prestamo(monto, acuerdo, (Solicitante) uSol, (Prestamista) uPre);

        sistema.agregarPrestamo(prestamo);
        Persistencia.guardarPrestamos(sistema.getPrestamos());
        }

        public List<Prestamo> getPrestamos() {
            return sistema.getPrestamos();
    }

    /**
     * Obtiene los préstamos asociados a un usuario por ID.
     * @param idUsuario ID del usuario
     * @return lista de préstamos (si no hay, retorna lista vacía)
     */
    public List<Prestamo> obtenerPrestamosDeUsuario(String idUsuario) {
        Usuario u = sistema.buscarUsuarioPorId(idUsuario);
        if (u == null) return Collections.emptyList();
        return sistema.obtenerPrestamosDeUsuario(u);
    }    
}
