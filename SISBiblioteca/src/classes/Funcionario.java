package classes;
import java.util.Scanner;

public class Funcionario extends Cliente {
    boolean solicitacoesPendentes;
    Scanner input = new Scanner(System.in);

    public Funcionario(String nome, String id, String senha, String email){
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.email = email;
        solicitacoesPendentes = false;
    }

    public void nomeFunc(){
        System.out.println(nome);
    }

    public void cadastrarLivro(Database db){

        System.out.print("Título: ");
        String titulo = input.nextLine();
        System.out.print("Autor: ");
        String autor = input.nextLine();
        System.out.print("Código: ");
        String codigo = input.nextLine();
        System.out.print("Número de exemplar: ");
        int numeroExemplar = input.nextInt();

        Livro l = new Livro(titulo, codigo, autor, numeroExemplar);
        String numeroDeEstante = codigo.substring(0, 3);
        l.adicionarEmEstante(db, numeroDeEstante);
    }
}
