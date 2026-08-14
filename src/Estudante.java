import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estudante {

    private final int id;
    private final String nome;
    private final Turma turma;
    private final List<Double> avaliacoes;
    private final List<Boolean> frequencias;

    public Estudante(int id, String nome, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
        this.avaliacoes = new ArrayList<>();
        this.frequencias = new ArrayList<>();
    }

    public void adicionarAvaliacao(double nota) {
        avaliacoes.add(nota);
    }

    public void adicionarFrequencia(boolean presente) {
        frequencias.add(presente);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public List<Double> getAvaliacoes() {
        return Collections.unmodifiableList(avaliacoes);
    }

    public List<Boolean> getFrequencias() {
        return Collections.unmodifiableList(frequencias);
    }
}
