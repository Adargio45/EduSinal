import java.util.ArrayList;
import java.util.List;

public class MotorIndicadores {

    private static final double MEDIA_MINIMA = 5.0;
    private static final double FREQUENCIA_MINIMA = 75.0;

    public List<String> verificarAtencao(Estudante estudante) {
        List<String> motivos = new ArrayList<>();

        if (calcularMedia(estudante) < MEDIA_MINIMA) {
            motivos.add("Baixo desempenho escolar.");
        }

        if (calcularFrequencia(estudante) < FREQUENCIA_MINIMA) {
            motivos.add("Frequencia abaixo de 75%.");
        }

        return motivos;
    }

    private double calcularMedia(Estudante estudante) {
        List<Double> avaliacoes = estudante.getAvaliacoes();
        if (avaliacoes.isEmpty()) {
            return 0;
        }

        double soma = 0;
        for (double nota : avaliacoes) {
            soma += nota;
        }
        return soma / avaliacoes.size();
    }

    private double calcularFrequencia(Estudante estudante) {
        List<Boolean> frequencias = estudante.getFrequencias();
        if (frequencias.isEmpty()) {
            return 0;
        }

        int presencas = 0;
        for (boolean presente : frequencias) {
            if (presente) {
                presencas++;
            }
        }
        return (double) presencas / frequencias.size() * 100;
    }
}
