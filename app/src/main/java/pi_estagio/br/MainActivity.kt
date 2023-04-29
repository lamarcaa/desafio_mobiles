package pi_estagio.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailLogar = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.login_email)
        val senhaLogar = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.login_senha)
        val bntLogar = findViewById<MaterialButton>(R.id.btn_logar)
        val btnCadastrar = findViewById<MaterialButton>(R.id.btn_cadastrar)

        bntLogar.setOnClickListener {

            /* precisa pegar a string que esta sendo digitada pra ver se esta vazio */
            val emailLogar1 = emailLogar.editText?.text.toString()
            val senhaLogar1 = senhaLogar.editText?.text.toString()


            /* se o login_email e login_senha estiver vazios n deixa passar */
            if (emailLogar1.isEmpty() || senhaLogar1.isEmpty()) {

                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

            } else {

                /* variaveis recebidas do cadastro */
                val emailCadastrado = intent.getStringExtra("email")
                val senhaCadastrada = intent.getStringExtra("senha")

                if (emailLogar1 == emailCadastrado && senhaLogar1 == senhaCadastrada) {

                    bntLogar.setOnClickListener {
                        val intentVagas = Intent(this, TelaInicial::class.java)
                        startActivity(intentVagas)
                    }

                } else {

                    Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
            }
        }

        /* intent para ir para o cadastro */
        btnCadastrar.setOnClickListener{
            val intentCadastrar = Intent(this, Cadastro::class.java)
            startActivity(intentCadastrar)
        }

    }
}