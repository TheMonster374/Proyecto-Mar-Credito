package marcredito.model;

public abstract class Usuario {
    private final String id;
    private final String nombre;
    private final String correo;

    public Usuario(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", correo='" + correo + '\'' +
               '}';
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
}
