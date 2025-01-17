package classes;

public class Controlador {
    
    public static void main(String[] args) {
        Database db = new Database();
        Database database = db;
        db.getAdmin().cadastrarLivro(database);
        for (Estante estante : db.getEstantes()){
            estante.listarLivros();
        }
        
    }    
}
