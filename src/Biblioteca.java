import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public String realizarEmprestimo(int idLivro, String nomeUsuario) {
        Optional<Livro> livroOpt = livros.stream().filter(l -> l.getId() == idLivro && l.isDisponivel()).findFirst();
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livro.setDisponivel(false);
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
            emprestimos.add(emprestimo);
            return "O livro '" + livro.getTitulo() + "' foi emprestado para " + nomeUsuario + " com sucesso!";
        } else {
            return "Livro não disponível para empréstimo.";
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}