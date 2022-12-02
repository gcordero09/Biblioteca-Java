package tech.calaverita.models;

public class Usuario {

    private int id;
    private String nombre;
    private String programa;
    private String fechaNacimiento;
    private String correo;
    private String password;

    public Usuario(){
        
    }
    
    public Usuario(int id){
        this.id = id;
    }
    
    public Usuario(String nombre, String programa, String fechaNacimiento, String correo, String password) {
        this.nombre = nombre;
        this.programa = programa;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.password = password;
    }
    
    public Usuario(int id, String nombre, String programa, String fechaNacimiento, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
