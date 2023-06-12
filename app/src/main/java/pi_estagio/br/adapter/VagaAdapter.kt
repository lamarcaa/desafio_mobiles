package pi_estagio.br.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pi_estagio.br.R
import pi_estagio.br.databinding.ActivityCardResumoBinding
import pi_estagio.br.model.Vaga

class VagaAdapter(
    private val onItemClickListener: (Vaga) -> Unit
): RecyclerView.Adapter<VagaAdapter.VagaViewHolder>(){

    private val novaVaga: MutableList<Vaga> = mutableListOf()
    fun atualizarVagas(NovaVaga: List<Vaga>){
        novaVaga.clear()
        novaVaga.addAll(NovaVaga)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val binding = ActivityCardResumoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VagaViewHolder(binding);
    }


    override fun getItemCount(): Int {
        return novaVaga.size
    }

    /* cria as visualizacoes */
    override fun onBindViewHolder(holder: VagaViewHolder, position: Int) {
            holder.bind(novaVaga[position])
//
    }

    inner class VagaViewHolder(private val binding: ActivityCardResumoBinding):
        RecyclerView.ViewHolder(binding.root) {

       fun bind(vaga: Vaga){

           binding.titulo.text = itemView.context.getString(R.string.anunciante,vaga.anunciante_vaga)
           binding.resumo.text = itemView.context.getString(R.string.resumo,vaga.resumo_vaga)
           binding.areaConhecimento.text = itemView.context.getString(R.string.area,vaga.area_conhecimento)
           binding.remuneracao.text = itemView.context.getString(R.string.remuneracao,vaga.remuneracao_vaga)
           binding.localidade.text = itemView.context.getString(R.string.localidade,vaga.localidade_vaga)

       }

    }

}