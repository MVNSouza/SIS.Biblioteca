package classes;

import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String codigo; 
    private String autor;
    private int numeroExemplar;
    private boolean emprestado; 
    private boolean solicitado;

    private final ArrayList<Emprestimo> historico;

    // Construtor
    public Livro(String titulo, String codigo, String autor){
        historico = new ArrayList<>();
        this.titulo = titulo;
        this.codigo = codigo;
        this.numeroExemplar = 1;
        for (Livro livro : Estante.livrosGeral) {
            if (livro.codigo.equals(this.codigo)){
                this.numeroExemplar ++;
            } 
        }
        this.autor = autor;
        this.emprestado = false;
        this.solicitado = false;

        Estante.livrosGeral.add(this);
    }

    public String  gerarInformação(){
        return ("Título: " + titulo 
        + "\nAutor: " + autor 
        + "\nCódigo: " + codigo 
        + " |   Nº Exemplar: " + numeroExemplar
        + "\nEmprestado: " + (emprestado ? "Sim" : "Não")
        + " |   Solicitado: " + (solicitado ? "Sim" : "Não") +
        "\n"
        );

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
        if (! titulo.isEmpty()){
            this.titulo = titulo;
        } 
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
        if (! codigo.isEmpty()){
            this.codigo = codigo;
        } 
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

    public void visualizarHistorico(){
        int contador = 1;
        for (Emprestimo emprestimo : historico){

            System.out.println(">>>>>>>>>> "+ contador);
            emprestimo.toString();

            contador ++;
        }
    }

}