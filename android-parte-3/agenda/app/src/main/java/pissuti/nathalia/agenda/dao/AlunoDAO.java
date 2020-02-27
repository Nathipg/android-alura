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
        Aluno alunoSelecionado = buscaAlunoPorId(aluno);

        if(alunoSelecionado != null) {
            int posicao = alunos.indexOf(alunoSelecionado);
            alunos.set(posicao, aluno);
        }
    }

    public void remover(Aluno aluno) {
        Aluno alunoRemover = buscaAlunoPorId(aluno);
        if(alunoRemover != null) {
            alunos.remove(alunoRemover);
        }
    }

    public Aluno buscaAlunoPorId(Aluno aluno) {
        for(Aluno a : alunos) {
            if(a.getId() == aluno.getId()) {
                return a;
            }
        }

        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

}
