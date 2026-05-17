package marcredito;

import marcredito.controller.ControladorBanco;
import marcredito.model.Prestamo;
import marcredito.model.Usuario;
import marcredito.persistence.Persistencia;
import marcredito.service.SistemaBanco;
import marcredito.view.Login;

public class App {
    
    public static void main(String[] args) {
        SistemaBanco sistema = new SistemaBanco();
        ControladorBanco controller = new ControladorBanco(sistema);

        for (Usuario usuario : Persistencia.cargarUsuarios()) {
            sistema.agregarUsuario(usuario);
        }

        if (controller.buscarUsuarioPorId("P1") == null) {
            controller.registrarPrestamista("P1", "Prestamista General", "prestamista@mail.com");
        }

        for (Prestamo prestamo : Persistencia.cargarPrestamos(sistema.getUsuarios())) {
            sistema.agregarPrestamo(prestamo);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Login(controller).setVisible(true);
        });        
    }    
    
}
