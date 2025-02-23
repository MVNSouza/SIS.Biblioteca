package classes;

public class Usuario extends Cliente {
  
    private String endereco;
    private boolean emprestimoAtivo = false;

    public Usuario(String nome, String senha, String email, String endereco){
        logins++;
        this.id = logins;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;

    }

    // %%%%%%%%%%%%%%% NOME
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    // %%%%%%%%%%%%%%% SENHA
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    // %%%%%%%%%%%%%%% EMAIL
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    // %%%%%%%%%%%%%%% ENDEREÇO
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    // %%%%%%%%%%%%%%% EMPRESTIMO-ATIVO
    public boolean emprestimoIsAtivo(){
        return emprestimoAtivo;
    }
    public void alterarEmprestimoAtivo(){
        this.emprestimoAtivo = !emprestimoAtivo;
    }




    
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //      SOLICITAR EMPRESTIMO
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public void solicitarEmprestimo(Livro livro){
        boolean livroEncontrado = false;

        for (Livro l : Estante.livrosGeral){
            if ((l.getCodigo().equals(livro.getCodigo()) && !l.isEmprestado())) {
                Emprestimo e = new Emprestimo(livro, this, null, null, null, false);
                Emprestimo.appendEmprestimoPendente(e);
                
                livroEncontrado = true;
                break;
            }
        }
        
        if (livroEncontrado){
            System.out.println("Empréstimo enviado para aprovação.");
        } else {
            System.out.println("Não foi possível encontrar nenhum exemplar do livro informado.");
        }
    }

}
