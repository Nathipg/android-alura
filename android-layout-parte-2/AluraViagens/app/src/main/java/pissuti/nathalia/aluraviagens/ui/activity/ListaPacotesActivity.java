package pissuti.nathalia.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import pissuti.nathalia.aluraviagens.R;
import pissuti.nathalia.aluraviagens.dao.PacoteDAO;
import pissuti.nathalia.aluraviagens.model.Pacote;
import pissuti.nathalia.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APP_BAR);

        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((adapterView, view, position, id) -> {
            Pacote pacote = pacotes.get(position);
            acessaResumoPacote(pacote);
        });
    }

    private void acessaResumoPacote(Pacote pacote) {
        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        intent.putExtra(PacoteActivityConstantes.CHAVE_PACOTE, pacote);
        startActivity(intent);
    }
}
