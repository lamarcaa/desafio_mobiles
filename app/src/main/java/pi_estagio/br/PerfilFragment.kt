package pi_estagio.br


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import pi_estagio.br.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    private val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()
    val user = Firebase.auth.currentUser!!
    private var nome: String? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val view = binding.root

        db.collection("Usuario").document(auth.uid.toString())
            .addSnapshotListener { document, error ->
                if (document != null) {

                    nome = document.getString("nomeUsuario")

                    val nomePerfil = getString(R.string.nomePerfil, nome)

                    binding.infoNome.text = nomePerfil
                    binding.infoEmail.text = "${auth.currentUser?.email}"
                }
            }


        binding.btnEditarPerfil.setOnClickListener {


            val editarDados = Intent(requireContext(), EditarPerfilActivity::class.java)
            startActivity(editarDados)

        }


        binding.btnSairApp.setOnClickListener {
            auth.signOut()
            val intentVoltarLogin = Intent(requireContext(), MainActivity::class.java)
            startActivity(intentVoltarLogin)
        }

        binding.btnDeletarConta.setOnClickListener {
            user.delete().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "A CONTA FOI DELETADA")

                    Toast.makeText(
                        requireContext(),
                        "SUA CONTA FOI DELETADA!",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intentVoltarLogin = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intentVoltarLogin)

                }
            }
        }

        return view

    }

//    private fun replaceFragment(fragment: Fragment) {
//
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frameLayout, fragment)
//        fragmentTransaction.commit()
//
//    }

}