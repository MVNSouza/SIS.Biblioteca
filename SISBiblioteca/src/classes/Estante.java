package classes;

import java.util.ArrayList;

public class Estante {
    private String genero;
    private String codigoGenero;
    private ArrayList<Livro> livros;

    public Estante(String genero, String codigoGenero) {
        this.genero = genero;
        this.codigoGenero = codigoGenero;
        this.livros = new ArrayList<>();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(String codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
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

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("A estante está vazia.");
        } else {
            System.out.println("Livros na estante:");
            for (Livro livro : livros) {
                System.out.println("- " + livro);
            }
        }
    }

}

