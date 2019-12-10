package pissuti.nathalia.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import pissuti.nathalia.agenda.R;
import pissuti.nathalia.agenda.dao.AlunoDAO;
import pissuti.nathalia.agenda.model.Aluno;

public class FormAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();

        Intent dados = getIntent();
        Aluno aluno = (Aluno) dados.getSerializableExtra("aluno");
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_form_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criaAluno();
                salvar(alunoCriado);
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_form_aluno_nome);
        campoTelefone = findViewById(R.id.activity_form_aluno_telefone);
        campoEmail = findViewById(R.id.activity_form_aluno_email);
    }

    private void salvar(Aluno aluno) {
        dao.salvar(aluno);
        finish();
    }

    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }

}
