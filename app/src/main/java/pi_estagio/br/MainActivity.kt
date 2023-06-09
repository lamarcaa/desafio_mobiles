package pi_estagio.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import pi_estagio.br.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogar.setOnClickListener {

            if (binding.loginEmail.text.toString().isEmpty()) {
                Toast.makeText(this, "Insira um Email!", Toast.LENGTH_SHORT).show()

            } else if (binding.loginSenha.text.toString().isEmpty()) {
                Toast.makeText(this, "Insira uma senha", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(
                    binding.loginEmail.text.toString(),
                    binding.loginSenha.text.toString()
                ).addOnCompleteListener { result ->
                    if (result.isSuccessful) {
                        val intentVagas = Intent(this, TelaInicialActivity::class.java)
                        startActivity(intentVagas)
                        finish()
                    } else {
                        Toast.makeText(this, "Não foi possível autenticar", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }

        }

        binding.btnCadastrar.setOnClickListener(){
            val intentCadastrar = Intent(this, CadastroContaActivity::class.java)
            startActivity(intentCadastrar)
        }

    }

}
