package classes;
import java.util.ArrayList;

public class Estante {
    public String codigo;
    public ArrayList<Livro> livros = new ArrayList<>();

    public Estante(String codigo){
        this.codigo = codigo;
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso.");
    }
    public void listarLivros(){
        int contador = 1;
        System.out.println("Estante ["+ codigo +"]");
        for (Livro livro : livros){
            System.out.println("Livro" + contador );
            livro.gerarInformação();
            contador++;
        }
        
    }
    public String getCodigo(){
        return codigo;
    }
}
