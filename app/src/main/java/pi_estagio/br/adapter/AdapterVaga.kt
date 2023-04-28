package pi_estagio.br.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pi_estagio.br.R
import pi_estagio.br.model.Vaga

class AdapterVaga(private val context: Context, private val Inicio: MutableList<Vaga>): RecyclerView.Adapter<AdapterVaga.VagaViewHolder>(){

    inner class VagaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo = itemView.findViewById<TextView>(R.id.titulo)
        val resumo = itemView.findViewById<TextView>(R.id.resumo)
        val areaConhecimento = itemView.findViewById<TextView>(R.id.area_conhecimento)
        val localidade = itemView.findViewById<TextView>(R.id.localidade)
        val remuneracao = itemView.findViewById<TextView>(R.id.remuneracao)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        val holder = VagaViewHolder(itemLista)
        return holder
    }

    override fun getItemCount(): Int = Inicio.size

    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {

        holder.titulo.text = Inicio[position].titulo
        holder.resumo.text = Inicio[position].resumo
        holder.localidade.text = Inicio[position].localidade
        holder.remuneracao.text = Inicio[position].remuneracao
        holder.areaConhecimento.text = Inicio[position].areaConhecimento
    }
}