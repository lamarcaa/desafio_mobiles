package pi_estagio.br


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import pi_estagio.br.databinding.ActivityRecuperarSenhaBinding


class RecuperarSenhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarSenhaBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecuperarSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviarEmail.setOnClickListener {
            auth.sendPasswordResetEmail(binding.recuperarSenha.text.toString())
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Verifique a sua caixa de email", Toast.LENGTH_LONG)
                            .show()
                    val voltarTelaInicial = Intent(this, MainActivity::class.java)
                    startActivity(voltarTelaInicial)
                    finish()
                    } else {
                        if (task.exception is FirebaseAuthEmailException) {
                            Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show()
                        }
                        Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_LONG).show()
                    }
                }
        }

        binding.btnVoltarTi.setOnClickListener() {
            val voltarTelaInicial = Intent(this, MainActivity::class.java)
            startActivity(voltarTelaInicial)
            finish()
        }


    }
}