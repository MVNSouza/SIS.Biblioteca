package classes;

import java.util.Scanner;

public class Controlador {
    public static Scanner input = new Scanner(System.in);
    static Funcionario f = new Funcionario("admin", "123", "marcos@email.com");
    static Cliente.Login l = new Cliente.Login("marcos@email.com", "123");


    public static Livro varreduraLivro(String codigo) {
        for (Livro livro : Estante.livrosGeral){
            if (livro.getCodigo().equals(codigo)){
                return livro;
            }
        }
                return null;
        
    }

    public static Emprestimo varreduraEmprestimo(int num) {
        for (Emprestimo emprestimo : Emprestimo.emprestimos){
            if (emprestimo.getNum() == num){
                return emprestimo;
            }
        }
            return null;
    }
    
    public static void menuInicial(){
        while (true) {
            System.out.println("Bem vindo ao Sistema de Biblioteca!" +
                        "\nOpções:" +
                        "\n\n1 - Consultar livros\n2 - Consultar estantes \n3 - Fazer login\n4 - Se cadastrar\n0 - Sair");
            
            int opcao = input.nextInt();
            boolean sair = false;
            switch (opcao){
                case 1:
                    Estante.listarLivrosGeral();
                case 2:
                    Estante.listarEstantes();
                case 3:
                    System.out.println("==== LOGIN ====\nDeseja fazer login de funcionário ou usuário comum?"
                    + "1 - Funcionário\n 2 - Usuário");
                    String email = input.next();
                    String senha = input.next();
                    classes.Cliente.login(email, senha, 1);

                case 4:
                    System.out.println("AUTO-CADASTRO DE USUÁRIO: ");
                    Cliente.cadastro(0);
                case 0: 
                    sair = true;
            }
            if (sair) {
                break;
            }
        }

    }

    public static void menuFuncionario(Funcionario func){
        System.out.println("");
    }

    public static void menuUsuario(Usuario user){

    }

    public static void iniciar(){
        Cliente.loginsF.add(l);
        Cliente.loginsFunc.put(f, l);
        
        menuInicial();
    }
}
