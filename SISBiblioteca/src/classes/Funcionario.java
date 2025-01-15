package classes;
public class Funcionario extends Cliente {
    boolean solicitacoesPendentes;

    public Funcionario(String nome, String id, String senha, String email){
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.email = email;
    }
}
