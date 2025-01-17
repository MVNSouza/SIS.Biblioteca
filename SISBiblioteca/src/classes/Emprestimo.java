package classes;

import java.util.Date;

public class Emprestimo{
private Livro livro;
private Usuario usuario;
private Funcionario funcionario;
private Date dataEmprestimo;
private boolean ativo;

public Emprestimo(Livro livro, Usuario usuario, Funcionario funcionario, Date dataEmprestimo, boolean ativo){
    this.livro = livro;
    this.usuario = usuario;
    this.funcionario = funcionario;
    this.dataEmprestimo = dataEmprestimo;
    this.ativo = ativo;
}

public Livro getLivro(){
    return livro;
}

public Usuario getUsuario(){
    return usuario;
}

public Funcionario getFuncionario(){
    return funcionario;
}

public Date getdataEmprestDate(){
    return dataEmprestimo;
}

public boolean getativo(){
    return ativo;
}

}