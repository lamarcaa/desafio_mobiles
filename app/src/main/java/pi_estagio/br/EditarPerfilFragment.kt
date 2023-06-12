package pi_estagio.br

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pi_estagio.br.databinding.FragmentEdicaoPerfilBinding

class EditarPerfilFragment : Fragment() {

    private lateinit var binding: FragmentEdicaoPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEdicaoPerfilBinding.inflate(inflater, container, false)
        val view = binding.root




        return view
    }

}