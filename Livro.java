package ProjectoFacil;

public class Livro {
    private String titulo, autor;
    private long ISBN;
    private Estado estado;

    public Livro(String tituo, String autor, long ISBN, Estado estado){
        this.titulo = tituo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.estado = estado;
    }

    public void setTitulo(String titulo){
        this.titulo= titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setISBN(long ISBN){
        this.ISBN = ISBN;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado(){
        return this.estado;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public long getISBN(){
        return this.ISBN;
    }
}
