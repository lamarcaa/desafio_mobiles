package pi_estagio.br

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pi_estagio.br.Adapter.VagaAdapter
import pi_estagio.br.databinding.FragmentCadastroVagaBinding
import pi_estagio.br.model.Vaga

class CadastroVagaActivity : Fragment() {

    private lateinit var binding: FragmentCadastroVagaBinding
    private val auth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroVagaBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btnCadastarVaga.setOnClickListener {

            if (binding.anuncianteVaga.text.toString().isEmpty() || binding.tituloVaga.text.toString().isEmpty() ||
                    binding.resumoVaga.text.toString().isEmpty() || binding.areaConhecimentoVaga.text.toString().isEmpty() ||
                    binding.localidadeVaga.text.toString().isEmpty() || binding.remuneracaoVaga.text.toString().isEmpty() ||
                    binding.telefoneVaga.text.toString().isEmpty() || binding.emailVaga.text.toString().isEmpty() ||
                    binding.emailVaga.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Campos não preenchidos", Toast.LENGTH_SHORT)
                    .show()
            } else {

                db.collection("Vagas").add(
                    hashMapOf(
                        "anunciante_vaga" to binding.anuncianteVaga.text.toString(),
                        "area_conhecimento" to binding.areaConhecimentoVaga.text.toString(),
                        "data_termino" to binding.dataFinalVaga.text.toString(),
                        "email_vaga" to binding.emailVaga.text.toString(),
                        "localidade_vaga" to binding.emailVaga.text.toString(),
                        "remuneracao_vaga" to binding.remuneracaoVaga.text.toString(),
                        "resumo_vaga" to binding.resumoVaga.text.toString(),
                        "telefone_vaga" to binding.telefoneVaga.text.toString(),
                        "titulo_vaga" to binding.tituloVaga.text.toString()
                    )
                ).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(requireContext(), "Vaga cadastrada!!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "Não foi possível cadastrar a vaga", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }

        binding.btnVoltar.setOnClickListener() {
            val intentVoltarLogin = Intent(requireContext(), TelaInicialActivity::class.java)
            startActivity(intentVoltarLogin)
        }

        return view
    }
}
