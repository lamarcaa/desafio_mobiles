package pi_estagio.br

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import pi_estagio.br.databinding.ActivityCadastroContaBinding

class CadastroContaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroContaBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroContaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bntCadastrar.setOnClickListener {

            /* verificação dos campos */
            if (binding.cadSenha.text.toString().isEmpty()) {

                Toast.makeText(this, "Campos nao preenchidos", Toast.LENGTH_SHORT).show()

            } else if (binding.cadSenha.text.toString() != binding.confSenha.text.toString()){
                Toast.makeText(this, "Senhas diferentes, confirme se as senhas estao iguais", Toast.LENGTH_SHORT).show()
            } else{
                    auth.createUserWithEmailAndPassword(
                        binding.cadEmail.text.toString(),
                        binding.cadSenha.text.toString()
                    ).addOnCompleteListener{ result ->
                        if (result.isSuccessful){
                            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

//                    val intent = Intent(this, MainActivity::class.java)
//                    intent.putExtra("email", email)
//                    intent.putExtra("senha", senha)
//                    startActivity(intent)

            }
        }

        binding.btnVoltar.setOnClickListener {
            val intentVoltarLogin = Intent(this, MainActivity::class.java)
            startActivity(intentVoltarLogin)
        }
    }
}