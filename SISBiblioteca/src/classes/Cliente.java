package classes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {
    // Váriaveis para sub-classes
    protected String nome, senha, email;
    protected int id;

    public static int logins = 0;
    public static ArrayList<Login> loginsU = new ArrayList<>();
    public static ArrayList<Login> loginsF = new ArrayList<>();
    public static HashMap<Funcionario, Login> loginsFunc = new HashMap<>();
    public static HashMap<Usuario, Login> loginsUser = new HashMap<>();

    static Scanner input = new Scanner(System.in);


    // %%%%%%%%%%%%%%%%% Classe para logins
    public static class Login {
        String email, senha;

        public Login(String email, String senha){
            this.email = email;
            this.senha = senha;
        }
    }

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //                   Método para varredura
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public static boolean varreduraLogin(Login l, ArrayList<Login> array, String tipo){

        if (tipo.equals("all")){
            for (Login login : array){
                return login.email.equals(l.email) && login.senha.equals(l.senha);
            }
                return false;

        } else if (tipo.equals("email")){
            for (Login login : array){
                return login.email.equals(l.email);
            } 
                return false;
        } else {
            return false;
        }
    }


    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //                  Método para login
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public static void login(String email, String senha, int opcao){
        // Opção == 1 --> Funcionário; Opção == 0 --> Usuário
        
        Login l = new Login(email, senha);
        boolean loginUsuarioExiste = varreduraLogin(l, loginsU, "all");
        boolean loginFuncionarioExiste = varreduraLogin(l, loginsF, "all");
        
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

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //              Método para cadastro
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public static void cadastro(int opcao){
        System.out.println("Insira seus dados: \n");
        System.out.print("Nome completo: ");
        String n = input.nextLine();
        System.out.print("\nEmail: ");
        String e = input.nextLine();
        System.out.print("\nSenha: ");
        String s = input.nextLine();

        if (opcao == 1){
            Funcionario f = new Funcionario(n, e, s);
            Login log = new Login(e, s);
            if(varreduraLogin(log, loginsF, "email")){
                System.out.println("Já existe um funcionário cadastrado com o email informado.");
            } else {

                loginsF.add(log);
                loginsFunc.putIfAbsent(f, log);
                System.out.println("Funcionário >>"+ f.getNome() + "<< cadastrado.");
            
            }
        
        } else if (opcao == 0){
            System.out.print("\nEndereço: ");
            String end = input.nextLine();
            
            Usuario u = new Usuario(n, s, e, end);
            Login log = new Login(e, s);
            
            
            if(varreduraLogin(log, loginsU, "email")){
                System.out.println("Já existe um usuário cadastrado com o email informado.");
            } else {
                loginsU.add(log);
                loginsUser.put(u, log);
                System.out.println("Usuário >>"+ u.getNome() + "<< cadastrado.");
            }
        }


    }

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //         Listagem para arrays de logins
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public static void listarArrayLogin(ArrayList<Login> array){
        System.out.println("============ Logins =============");
        for(Login login : array){
            System.out.println("Email: " + login.email
            + "Senha: " + login.senha);
        }
    }

}
