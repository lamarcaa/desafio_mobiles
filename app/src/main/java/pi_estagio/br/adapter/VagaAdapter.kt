package pi_estagio.br.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pi_estagio.br.CardOpenActivity
import pi_estagio.br.R
import pi_estagio.br.databinding.ActivityCardResumoBinding
import pi_estagio.br.model.Vaga

class VagaAdapter(
    private val onItemClickListener: (Vaga, delete: Boolean) -> Unit,
//    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<VagaAdapter.VagaViewHolder>() {

    private val novaVaga: MutableList<Vaga> = mutableListOf()
    fun atualizarVagas(NovaVaga: List<Vaga>) {
        novaVaga.clear()
        novaVaga.addAll(NovaVaga)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VagaViewHolder {
        val binding =
            ActivityCardResumoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class VagaViewHolder(private val binding: ActivityCardResumoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(vaga: Vaga) {

            binding.titulo.text =
                itemView.context.getString(R.string.anuncianteVaga, vaga.anunciante_vaga)
            binding.resumo.text = itemView.context.getString(R.string.resumo, vaga.resumo_vaga)
            binding.areaConhecimento.text =
                itemView.context.getString(R.string.area, vaga.area_conhecimento)
            binding.remuneracao.text =
                itemView.context.getString(R.string.remuneracao, vaga.remuneracao_vaga)
            binding.localidade.text =
                itemView.context.getString(R.string.localidade, vaga.localidade_vaga)

            binding.verInfos.setOnClickListener {
                val intent = Intent(itemView.context, CardOpenActivity::class.java)

                intent.putExtra("idVaga", vaga.id)
                intent.putExtra("tituloCardOpen", vaga.titulo_vaga)
                intent.putExtra("anuncianteCardOpen", vaga.anunciante_vaga)
                intent.putExtra("areaCardOpen", vaga.area_conhecimento)
                intent.putExtra("valorRemuneracaoCardOpen", vaga.remuneracao_vaga)
                intent.putExtra("localidadeCardOpen", vaga.localidade_vaga)

                intent.putExtra("dataInicioCardOpen", vaga.data_inicio)
                intent.putExtra("dataTerminoCardOpen", vaga.data_termino)

                intent.putExtra("descricaoVagaCardOpen", vaga.resumo_vaga)

                intent.putExtra("emailContatoCardOpen", vaga.email_vaga)
                intent.putExtra("telefoneContatoCardOpen", vaga.telefone_vaga)


                itemView.context.startActivity(intent)
            }

            binding.btnDeletarCard.setOnClickListener{
                onItemClickListener(vaga, true)
            }

        }

    }

}