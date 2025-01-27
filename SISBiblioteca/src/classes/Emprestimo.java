
package classes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Emprestimo{
private final Livro livro;
private final Usuario usuario;
private Funcionario funcionario;
private Date dataInicioEmprestimo;
private Date dataDevolucao;
private boolean ativo;

public static ArrayList<Emprestimo> emprestimosAtivos = new ArrayList<>();
public static ArrayList<Emprestimo> emprestimosPendentes = new ArrayList<>();

public Emprestimo(Livro livro, Usuario usuario, Funcionario funcionario, Date dataEmprestimo, Date devolucao, boolean ativo){
    this.livro = livro;
    this.usuario = usuario;
    this.funcionario = funcionario;
    this.dataInicioEmprestimo = dataEmprestimo;
    this.dataDevolucao = devolucao;
    this.ativo = ativo;
}

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

public void getLivro(){
    livro.gerarInformação();
}

public Usuario getUsuario(){
    return usuario;
}

public Funcionario getFuncionario(){
    return funcionario;
}

public Date getdataInicio(){
    return dataInicioEmprestimo;
}

public boolean getativo(){
    return ativo;
}

public Date getDataDevolucao(){
    return dataDevolucao;
}

public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void encerrarEmprestimo() {
        if (this.ativo) {
            this.ativo = false;
            System.out.println("Empréstimo do livro '" + livro + "' encerrado com sucesso.");
            emprestimosAtivos.remove(this);
        } else {
            System.out.println("O empréstimo já está encerrado.");
        }
    }


    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String dataInicio = (dataInicioEmprestimo != null) ? dateFormat.format(dataInicioEmprestimo) : "Não especificada";
        String dataDevolucaoStr = (dataDevolucao != null) ? dateFormat.format(dataDevolucao) : "Não especificada";

        return "Empréstimo {" +
                "\n  Livro: " + (livro != null ? livro.toString() : "Não especificado") +
                "\n  Usuário: " + (usuario != null ? usuario.toString() : "Não especificado") +
                "\n  Funcionário: " + (funcionario != null ? funcionario.toString() : "Não especificado") +
                "\n  Data de Início do Empréstimo: " + dataInicio +
                "\n  Data de Devolução: " + dataDevolucaoStr +
                "\n  Ativo: " + (ativo ? "Sim" : "Não") +
                "\n}";
    }

    public static void appendEmprestimoPendente(Emprestimo emprestimo){
        emprestimosPendentes.add(emprestimo);
        System.out.println("Empréstimo registrado como pendente.");
    }

    public static void aprovarEmprestimo(int index){
        emprestimosAtivos.add(emprestimosPendentes.get(index));
        System.out.println("Empréstimo aprovado!");
    }

}


