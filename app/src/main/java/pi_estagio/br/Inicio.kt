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


class Inicio : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)

        val recyclerView_vagas = view.findViewById<RecyclerView>(R.id.recyclerView_vagas)
        recyclerView_vagas.layoutManager = LinearLayoutManager(requireContext())
        recyclerView_vagas.setHasFixedSize(true)

        val listaVagas: MutableList<Vaga> = mutableListOf()
        val adapterVagas = AdapterVaga(requireContext(), listaVagas)
        recyclerView_vagas.adapter = adapterVagas


        val vaga1 = Vaga(
            titulo = "Biologia Marinha",
            areaConhecimento = "Ciencia",
            resumo = "biologia marinha com foco em xpto",
            localidade = "Rio de Janeiro",
            remuneracao = "R$ 1800,00"
        )
        listaVagas.add(vaga1)
        listaVagas.add(vaga1)
        listaVagas.add(vaga1)
        listaVagas.add(vaga1)
        listaVagas.add(vaga1)


        return view;
    }

}