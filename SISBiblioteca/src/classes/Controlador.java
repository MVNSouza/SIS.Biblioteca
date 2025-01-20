package classes;

public class Controlador {

    
    
    public static void menuInicial(){
        classes.Cliente.login(email, senha);
        classes.Cliente.autocadastro(email, senha);
    }

    public static void menuFuncionario(Funcionario func){

    }

    public static void menuUsuario(Usuario user){

    }

    public static void iniciar(){
        menuInicial();
    }
}
