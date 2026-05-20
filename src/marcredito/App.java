package marcredito;

import java.io.IOException;
import marcredito.controller.ControladorBanco;
import marcredito.model.Prestamo;
import marcredito.model.Usuario;
import marcredito.persistence.Persistencia;
import marcredito.service.SistemaBanco;
import marcredito.view.Login;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SistemaBanco sistema = new SistemaBanco();
        Persistencia persistencia = new Persistencia();

        // Cargar usuarios
        for (Usuario u : persistencia.listarUsuarios()) {
            sistema.agregarUsuario(u);
        }
        // Cargar préstamos
        for (Prestamo p : persistencia.listarPrestamos()) {
            sistema.agregarPrestamo(p);
        }

        ControladorBanco controller = new ControladorBanco(sistema, persistencia);

        java.awt.EventQueue.invokeLater(() -> {
            new Login(controller).setVisible(true);
        });
    }
}