package pi_estagio.br
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import pi_estagio.br.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

   private lateinit var binding: FragmentPerfilBinding
   private val auth= FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.btnEditarPerfil.setOnClickListener{
            val intentEditarPerfil = Intent(requireContext(), EditarPerfilFragment::class.java)
            startActivity(intentEditarPerfil)
        }

        binding.btnSairApp.setOnClickListener{
            auth.signOut()
            val intentLogar = Intent(requireContext(), MainActivity::class.java)
            startActivity(intentLogar)
        }

        binding.btnDeletarConta.setOnClickListener{
        }

        return view

    }


}