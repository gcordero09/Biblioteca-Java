package tech.calaverita.models;

public class Libro {

    private int id;
    private String titulo;
    private String editorial;
    private String area;
    private String coverUrl;
    private String digitalUrl;
    private boolean isDisponibleFisico;
    
    public Libro(){
        
    }
    
    public Libro(int id){
        this.id = id;
    }

    public Libro(String titulo, String editorial, String area, String coverUrl, String digitalUrl, boolean isDisponibleFisico) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.area = area;
        this.coverUrl = coverUrl;
        this.digitalUrl = digitalUrl;
        this.isDisponibleFisico = isDisponibleFisico;
    }

    public Libro(int id, String titulo, String editorial, String area, String coverUrl, String digitalUrl, boolean isDisponibleFisico) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.area = area;
        this.coverUrl = coverUrl;
        this.digitalUrl = digitalUrl;
        this.isDisponibleFisico = isDisponibleFisico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDigitalUrl() {
        return digitalUrl;
    }

    public void setDigitalUrl(String digitalUrl) {
        this.digitalUrl = digitalUrl;
    }

    public boolean isIsDisponibleFisico() {
        return isDisponibleFisico;
    }

    public void setIsDisponibleFisico(boolean isDisponibleFisico) {
        this.isDisponibleFisico = isDisponibleFisico;
    }

}
