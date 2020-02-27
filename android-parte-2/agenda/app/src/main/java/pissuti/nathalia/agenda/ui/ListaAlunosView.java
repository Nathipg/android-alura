package pissuti.nathalia.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import pissuti.nathalia.agenda.dao.AlunoDAO;
import pissuti.nathalia.agenda.model.Aluno;
import pissuti.nathalia.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private final AlunoDAO dao = new AlunoDAO();
    private final ListaAlunosAdapter adapter;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(this.context);
    }

    public void confirmaRemocao(@NonNull final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que deseja remover o aluno?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno aluno = adapter.getItem(menuInfo.position);
                    remove(aluno);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }

    private void remove(Aluno aluno) {
        dao.remover(aluno);
        adapter.remove(aluno);
    }

}
