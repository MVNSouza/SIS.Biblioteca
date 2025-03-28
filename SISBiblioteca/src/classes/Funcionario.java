package classes;

import java.util.Date;

public class Funcionario extends Cliente {

    public Funcionario(String nome, String senha, String email) {
        logins++;
        this.nome = nome;
        this.id = logins;
        this.senha = senha;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    // Adicionar livro
    public void adicionarLivro(String titulo, String codigo, String autor) {
        Livro livro = new Livro(titulo, codigo, autor);
        Estante.autoAppendEstante(livro);
        System.out.println("Livro adicionado com sucesso à estante");
    }

    // Remover livro
    public void removerLivro(Livro livro, Estante estante) {
        estante.removerLivro(livro.getCodigo());
        System.out.println("Livro removido com sucesso.");
    }

    // Editar livro
    public void editarLivro(Livro livro, String novoTitulo, String novoAutor) {
        livro.setTitulo(novoTitulo);
        livro.setAutor(novoAutor);
        System.out.println("Livro atualizado com sucesso.");
    }

    // Aprovar empréstimo
    public void aprovarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setAtivo(true);
        emprestimo.getLivro().setEmprestado(true);
        System.out.println("Empréstimo aprovado para o livro: " + emprestimo.getLivro().getTitulo());
    }

    // Adicionar usuário
    public void adicionarUsuario() {
        System.out.println("0 - Usuário\n1 - Funcionário");
        int opcao = input.nextInt();
        cadastro(opcao);

    }

    // Remover usuário
    public void removerUsuario(Usuario usuario) {
        Cliente.loginsUser.remove(usuario);
        Cliente.loginsU.removeIf(login -> login.email.equals(usuario.getEmail()));
        System.out.println("Usuário removido com sucesso: " + usuario.getNome());
    }

    // Editar usuário
    public void editarUsuario(Usuario usuario, String novoNome, String novoEmail, String novaSenha, String novoEndereco) {
        usuario.setNome(novoNome);
        usuario.setEmail(novoEmail);
        usuario.setSenha(novaSenha);
        usuario.setEndereco(novoEndereco);
        System.out.println("Dados do usuário atualizados com sucesso.");
    }

    // Gerar notificação
    public void gerarNotificacao(String mensagem) {
        System.out.println("Notificação gerada: " + mensagem);
    }

    // Expandir prazo do empréstimo
    public void expandirPrazo(Emprestimo emprestimo, int diasExtras) {
        Date novaDataDevolucao = new Date(emprestimo.getDataDevolucao().getTime() + (diasExtras * 24 * 60 * 60 * 1000L));
        emprestimo.setDataDevolucao(novaDataDevolucao);
        System.out.println("Prazo de devolução expandido para: " + novaDataDevolucao);
    }

    // Encerrar empréstimo
    public void encerrarEmprestimo(Emprestimo emprestimo) {
        emprestimo.setAtivo(false);
        emprestimo.getLivro().setEmprestado(false);
        System.out.println("Empréstimo encerrado para o livro: " + emprestimo.getLivro().getTitulo());
    }

    // Consultar empréstimos pendentes
    public void consultarEmprestimos(boolean aprovado){
        if (aprovado) {
            for (Emprestimo emprestimo : Emprestimo.emprestimosAtivos){
                emprestimo.toString();
            }
        } else {
            for (Emprestimo emprestimo : Emprestimo.emprestimosPendentes){
                emprestimo.toString();
            }
        }
     }
}
