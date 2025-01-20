package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {
    // Váriaveis para sub-classes
    protected String nome, senha, email;
    protected int id;


    public static ArrayList<Login> loginsU = new ArrayList<>();
    public static ArrayList<Login> loginsF = new ArrayList<>();
    public static HashMap<Funcionario, Login> loginsFunc = new HashMap<>();
    public static HashMap<Usuario, Login> loginsUser = new HashMap<>();


    // %%%%%%%%%%%%%%%%% Classe para logins
    public static class Login {
        String email, senha;

        public Login(String email, String senha){
            this.email = email;
            this.senha = senha;
        }
    }

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    // Método para varredura
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public static boolean varreduraLogin(Login l, ArrayList<Login> array){

        for (Login login : array){
            return login.email.equals(l.email) && login.senha.equals(l.senha);
        }
            return false;
    }


    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    // Método para login
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public static void login(String email, String senha, int opcao){
        // Opção == 1 --> Funcionário; Opção == 0 --> Usuário
        
        Login l = new Login(email, senha);
        boolean loginUsuarioExiste = varreduraLogin(l, loginsU);
        boolean loginFuncionarioExiste = varreduraLogin(l, loginsF);
        
        // Associação de conta
        if ((loginFuncionarioExiste && opcao == 1) || (loginUsuarioExiste && opcao == 0)){
            if (opcao == 1 ){
                for (HashMap.Entry<Funcionario, Login> entry: loginsFunc.entrySet()){
                    if (entry.getValue().email.equals(l.email) && entry.getValue().senha.equals(l.senha)) {
                        System.out.println("Bem vindo, " + entry.getKey().getNome());
                        Controlador.menuFuncionario(entry.getKey());
                    }

                }
            } else if (opcao == 0) {
                for (HashMap.Entry<Usuario, Login> entry: loginsUser.entrySet()){
                    if (entry.getValue().email.equals(l.email) && entry.getValue().senha.equals(l.senha)) {
                        System.out.println("Bem vindo!");
                        Controlador.menuUsuario(entry.getKey());
                    }

                }

            }

        } else {
            
            switch (opcao) {
                case 1 -> // Erro func
                     System.out.println("\n ---- Nenhum funcionário encontrado com os dados informados \n");
                case 0 -> // Erro user
                    System.out.println("\n ---- Nenhum usuário encontrado com os dados informados \n");
                default -> System.out.println("\n Erro indefinido. \n");
            }
        }
        
    }

    public static void autocadastro(String email, String senha){

    }

}
