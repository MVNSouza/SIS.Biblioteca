package classes;




public class Livro {
    private String titulo, codigo, autor;
    private int numeroExemplar;
    private boolean emprestado, solicitado;
    private Estante estante;


    // Construtor
    public Livro(String titulo, String codigo, String autor, int numeroExemplar){
        this.titulo = titulo;
        this.codigo = codigo;
        this.autor = autor;
        this.numeroExemplar = numeroExemplar;
        emprestado = false;
        solicitado = false;

    }

    public void gerarInformação(){
        System.out.println("Título: " + titulo 
        + "\nCódigo: " + codigo 
        + "\nAutor: " + autor 
        + "\nNº Exemplar: " + numeroExemplar
        + "\nEmprestado: " + (emprestado ? "Sim" : "Não")
        + "\nSolicitado: " + (solicitado ? "Sim" : "Não"));

    }

    public void adicionarEmEstante(Database db, String codigo){
        db.adicionarEmEstante(this, codigo);
    }

}
