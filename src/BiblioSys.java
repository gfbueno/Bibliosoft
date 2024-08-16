import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BiblioSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // Adicionando livros e autores diretamente para teste
        Autor autor1 = new Autor(1, "George R. R. Martin", LocalDate.of(2018, 11, 20));
        Autor autor2 = new Autor(2, "J.K. Rowling", LocalDate.of(1965, 7, 31));


        Livro livro1 = new Livro(1, "Fogo & Sangue – Volume 1", autor1);
        Livro livro2 = new Livro(2, "Harry Potter e a Pedra Filosofal", autor2);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        while (true) {
            System.out.println("Gostaria de ver os livros disponíveis? (SIM/NAO)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("SIM")) {
                List<Livro> disponiveis = biblioteca.listarLivrosDisponiveis();
                if (disponiveis.isEmpty()) {
                    System.out.println("Nenhum livro disponível para empréstimo.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (Livro livro : disponiveis) {
                        System.out.println(livro);
                    }
                    System.out.println("Escolha o id do livro que deseja emprestar:");
                    int idLivro = Integer.parseInt(scanner.nextLine());

                    System.out.println("Insira seu nome:");
                    String nomeUsuario = scanner.nextLine();

                    String mensagem = biblioteca.realizarEmprestimo(idLivro, nomeUsuario);
                    System.out.println(mensagem);
                }
            } else {
                System.out.println("Aplicação encerrada.");
                break;
            }
        }

        scanner.close();
    }
}