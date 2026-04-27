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
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + '}';
    }

    /**
     * @return the id
     */
    protected String getId() {
        return id;
    }    

    /**
     * @return the nombre
     */
    protected String getNombre() {
        return nombre;
    }
    
    /**
     * @return the correo
     */
    protected String getCorreo() {
        return correo;
    }
    
}
