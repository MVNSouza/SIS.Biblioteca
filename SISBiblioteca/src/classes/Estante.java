package classes;

import java.util.ArrayList;

public class Estante {

    private String genero;
    private String codigoGenero;
    private final ArrayList<Livro> livrosEstante;


    public static ArrayList<Livro> livrosGeral = new ArrayList<>();
    public static ArrayList<Estante> estantes = new ArrayList<>();


    public Estante(String genero, String codigoGenero) {
        livrosEstante = new ArrayList<>();
        this.genero = genero;
        this.codigoGenero = codigoGenero;
    }


    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //      GETTERS & SETTERS
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (!(genero.isBlank())){
            this.genero = genero.strip();
        } else {
            System.out.println("Insira um gênero válido");
        }
    }


    public String getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(String codigoGenero) {
        if (! codigoGenero.isEmpty()){
            this.codigoGenero = codigoGenero;
        } else {
            System.out.println("Insira um código válido");
        }
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          ADICIONAR LIVROS
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public void appendLivro(Livro livro) {
        livrosEstante.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public static void autoAppendEstante(Livro livro) {
        for (Estante estante : estantes){
            if (estante.codigoGenero.equals(livro.getCodigo().substring(0, 3))){
                
            }
        }
    }


    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          REMOVER LIVROS
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public void removerLivro(String titulo) {
        boolean encontrado = false;
        for (Livro livro : livrosEstante) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosEstante.remove(livro);
                System.out.println("Livro removido: " + titulo);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado: " + titulo);
        }
    }


    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //      LISTAR LIVROS (DA ESTANTE)
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public void listarLivros() {
        if (livrosEstante.isEmpty()) {
            System.out.println("A estante está vazia.");
        } else {
            System.out.println("Livros na estante:");
            for (Livro livro : livrosGeral) {
                int num = 1;
                System.out.println("------> º"+ num + ": " + livro.gerarInformação());
                System.out.println("===========================");
            }
        }
    }

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          LISTAR LIVROS GERAIS
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public static void listarLivrosGeral() {
        for (Estante estante : estantes){
            estante.listarLivros();
        }
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          FILTRAGEM DE LIVROS
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


    public static void filtrarLivroPorAutor(String autor){
        String autorMinusculo = autor.toLowerCase();
        if (livrosGeral.isEmpty()){
            System.out.println("Não há livros cadastrados para realizar consulta");
        } else {
            System.out.println("+ Livros encontrados: ");
            int contador = 1;

            for(Livro livro : livrosGeral){
                if ((livro.getAutor().toLowerCase()).equals(autorMinusculo)){
                    System.out.println("Livro nº "+ contador);
                    livro.gerarInformação();
                    System.out.println(">");
                    contador ++;
                }
            }

        }
    }

    public static void filtrarLivroPorTitulo(String titulo){
        String tituloMinusculo = titulo.toLowerCase();
        if (livrosGeral.isEmpty()){
            System.out.println("Não há livros cadastrados para realizar consulta");
        } else {
            System.out.println("+ Livros encontrados: ");
            int contador = 1;

            for(Livro livro : livrosGeral){
                if ((livro.getTitulo().toLowerCase()).equals(tituloMinusculo)){
                    System.out.println("Livro nº "+ contador);
                    livro.gerarInformação();
                    System.out.println(">");
                    contador ++;
                }
            }

        }
    }

    public static void filtrarLivroPorCodigo(String codigo){
        if (livrosGeral.isEmpty()){
            System.out.println("Não há livros cadastrados para realizar consulta");
        } else {
            System.out.println("+ Livros encontrados: ");
            int contador = 1;

            for(Livro livro : livrosGeral){
                if (livro.getCodigo().equals(codigo)){
                    System.out.println("Livro nº "+ contador);
                    livro.gerarInformação();
                    System.out.println(">");
                    contador ++;
                }
            }

        }
    }



    @Override
    public String toString() {
        String s = ("Gênero: " + genero + "\nCódigo: " + codigoGenero);
        return s;
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          LISTAR ESTANTES
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public static void listarEstantes(){
        for(Estante estante : estantes){
            System.out.println(estante.toString());
        }
    }

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          FILTRAR ESTANTES   
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public static void filtrarEstantePorCodigo(String codigo){
        for (Estante estante : estantes) {
            if (estante.codigoGenero.equals(codigo)) {
                System.out.println(estante.toString());
            }
            
        }
    }

    public static void filtrarEstantePorGenero (String genero) {
        for (Estante estante : estantes) {
            if (estante.genero.equals(genero)) {
                System.out.println(estante.toString());
            }
            
        }
    }



}


