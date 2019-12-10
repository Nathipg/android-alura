package pissuti.nathalia.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import pissuti.nathalia.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
