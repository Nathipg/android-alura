package pissuti.nathalia.agenda;

import android.app.Application;

import pissuti.nathalia.agenda.dao.AlunoDAO;
import pissuti.nathalia.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        for (int i = 0; i < 5; i++) {
            dao.salvar(new Aluno("Aluno " + i, "19994836773", "email@gmail.com"));
        }
    }
}
