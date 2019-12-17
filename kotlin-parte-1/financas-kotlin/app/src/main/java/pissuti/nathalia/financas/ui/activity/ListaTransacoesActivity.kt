package pissuti.nathalia.financas.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import pissuti.nathalia.financas.R
import pissuti.nathalia.financas.ui.adapter.ListaTransacoesAdapter
import kotlin.collections.listOf

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<String> = listOf("Comida - R$ 20", "Economia - R$ 100")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, transacoes)

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes))
    }
}