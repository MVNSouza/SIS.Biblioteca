package classes;
public class Livro {
    private String titulo, codigo, autor;
    private int numeroExemplar;
    private boolean emprestado, solicitado;

    // Construtor
    public Livro(String titulo, String codigo, String autor, int numeroExemplar, boolean emprestado, boolean solicitado){
        this.titulo = titulo;
        this.codigo = codigo;
        this.autor = autor;
        this.numeroExemplar = numeroExemplar;
        this.emprestado = emprestado;
        this.solicitado = solicitado;

    }

    public void  gerarInformação(){
        System.out.println("Título: " + titulo 
        + "\nCódigo: " + codigo 
        + "\nAutor: " + autor 
        + "\nNº Exemplar: " + numeroExemplar
        + "\nEmprestado: " + (emprestado ? "Sim" : "Não")
        + "\nSolicitado: " + (solicitado ? "Sim" : "Não"));

    }

}
