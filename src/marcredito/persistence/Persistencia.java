package marcredito.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import marcredito.model.*;

public class Persistencia {

    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private static final String ARCHIVO_PRESTAMOS = "prestamos.txt";

    private Persistencia() {
    }

    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Usuario usuario : usuarios) {
                String tipo = "SOLICITANTE";
                if (usuario instanceof Prestamista) {
                    tipo = "PRESTAMISTA";
                }
                writer.println(usuario.getId() + ";" + usuario.getNombre() + ";" + usuario.getCorreo() + ";" + tipo);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        File archivo = new File(ARCHIVO_USUARIOS);

        if (!archivo.exists()) {
            return usuarios;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                if (datos.length < 4) {
                    continue;
                }

                String id = datos[0];
                String nombre = datos[1];
                String correo = datos[2];
                String tipo = datos[3];

                if ("PRESTAMISTA".equals(tipo)) {
                    usuarios.add(new Prestamista(id, nombre, correo));
                } else {
                    usuarios.add(new Solicitante(id, nombre, correo));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }

        return usuarios;
    }

    public static void guardarPrestamos(List<Prestamo> prestamos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_PRESTAMOS))) {
            for (Prestamo prestamo : prestamos) {
                writer.println(
                        prestamo.getIdPrestamo() + ";"
                        + prestamo.getMonto() + ";"
                        + prestamo.getAcuerdo().getPlazoMeses() + ";"
                        + prestamo.getAcuerdo().getInteres() + ";"
                        + prestamo.getEstado() + ";"
                        + prestamo.getSolicitante().getId() + ";"
                        + prestamo.getPrestamista().getId()
                );
            }
        } catch (IOException e) {
            System.out.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

    public static List<Prestamo> cargarPrestamos(List<Usuario> usuarios) {
        List<Prestamo> prestamos = new ArrayList<>();
        File archivo = new File(ARCHIVO_PRESTAMOS);

        if (!archivo.exists()) {
            return prestamos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                if (datos.length < 7) {
                    continue;
                }

                String idPrestamo = datos[0];
                double monto = Double.parseDouble(datos[1]);
                int plazo = Integer.parseInt(datos[2]);
                double interes = Double.parseDouble(datos[3]);
                String estado = datos[4];
                String idSolicitante = datos[5];
                String idPrestamista = datos[6];

                Solicitante solicitante = buscarSolicitante(usuarios, idSolicitante);
                Prestamista prestamista = buscarPrestamista(usuarios, idPrestamista);

                if (solicitante == null || prestamista == null) {
                    continue;
                }

                Acuerdo acuerdo = new Acuerdo(interes, plazo);
                Prestamo prestamo = new Prestamo(monto, acuerdo, solicitante, prestamista);
                prestamo.setIdPrestamo(idPrestamo);
                prestamo.setEstado(estado);
                prestamos.add(prestamo);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar préstamos: " + e.getMessage());
        }

        return prestamos;
    }

    private static Solicitante buscarSolicitante(List<Usuario> usuarios, String id) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Solicitante && usuario.getId().equals(id)) {
                return (Solicitante) usuario;
            }
        }
        return null;
    }

    private static Prestamista buscarPrestamista(List<Usuario> usuarios, String id) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Prestamista && usuario.getId().equals(id)) {
                return (Prestamista) usuario;
            }
        }
        return null;
    }
}
