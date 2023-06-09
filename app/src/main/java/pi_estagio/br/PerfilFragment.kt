package pi_estagio.br
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PerfilFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_perfil, container, false);


        val nomeConta = requireActivity().intent.getStringExtra("Nome")
        val cad_nome_login = requireActivity().findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cad_nome_login)


        var botaoEditar=view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_editarPerfil);
        val botaoSair=view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_sairApp);

        botaoEditar.setOnClickListener{
            val intentLogar = Intent(requireContext(), EditarPerfilFragment::class.java)
            startActivity(intentLogar)

        }

        botaoSair.setOnClickListener{
            val intentLogar = Intent(requireContext(), MainActivity::class.java)
            startActivity(intentLogar)

        }

        return view;

    }


}