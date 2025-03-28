
package classes;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Controlador {
    public static Scanner input = new Scanner(System.in);
    static Funcionario f = new Funcionario("admin", "123", "marcos@email.com");
    static Cliente.Login l = new Cliente.Login("marcos@email.com", "123");


    public static Livro varreduraLivro(String codigo) {
        for (Livro livro : Estante.livrosGeral){
            if (livro.getCodigo().equals(codigo)){
                return livro;
            }
        }
                return null;
        
    }
    public static Estante varreduraEstante(String codigo) {
        for (Estante estante : Estante.estantes){
            if (estante.getCodigoGenero().equals(codigo)){
                return estante;
            }
        }
                return null;
        
    }

    public static Emprestimo varreduraEmprestimo(int num) {
        for (Emprestimo emprestimo : Emprestimo.emprestimos){
            if (emprestimo.getNum() == num){
                return emprestimo;
            }
        }
            return null;
    }
    
    public static void menuInicial(){
        while (true) {
            JOptionPane.showMessageDialog(null, "Bem-vindo!", "SIS Biblioteca", 1);
            
            int opcao = 0;
            String o = JOptionPane.showInputDialog(null, """
                1 - Listar livros
                2 - Listar estantes
                3 - Fazer login
                4 - Cadastrar
                0 - Sair
                """, "Opções", 1);
            boolean sair = false;

            try {
                opcao = Integer.parseInt(o);
                switch (opcao){
                    case 1 -> Estante.listarLivrosGeral();
                    case 2 -> Estante.listarEstantes();
                    case 3 -> {
                        int opcaoLogin = -1;
                        boolean executar = false;
                        String oL = "";
                        do {
                            oL = JOptionPane.showInputDialog(null, """
                                               Deseja fazer login de funcionário ou usuário comum?
                                               1 - Funcionário
                                               0 - Usuário""", "Opção de login", 1);
                            if (!oL.equals("1") || !oL.equals("0")){
                                JOptionPane.showMessageDialog(null, "Valor inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                                executar = true;
                            }
                        } while (executar);
                        try {
                            opcaoLogin = Integer.parseInt(oL);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Insira um opção válida!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        System.out.println("Email: ");
                        String email = input.next();
                        System.out.println("Senha: ");
                        String senha = input.next();
                        classes.Cliente.login(email, senha, opcaoLogin);
                        
                    }
    
                    case 4 -> {
                        System.out.println("AUTO-CADASTRO DE USUÁRIO: ");
                        Cliente.cadastro(0);
                        
                    }
                    case 0 -> { sair = true; break; } 
    
                }
            } catch (NumberFormatException e) {
                if (o == null) {
                    break;
                }
            }
            if (sair) {
                break;
            }
        }

    }


public static void menuFuncionario(Funcionario func) {

    while (true) {
        System.out.println("Bem vindo, " + func.getNome() + "!");
        System.out.println("Solicitações de empréstimo pendentes: " + Emprestimo.numEmprestimosPendentes);
        System.out.println("""
                Opções:
                1 - Consultar livros
                2 - Consultar estantes
                3 - Adicionar usuários
                4 - Gerenciar livros
                5 - Gerenciar estantes
                6 - Gerenciar empréstimos
                0 - Sair
            """);
        int opcao = input.nextInt();

        switch (opcao) {
            case 1 -> Cliente.consultarLivros(); // Presume que consultarLivros() é estático na classe Cliente
            case 2 -> Cliente.consultarEstantes(); // Presume que consultarEstantes() é estático na classe Cliente
            case 3 -> func.adicionarUsuario();
            case 4 -> gerenciarLivros(func, input);
            case 5 -> gerenciarEstantes(func, input);
            case 6 -> gerenciarEmprestimos(func, input);
            case 0 -> {
                System.out.println("Encerrando o menu do funcionário...");
                return;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
}


public static void menuUsuario(Usuario user) {
    while (true) {
        System.out.println("Bem-vindo, " + user.getNome() + "!");
        System.out.println("""
                Opções:
                1 - Consultar livros
                2 - Consultar estantes
                3 - Solicitar empréstimo
                0 - Sair
                """);
        String opcao = input.nextLine();

        switch (opcao) {
            case "1" -> {
                System.out.println("Consulta de Livros:");
                Estante.listarLivrosGeral();
            }

            case "2" -> {
                System.out.println("Consulta de Estantes:");
                Estante.listarEstantes();
            }

            case "3" -> {
                System.out.println("Digite o código do livro que deseja solicitar:");
                String codigoLivro = input.nextLine();

                // Verifica se o livro existe
                Livro livroParaEmprestimo = null;
                for (Livro livro : Estante.livrosGeral) {
                    if (livro.getCodigo().equalsIgnoreCase(codigoLivro)) {
                        livroParaEmprestimo = livro;
                        break;
                    }
                }

                if (livroParaEmprestimo != null) {
                    user.solicitarEmprestimo(livroParaEmprestimo);
                } else {
                    System.out.println("Livro não encontrado com o código informado.");
                }
            }

            case "0" -> {
                System.out.println("Saindo do menu. Até logo!");
                return;
            }

            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
}


    public static void iniciar(){
        Cliente.loginsF.add(l);
        Cliente.loginsFunc.put(f, l);
        
        menuInicial();
    }
    
    

    //  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //          MÉTODOS COMPLEMENTARES
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    private static void gerenciarLivros(Funcionario func, Scanner input) {
        System.out.println("""
                Gerenciar Livros:
                1 - Adicionar Livro
                2 - Editar Livro
                3 - Remover Livro
                0 - Voltar
            """);
        int escolha = input.nextInt();
        input.nextLine(); // Consumir quebra de linha
    
        switch (escolha) {
            case 1 -> {
                System.out.println("Digite o título do livro:");
                String titulo = input.nextLine();
                System.out.println("Digite o código do livro:");
                String codigo = input.nextLine();
                System.out.println("Digite o autor do livro:");
                String autor = input.nextLine();
                func.adicionarLivro(titulo, codigo, autor);
            }
            case 2 -> {
                // Exemplo de edição - é necessário localizar o livro pelo código
                System.out.println("Digite o código do livro a ser editado:");
                String codigoEditar = input.nextLine();
                Livro livroEditar = varreduraLivro(codigoEditar); // Supõe método estático de busca
                if (livroEditar != null) {
                    System.out.println("Digite o novo título:");
                    String novoTitulo = input.nextLine();
                    System.out.println("Digite o novo autor:");
                    String novoAutor = input.nextLine();
                    func.editarLivro(livroEditar, novoTitulo, novoAutor);
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }
            case 3 -> {
                System.out.println("Digite o código do livro a ser removido:");
                String codigoRemover = input.nextLine();
                Livro livroRemover = varreduraLivro(codigoRemover);
                if (livroRemover != null) {
                    Estante estante = varreduraEstante(codigoRemover); // Supõe método para localizar estante
                    if (estante != null) {
                        func.removerLivro(livroRemover, estante);
                    } else {
                        System.out.println("Estante não encontrada para o livro.");
                    }
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Opção inválida.");
        }
    }
    
    public static void gerenciarEstantes(Funcionario func, Scanner input) {
        System.out.println("Digite o código da estante que deseja gerenciar:");
        String codigoEstante = input.nextLine();
    
        // Procurar a estante pelo código fornecido
        Estante estanteSelecionada = null;
        for (Estante estante : Estante.estantes) {
            if (estante.getCodigoGenero().equalsIgnoreCase(codigoEstante)) {
                estanteSelecionada = estante;
                break;
            }
        }
    
        if (estanteSelecionada == null) {
            System.out.println("Nenhuma estante encontrada com o código: " + codigoEstante);
            return;
        }
    
        System.out.println("Gerenciando a estante: ");
        System.out.println(estanteSelecionada.toString());
    
        while (true) {
            System.out.println("\nEscolha uma opção para gerenciar a estante:");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Remover Livro");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Editar Gênero da Estante");
            System.out.println("5 - Voltar ao Menu Principal");
    
            String opcao = input.nextLine();
    
            switch (opcao) {
                case "1" -> {
                    System.out.println("Digite o título do livro:");
                    String titulo = input.nextLine();
    
                    System.out.println("Digite o autor do livro:");
                    String autor = input.nextLine();
    
                    System.out.println("Digite o código do livro:");
                    String codigoLivro = input.nextLine();
    
                    Livro novoLivro = new Livro(titulo, codigoLivro, autor);
                    estanteSelecionada.appendLivro(novoLivro);
                    Estante.livrosGeral.add(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                }
    
                case "2" -> {
                    System.out.println("Digite o título do livro a ser removido:");
                    String tituloParaRemover = input.nextLine();
                    estanteSelecionada.removerLivro(tituloParaRemover);
                }
    
                case "3" -> estanteSelecionada.listarLivros();
    
                case "4" -> {
                    System.out.println("Digite o novo gênero da estante:");
                    String novoGenero = input.nextLine();
                    estanteSelecionada.setGenero(novoGenero);
                    System.out.println("Gênero atualizado com sucesso!");
                }
    
                case "5" -> {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
    
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    

    private static void gerenciarEmprestimos(Funcionario func, Scanner input) {
        System.out.println("""
                Gerenciar Empréstimos:
                1 - Consultar Empréstimos Pendentes
                2 - Consultar Empréstimos Aprovados
                3 - Aprovar Empréstimo
                4 - Encerrar Empréstimo
                5 - Expandir Prazo do Empréstimo
                0 - Voltar
            """);
        int escolha = input.nextInt();
        input.nextLine(); // Consumir quebra de linha

        switch (escolha) {
            case 1 -> func.consultarEmprestimos(false); // Lista empréstimos pendentes
            case 2 -> func.consultarEmprestimos(true); // Lista empréstimos aprovados
            case 3 -> {
                System.out.println("Digite o ID do empréstimo a ser aprovado:");
                int idAprovar = input.nextInt();
                Emprestimo emprestimoAprovar = varreduraEmprestimo(idAprovar); // Supõe método estático de busca
                if (emprestimoAprovar != null) {
                    func.aprovarEmprestimo(emprestimoAprovar);
                } else {
                    System.out.println("Empréstimo não encontrado.");
                }
            }
            case 4 -> {
                System.out.println("Digite o ID do empréstimo a ser encerrado:");
                int idEncerrar = input.nextInt();
                Emprestimo emprestimoEncerrar = varreduraEmprestimo(idEncerrar);
                if (emprestimoEncerrar != null) {
                    func.encerrarEmprestimo(emprestimoEncerrar);
                } else {
                    System.out.println("Empréstimo não encontrado.");
                }
            }
            case 5 -> {
                System.out.println("Digite o ID do empréstimo:");
                int idExpandir = input.nextInt();
                System.out.println("Digite o número de dias adicionais:");
                int diasExtras = input.nextInt();
                Emprestimo emprestimoExpandir = varreduraEmprestimo(idExpandir);
                if (emprestimoExpandir != null) {
                    func.expandirPrazo(emprestimoExpandir, diasExtras);
                } else {
                    System.out.println("Empréstimo não encontrado.");
                }
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Opção inválida.");
        }
    }

   
    




}