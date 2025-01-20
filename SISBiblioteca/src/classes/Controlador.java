package classes;

import java.util.Scanner;

public class Controlador {
    public static Scanner input = new Scanner(System.in);
    static Funcionario f = new Funcionario("admin", 1, "123", "marcos@email.com");
    static Cliente.Login l = new Cliente.Login("marcos@email.com", "123");
    
    
    public static void menuInicial(){
        Cliente.loginsF.add(l);
        Cliente.loginsFunc.put(f, l);
        String email = input.next();
        String senha = input.next();
        classes.Cliente.login(email, senha, 1);

    }

    public static void menuFuncionario(Funcionario func){

    }

    public static void menuUsuario(Usuario user){

    }

    public static void iniciar(){
        menuInicial();
    }
}
