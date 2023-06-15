package pi_estagio.br

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pi_estagio.br.Adapter.VagaAdapter
import pi_estagio.br.databinding.ActivityCardResumoBinding
import pi_estagio.br.databinding.ActivityTelaInicialBinding
import pi_estagio.br.databinding.FragmentListaVagasBinding
import pi_estagio.br.model.Vaga


class VagasFragment : Fragment() {

    private lateinit var binding: FragmentListaVagasBinding
    private val db = Firebase.firestore
//    private lateinit var adapterMinhasVaga: VagaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaVagasBinding.inflate(inflater, container, false)
        val view = binding.root
//
//        val deleteCard = VagaAdapter{ vaga ->
//            db.collection("Vagas")
//                .document(vaga.id)
//                .delete()
//        }

        val vagaAdapter = VagaAdapter { vaga, deletar ->
            if (deletar) {
                db.collection("Vagas")
                    .document(vaga.id)
                    .delete().addOnCompleteListener {
                        Toast.makeText(requireContext(), "Foi deletado", Toast.LENGTH_LONG).show()
                    }.addOnFailureListener {
                        Toast.makeText(requireContext(), "falha na requisicao", Toast.LENGTH_LONG)
                            .show()
                    }
            }
        }

//        binding.recyclerViewVagas.adapter = deleteCard
        binding.recyclerViewVagas.adapter = vagaAdapter
        binding.recyclerViewVagas.layoutManager = LinearLayoutManager(requireContext())



        db.collection("Vagas").addSnapshotListener { value, error ->
            if (value != null) {
                val firebaseResult = value
                val listaVaga: List<Vaga> = firebaseResult.map { document ->
                    Vaga(
                        document.id,
                        document.getString("anunciante_vaga").toString() ?: "",
                        document.getString("area_conhecimento").toString() ?: "",
                        document.getString("data_inicio").toString() ?: "",
                        document.getString("data_termino").toString() ?: "",
                        document.getString("email_vaga").toString() ?: "",
                        document.getString("localidade_vaga").toString() ?: "",
                        document.getString("remuneracao_vaga").toString() ?: "",
                        document.getString("resumo_vaga").toString() ?: "",
                        document.getString("telefone_vaga").toString() ?: "",
                        document.getString("titulo_vaga").toString() ?: "",
                        )
                }
                vagaAdapter.atualizarVagas(listaVaga)
            } else {
                Toast.makeText(requireContext(), "falha na requisicao", Toast.LENGTH_LONG).show()
            }

        }



        return view
    }

}


