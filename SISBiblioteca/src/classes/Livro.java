package classes;

public class Livro {
    private String titulo;
    private String codigo; 
    private String autor;
    private int numeroExemplar;
    private boolean emprestado; 
    private boolean solicitado;

    // Construtor
    public Livro(String titulo, String codigo, String autor, int numeroExemplar, boolean emprestado, boolean solicitado){
        this.titulo = titulo;
        this.codigo = codigo;
        this.autor = autor;
        this.numeroExemplar = numeroExemplar;
        this.emprestado = emprestado;
        this.solicitado = solicitado;

    }

    public String  gerarInformação(){
        return ("Título: " + titulo 
        + "\nCódigo: " + codigo 
        + "\nAutor: " + autor 
        + "\nNº Exemplar: " + numeroExemplar
        + "\nEmprestado: " + (emprestado ? "Sim" : "Não")
        + "\nSolicitado: " + (solicitado ? "Sim" : "Não"));

    }


    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return String return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return int return the numeroExemplar
     */
    public int getNumeroExemplar() {
        return numeroExemplar;
    }

    /**
     * @param numeroExemplar the numeroExemplar to set
     */
    public void setNumeroExemplar(int numeroExemplar) {
        this.numeroExemplar = numeroExemplar;
    }

    /**
     * @return boolean return the emprestado
     */
    public boolean isEmprestado() {
        return emprestado;
    }

    /**
     * @param emprestado the emprestado to set
     */
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    /**
     * @return boolean return the solicitado
     */
    public boolean isSolicitado() {
        return solicitado;
    }

    /**
     * @param solicitado the solicitado to set
     */
    public void setSolicitado(boolean solicitado) {
        this.solicitado = solicitado;
    }

}