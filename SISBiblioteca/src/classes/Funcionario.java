package classes;

public class Funcionario extends Cliente {
    boolean solicitacoesPendentes;

    public Funcionario(String nome, String senha, String email){
        logins++;
        
        this.nome = nome;
        this.id = logins;
        this.senha = senha;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }
}
