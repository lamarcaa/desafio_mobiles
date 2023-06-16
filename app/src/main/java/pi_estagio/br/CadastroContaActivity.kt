package pi_estagio.br

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pi_estagio.br.databinding.ActivityCadastroContaBinding

class CadastroContaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroContaBinding
    private val auth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroContaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bntCadastrar.setOnClickListener {

            if (binding.tipoInteressado.isEnabled == true)
            {
                Toast.makeText(this, "interessado", Toast.LENGTH_SHORT).show()
            }

            if (binding.cadNome.text.toString().isEmpty() || binding.cadEmail.text.toString().isEmpty() ||
                    binding.cadSenha.text.toString().isEmpty() || binding.confSenha.toString().isEmpty()){

                Toast.makeText(this, "Campos nao preenchidos", Toast.LENGTH_SHORT).show()

            } else if (binding.cadSenha.text.toString() != binding.confSenha.text.toString()) {
                Toast.makeText(
                    this,
                    "Senhas diferentes, confirme se as senhas estao iguais",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                auth.createUserWithEmailAndPassword(
                    binding.cadEmail.text.toString(),
                    binding.cadSenha.text.toString()
                ).addOnCompleteListener { result ->
                    if (result.isSuccessful) {

                        val currentUser = FirebaseAuth.getInstance().currentUser

                        if (binding.tipoAnunciante.isChecked) {
                            val userId = currentUser?.uid

                            if (userId != null) {
                                db.collection("Usuario").document(userId).set(
                                    hashMapOf(
                                        "email_user" to binding.cadEmail.text.toString(),
                                        "nomeUsuario" to binding.cadNome.text.toString(),
                                        "tipoConta" to binding.tipoAnunciante.text.toString(),
                                    )
                                )
                            }
                            Toast.makeText(
                                this,
                                "Cadastro de anunciante efetuado",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {

                            val userId = currentUser?.uid

                            if (userId != null) {
                                db.collection("Usuario").document(userId).set(
                                    hashMapOf(
                                        "email_user" to binding.cadEmail.text.toString(),
                                        "nomeUsuario" to binding.cadNome.text.toString(),
                                        "tipoConta" to binding.tipoInteressado.text.toString(),
                                    )
                                )
                            }
                            Toast.makeText(
                                this,
                                "Cadastro de Interessado efeutado",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }

        binding.btnVoltar.setOnClickListener {
            val intentVoltarLogin = Intent(this, MainActivity::class.java)
            startActivity(intentVoltarLogin)
        }
    }
}