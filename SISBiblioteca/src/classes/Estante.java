package classes;

import java.util.ArrayList;

public class Estante {

    private String genero;
    private String titulo;
    private String codigoGenero;
    public static ArrayList<Livro> livros = new ArrayList<>();
    public static ArrayList<Estante> estantes = new ArrayList<>();


    public Estante(String genero, String titulo, String codigoGenero) {
        this.genero = genero;
        this.titulo = titulo;
        this.codigoGenero = codigoGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(String codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void removerLivro(String titulo) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(livro);
                System.out.println("Livro removido: " + titulo);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado: " + titulo);
        }
    }

    public static void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("A estante está vazia.");
        } else {
            System.out.println("Livros na estante:");
            for (Livro livro : livros) {
                int num = 1;
                System.out.println("------> º"+ num + ": " + livro.gerarInformação());
                System.out.println("===========================");
            }
        }
    }

    public void listarEstantes(){
        for(Estante estante : estantes){
            System.out.println(estante.toString());
        }
    }

    public static void filtrarPorAutor(String autor){
        String autorMinusculo = autor.toLowerCase();
        if (livros.isEmpty()){
            System.out.println("Não há livros cadastrados para realizar consulta");
        } else {
            System.out.println("+ Livros encontrados: ");
            int contador = 1;

            for(Livro livro : livros){
                if ((livro.getAutor().toLowerCase()).equals(autorMinusculo)){
                    System.out.println("Livro nº "+ contador);
                    livro.gerarInformação();
                    System.out.println(">");
                    contador ++;
                }
            }

        }
    }

    public static void filtrarPorTitulo(String titulo){
        String tituloMinusculo = titulo.toLowerCase();
        if (livros.isEmpty()){
            System.out.println("Não há livros cadastrados para realizar consulta");
        } else {
            System.out.println("+ Livros encontrados: ");
            int contador = 1;

            for(Livro livro : livros){
                if ((livro.getTitulo().toLowerCase()).equals(tituloMinusculo)){
                    System.out.println("Livro nº "+ contador);
                    livro.gerarInformação();
                    System.out.println(">");
                    contador ++;
                }
            }

        }
    }

    public static void filtrarPorCodigo(String codigo){
        if (livros.isEmpty()){
            System.out.println("Não há livros cadastrados para realizar consulta");
        } else {
            System.out.println("+ Livros encontrados: ");
            int contador = 1;

            for(Livro livro : livros){
                if (livro.getCodigo().equals(codigo)){
                    System.out.println("Livro nº "+ contador);
                    livro.gerarInformação();
                    System.out.println(">");
                    contador ++;
                }
            }

        }
    }


}


