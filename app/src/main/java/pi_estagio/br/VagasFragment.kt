package pi_estagio.br
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pi_estagio.br.Adapter.AdapterVaga
import pi_estagio.br.model.Vaga


class VagasFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycle_view_vagas, container, false)

        val recyclerViewVagas = view.findViewById<RecyclerView>(R.id.recyclerViewVagas)
        recyclerViewVagas.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewVagas.setHasFixedSize(true)

        /* configurar o adapter para mostrar */
        val listaVagas: MutableList<Vaga> = mutableListOf()
        val adapterVagas = AdapterVaga(requireContext(), listaVagas)
        recyclerViewVagas.adapter = adapterVagas

        /* recebidos do cadastroVagasActivity */
        val tituloRecebido = requireActivity().intent.getStringExtra("titulo")
        val areaConhecimentoRecebido = requireActivity().intent.getStringExtra("areaConhecimento")
        val resumoRecebido = requireActivity().intent.getStringExtra("resumo")
        val localidadeRecebido = requireActivity().intent.getStringExtra("localidade")
        val remuneracaoRecebido = requireActivity().intent.getStringExtra("remuneracao")
        val emailRecebido = requireActivity().intent.getStringExtra("email")
        val telefoneRecebido = requireActivity().intent.getStringExtra("telefone")


        /* atualiza a exibição da RecyclerView */
        adapterVagas.notifyDataSetChanged()


        return view
    }

}


