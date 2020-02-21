package pissuti.nathalia.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import pissuti.nathalia.agenda.R;
import pissuti.nathalia.agenda.dao.AlunoDAO;
import pissuti.nathalia.agenda.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    public static final String CHAVE_ALUNO = "aluno";
    private final AlunoDAO dao = new AlunoDAO();
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        configuraLista();
        dao.salvar(new Aluno("Aluno 1", "99999999", "email@gmail.com"));
        dao.salvar(new Aluno("Aluno 2", "99999999", "email@gmail.com"));
        dao.salvar(new Aluno("Aluno 3", "99999999", "email@gmail.com"));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.activity_lista_alunos_menu_remover) {
            AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Aluno aluno = adapter.getItem(menuInfo.position);
            remove(aluno);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.clear();
        adapter.addAll(dao.todos());
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormAlunoCriacaoActivity();
            }
        });
    }

    private void abreFormAlunoCriacaoActivity() {
        startActivity(new Intent(this, FormAlunoActivity.class));
    }

    private void abreFormAlunoEdicao(Aluno alunoEscolhido) {
        Intent vaiParaFormAlunoActivity = new Intent(ListaAlunosActivity.this, FormAlunoActivity.class);
        vaiParaFormAlunoActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
        startActivity(vaiParaFormAlunoActivity);
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        configuraAdapter(listaDeAlunos);
        configuraListenerClickPorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    private void remove(Aluno aluno) {
        dao.remover(aluno);
        adapter.remove(aluno);
    }

    private void configuraListenerClickPorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) parent.getItemAtPosition(position);
                abreFormAlunoEdicao(alunoEscolhido);
            }
        });
    }

    private void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1);
        listaDeAlunos.setAdapter(adapter);
    }
}
