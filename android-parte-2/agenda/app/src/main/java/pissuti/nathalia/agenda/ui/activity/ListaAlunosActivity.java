package pissuti.nathalia.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pissuti.nathalia.agenda.R;
import pissuti.nathalia.agenda.model.Aluno;
import pissuti.nathalia.agenda.ui.ListaAlunosView;

public class ListaAlunosActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Lista de alunos";
    public static final String CHAVE_ALUNO = "aluno";
    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        configuraLista();
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
            listaAlunosView.confirmaRemocao(item);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(v -> abreFormAlunoCriacaoActivity());
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
        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerClickPorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    private void configuraListenerClickPorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((parent, view, position, id) -> {
            Aluno alunoEscolhido = (Aluno) parent.getItemAtPosition(position);
            abreFormAlunoEdicao(alunoEscolhido);
        });
    }

}
