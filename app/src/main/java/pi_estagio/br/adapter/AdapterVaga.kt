package pi_estagio.br.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pi_estagio.br.CardOpenActivity
import pi_estagio.br.R
import pi_estagio.br.model.Vaga

class AdapterVaga(private val context: Context, private val vagas: MutableList<Vaga>): RecyclerView.Adapter<AdapterVaga.VagaViewHolder>(){

    inner class VagaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo = itemView.findViewById<TextView>(R.id.titulo)
        val resumo = itemView.findViewById<TextView>(R.id.resumo)
        val areaConhecimento = itemView.findViewById<TextView>(R.id.area_conhecimento)
        val localidade = itemView.findViewById<TextView>(R.id.localidade)
        val remuneracao = itemView.findViewById<TextView>(R.id.remuneracao)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(context, CardOpenActivity::class.java)
                    intent.putExtra("titulo", vagas[position].titulo)
                    intent.putExtra("resumo", vagas[position].resumo)
                    intent.putExtra("areaConhecimento", vagas[position].areaConhecimento)
                    intent.putExtra("localidade", vagas[position].localidade)
                    intent.putExtra("remuneracao", vagas[position].remuneracao)
                    intent.putExtra("email", vagas[position].email)
                    intent.putExtra("telefone", vagas[position].telefone)
                    context.startActivity(intent)
                }
            }
        }
    }

    /* cria as visualizacoes */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        val holder = VagaViewHolder(itemLista)
        return holder
    }

    /* tamanho da lista dos atributos */
    override fun getItemCount(): Int = vagas.size

    /* faz as visualizacoes aparecerem */
    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {

        holder.titulo.text = vagas[position].titulo
        holder.resumo.text = vagas[position].resumo
        holder.localidade.text = vagas[position].localidade
        holder.remuneracao.text = vagas[position].remuneracao
        holder.areaConhecimento.text = vagas[position].areaConhecimento
    }
}