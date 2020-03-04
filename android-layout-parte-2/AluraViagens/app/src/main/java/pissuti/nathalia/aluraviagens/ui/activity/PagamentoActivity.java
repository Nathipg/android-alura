package pissuti.nathalia.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pissuti.nathalia.aluraviagens.R;
import pissuti.nathalia.aluraviagens.model.Pacote;
import pissuti.nathalia.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intentRecebida = getIntent();
        if (intentRecebida.hasExtra(PacoteActivityConstantes.CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intentRecebida.getSerializableExtra(PacoteActivityConstantes.CHAVE_PACOTE);

            mostraPreco(pacote);

            configuraBotaoFinalizarCompra(pacote);
        }
    }

    private void configuraBotaoFinalizarCompra(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(v -> {
            acessaResumoCompra(pacote);
        });
    }

    private void acessaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(this, ResumoCompraActivity.class);
        intent.putExtra(PacoteActivityConstantes.CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBr(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
