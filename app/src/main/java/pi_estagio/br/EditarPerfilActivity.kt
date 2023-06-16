package pi_estagio.br

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import pi_estagio.br.databinding.ActivityMainBinding
import pi_estagio.br.databinding.FragmentEdicaoPerfilBinding

class EditarPerfilActivity: AppCompatActivity() {

    private lateinit var binding: FragmentEdicaoPerfilBinding
    private val db = FirebaseFirestore.getInstance()

    private val auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentEdicaoPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener{

            if (binding.editarEmail.text.toString().isEmpty() || binding.editarNome.text.toString().isEmpty()){
                Toast.makeText(this, "Campos não preenchidos", Toast.LENGTH_SHORT).show()
            }else{

                val usuarioAtual = FirebaseAuth.getInstance().currentUser

                val user = Firebase.auth.currentUser

                if (usuarioAtual != null){
                    val idUsuario = usuarioAtual.uid

                    user!!.updateEmail(binding.editarEmail.text.toString()).addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Log.d(TAG,"Email atualizado")
                        }
                    }

                    db.collection("Usuario").document(idUsuario)
                        .update("nomeUsuario",binding.editarNome.text.toString(),
                            "email_user", binding.editarEmail.text.toString())
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                val intentVoltarLogin = Intent(this, MainActivity::class.java)
                                startActivity(intentVoltarLogin)
                                finish()
                            }else{
                                Toast.makeText(this, "Houve um erro, não foi possível salvar os dados!", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }

        binding.btnVoltarPerfil.setOnClickListener{
            val editarDados = Intent(this, PerfilFragment::class.java)
            startActivity(editarDados)
        }

    }
}