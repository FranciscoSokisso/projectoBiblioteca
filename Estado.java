package ProjectoFacil;

 public enum Estado {
    DISPONIVEL("Disponível"), EMPRESTADO("Esprestado");
    public int valor;
    public String estadoSring;

    Estado( String estadoString){
        this.estadoSring = estadoString;
    }

    public String getEstadoString(){
        return this.estadoSring;
    }
   
}
