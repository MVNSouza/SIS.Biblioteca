package classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Database {
    private Funcionario admin;
    private HashMap<String, String> logins;
    private ArrayList<Estante> estantes = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public Database(){
        admin = new Funcionario("admin", "1", "123456789", "example@gmail.com");
        Estante estanteGeral = new Estante("Geral", "999");
        Estante estanteBase = new Estante("Ficção", "001");
        estantes.add(estanteBase);
    }

    public Funcionario getAdmin(){
        return admin;
    }

    public void adicionarEmEstante(Livro livro, String codigo){
        Estante estanteCompativel = null;
        for (Estante estante : estantes) {
            if (estante.getCodigoGenero().equals(codigo)){
                estanteCompativel = estante;
                break;
            } else {
                estanteCompativel = new Estante("Nenhum", "000");
            }
            
        }
        
        String opcao = "N";
        
        if (estanteCompativel.getCodigoGenero().equals(codigo.substring(0, 3))){
            estanteCompativel.adicionarLivro(livro);
            System.out.println("Livro adicionado à estante");
        } else if (!(estanteCompativel.getCodigoGenero().equals(codigo.substring(0, 3)))){
            System.out.print("Esse código não condiz com nenhuma estante, deseja adicionar na geral? [S / N]");
            opcao = input.next();
            if (opcao.equals("S")){
                estantes.get(0).adicionarLivro(livro);;
            } else {
                System.out.println("Livro não adicionado em nenhuma estante");
            }
        }
        
        

    }

    public ArrayList<Estante> getEstantes(){
        return estantes;
    }
}
