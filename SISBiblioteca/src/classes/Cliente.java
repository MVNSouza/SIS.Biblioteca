package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {
    protected String nome, id, senha, email;
    public static ArrayList<Login> loginsU = new ArrayList<>();
    public static ArrayList<Login> loginsF = new ArrayList<>();
    public static HashMap<Funcionario, Login> loginsFunc = new HashMap<>();
    public static HashMap<Usuario, Login> loginsUser = new HashMap<>();

    // Classe para logins
    public static class Login {
        String email, senha;

        public Login(String email, String senha){
            this.email = email;
            this.senha = senha;
        }
    }

    public static void login(String email, String senha, int opcao){
        // Opção == 1 --> Funcionário; Opção == 0 --> Usuário
        Login l = new Login(email, senha);
        boolean loginUsuarioExiste = false;
        boolean loginFuncionarioExiste = false;

        // Varredura por logins
        for (Login login : loginsU){
            if (login == l){
                loginUsuarioExiste = true;
            }
        }
        for (Login login : loginsF){
            if (login == l){
                loginFuncionarioExiste = true;
            }
        }


        // Associação de conta
        if ((loginFuncionarioExiste && opcao == 1) || (loginUsuarioExiste && opcao == 0)){
            if (opcao == 1 ){
                for (Map.Entry<Funcionario, Login> entry: loginsFunc.entrySet()){
                    if (entry.getValue() == l) {
                        System.out.println("Bem vindo!");
                        Controlador.menuFuncionario(entry.getKey());
                    }

                }
            } else if (opcao == 0) {

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
