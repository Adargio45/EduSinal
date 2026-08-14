import java.util.List;

public class SistemaEduSinal {

    private final EntradaDados entradaDados;
    private final MotorIndicadores motorIndicadores;

    public SistemaEduSinal() {
        entradaDados = new EntradaDados();
        motorIndicadores = new MotorIndicadores();
    }

    public void executar() {
        exibirCabecalho();

        Turma turma = entradaDados.cadastrarTurma();
        int quantidadeEstudantes = entradaDados.lerQuantidadeEstudantes();

        for (int i = 1; i <= quantidadeEstudantes; i++) {
            Estudante estudante = entradaDados.cadastrarEstudante(i, turma);
            turma.matricular(estudante);
        }

        exibirRelatorio(turma);
        entradaDados.fechar();
    }

    private void exibirCabecalho() {
        System.out.println("=================================");
        System.out.println("           EDUSINAL");
        System.out.println(" Sistema de Indicadores Escolares");
        System.out.println("=================================");
        System.out.println();
    }

    private void exibirRelatorio(Turma turma) {
        System.out.println();
        System.out.println("=================================");
        System.out.println("       RELATORIO DE ATENCAO");
        System.out.println("Turma: " + turma.getNome());
        System.out.println("=================================");

        for (Estudante estudante : turma.getEstudantes()) {
            List<String> motivos = motorIndicadores.verificarAtencao(estudante);

            System.out.println();
            System.out.println("Estudante: " + estudante.getNome());

            if (motivos.isEmpty()) {
                System.out.println("Situacao: NORMAL");
            } else {
                System.out.println("Situacao: EM ATENCAO");
                for (String motivo : motivos) {
                    System.out.println("- " + motivo);
                }
            }
        }
    }
}
