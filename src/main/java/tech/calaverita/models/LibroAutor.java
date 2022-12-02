package tech.calaverita.models;

public class LibroAutor {

    private int id;
    private String libroId;
    private String autorId;

    public LibroAutor(){
        
    }
    
    public LibroAutor(int id){
        this.id = id;
    }
    
    public LibroAutor(String libroId, String autorId) {
        this.libroId = libroId;
        this.autorId = autorId;
    }
    
    public LibroAutor(int id, String libroId, String autorId) {
        this.id = id;
        this.libroId = libroId;
        this.autorId = autorId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public String getAutorId() {
        return autorId;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }

}
