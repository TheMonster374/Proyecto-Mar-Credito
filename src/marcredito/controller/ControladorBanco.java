package marcredito.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import marcredito.model.*;
import marcredito.persistence.Persistencia;
import marcredito.service.SistemaBanco;

public class ControladorBanco {

    private final SistemaBanco sistema;
    private final Persistencia persistencia;
    
    public ControladorBanco(SistemaBanco sistema, Persistencia persistencia) {
        this.sistema = sistema;
        this.persistencia = persistencia;
    }

    public void registrarSolicitante(String id, String nombre, String correo) {
        Solicitante s = new Solicitante(id, nombre, correo);
        sistema.agregarUsuario(s);
        try {
            persistencia.guardarUsuario(s);
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void registrarPrestamista(String id, String nombre, String correo) {
        Prestamista p = new Prestamista(id, nombre, correo);
        sistema.agregarUsuario(p);
        try {
            persistencia.guardarUsuario(p);
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public Usuario buscarUsuarioPorId(String id) {
        return sistema.buscarUsuarioPorId(id);
    }

    public void crearPrestamo(double monto, int plazoMeses, double interes, String idSolicitante, String idPrestamista) {
        Usuario uSol = sistema.buscarUsuarioPorId(idSolicitante);
        Usuario uPre = sistema.buscarUsuarioPorId(idPrestamista);

        if (!(uSol instanceof Solicitante)) return;
        if (!(uPre instanceof Prestamista)) return;

        Acuerdo acuerdo = new Acuerdo(interes, plazoMeses);

        Prestamo prestamo = new Prestamo(monto, acuerdo, (Solicitante) uSol, (Prestamista) uPre);

        sistema.agregarPrestamo(prestamo);
        try {
            persistencia.guardarPrestamo(prestamo);
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public List<Prestamo> getPrestamos() {
        return sistema.getPrestamos();
    }

    public Prestamista obtenerPrimerPrestamista() {
        for (Usuario u : sistema.getUsuarios()) {
            if (u instanceof Prestamista p) {
                return p;
            }
        }
        return null;
    }

    public List<Prestamo> obtenerPrestamosDeUsuario(String idUsuario) {
        Usuario u = sistema.buscarUsuarioPorId(idUsuario);
        if (u == null) return Collections.emptyList();
        return sistema.obtenerPrestamosDeUsuario(u);
    }
}