import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Turma {

    private final int id;
    private final String nome;
    private final List<Estudante> estudantes;

    public Turma(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.estudantes = new ArrayList<>();
    }

    public void matricular(Estudante estudante) {
        estudantes.add(estudante);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getEstudantes() {
        return Collections.unmodifiableList(estudantes);
    }
}
