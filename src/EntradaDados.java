import java.util.Scanner;

public class EntradaDados {

    private final Scanner scanner;

    public EntradaDados() {
        scanner = new Scanner(System.in);
    }

    public Turma cadastrarTurma() {
        int id = lerInteiro("Digite o ID da turma: ");
        String nome = lerTexto("Digite o nome da turma: ");
        return new Turma(id, nome);
    }

    public int lerQuantidadeEstudantes() {
        return lerInteiro("Digite a quantidade de estudantes: ");
    }

    public Estudante cadastrarEstudante(int id, Turma turma) {
        System.out.println();
        System.out.println("----- Estudante " + id + " -----");

        String nome = lerTexto("Nome: ");
        Estudante estudante = new Estudante(id, nome, turma);

        int quantidadeAvaliacoes = lerInteiro("Quantas avaliacoes deseja cadastrar? ");
        for (int i = 1; i <= quantidadeAvaliacoes; i++) {
            estudante.adicionarAvaliacao(lerNota("Digite a nota da avaliacao " + i + ": "));
        }

        int quantidadeAulas = lerInteiro("Quantas aulas deseja registrar? ");
        for (int i = 1; i <= quantidadeAulas; i++) {
            boolean presente = lerRespostaSimNao(
                    "O estudante esteve presente na aula " + i + "? (S/N): ");
            estudante.adicionarFrequencia(presente);
        }

        return estudante;
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(texto);
                if (valor >= 0) {
                    return valor;
                }
            } catch (NumberFormatException ignored) {
                // A mensagem abaixo orienta o usuario a tentar novamente.
            }
            System.out.println("Digite um numero inteiro maior ou igual a zero.");
        }
    }

    private double lerNota(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim().replace(',', '.');
            try {
                double nota = Double.parseDouble(texto);
                if (nota >= 0 && nota <= 10) {
                    return nota;
                }
            } catch (NumberFormatException ignored) {
                // A mensagem abaixo orienta o usuario a tentar novamente.
            }
            System.out.println("Digite uma nota entre 0 e 10.");
        }
    }

    private String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Este campo nao pode ficar vazio.");
        }
    }

    private boolean lerRespostaSimNao(String mensagem) {
        while (true) {
            String resposta = lerTexto(mensagem);
            if (resposta.equalsIgnoreCase("S")) {
                return true;
            }
            if (resposta.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Responda somente com S ou N.");
        }
    }

    public void fechar() {
        scanner.close();
    }
}
