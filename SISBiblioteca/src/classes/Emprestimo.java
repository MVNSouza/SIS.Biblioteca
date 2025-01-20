
package classes;
import java.util.Date;


public class Emprestimo{
private Livro livro;
private Usuario usuario;
private Funcionario funcionario;
private Date dataInicioEmprestimo;
private Date dataDevolucao;
private boolean ativo;

public Emprestimo(Livro livro, Usuario usuario, Funcionario funcionario, Date dataEmprestimo, Date devolucao, boolean ativo){
    this.livro = livro;
    this.usuario = usuario;
    this.funcionario = funcionario;
    this.dataInicioEmprestimo = dataEmprestimo;
    this.dataDevolucao = devolucao;
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
    return dataInicioEmprestimo;
}

public boolean getativo(){
    return ativo;
}

public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void encerrarEmprestimo() {
        if (this.ativo) {
            this.ativo = false;
            System.out.println("Empréstimo do livro '" + livro + "' encerrado com sucesso.");
        } else {
            System.out.println("O empréstimo já está encerrado.");
        }
    }


    @Override
    public String toString(){
        return "Emprestimo {" +
                "Livro: " + livro +
                ", Usuario: " + usuario +
                ", Funcionario: " + funcionario +
                ", Data de Emprestimo: " + dataInicioEmprestimo +
                ", Situação: " + (ativo? "Empréstimo ativo" : "Devolvido em" + dataDevolucao) +
                "}";
    }


}


