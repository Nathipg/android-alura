package pissuti.nathalia.financas.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListaTransacoesAdapter(transacoes: List<String>) : BaseAdapter() {

    private val transacoes = transacoes;

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): String {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return transacoes.size
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}