package pissuti.nathalia.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import pissuti.nathalia.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        for(Aluno a : alunos) {
            if(a.getId() == aluno.getId()) {
                int posicao = alunos.indexOf(a);
                alunos.set(posicao, aluno);
                break;
            }
        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

}
