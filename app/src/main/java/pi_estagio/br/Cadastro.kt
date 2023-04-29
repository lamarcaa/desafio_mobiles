package pi_estagio.br

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle??) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val cad_nome_login =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cad_nome_login)
        val cad_email_login =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cad_email_login)
        val cad_senha_login =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cad_senha_login)
        val cad_conf_senha =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cad_conf_senha)

        val bntCadastrar = findViewById<MaterialButton>(R.id.btn_logar)
        val bntVoltar = findViewById<MaterialButton>(R.id.btn_voltar)

        bntCadastrar.setOnClickListener {
            val nome = cad_nome_login.editText?.text.toString()
            val email = cad_email_login.editText?.text.toString()
            val senha = cad_senha_login.editText?.text.toString()
            val confSenha = cad_conf_senha.editText?.text.toString()

            /* verificação dos campos */
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confSenha.isEmpty()) {

                Toast.makeText(this, "Campos nao preenchidos", Toast.LENGTH_SHORT).show()

            } else {

                if (senha == confSenha) {

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("email", email)
                    intent.putExtra("senha", senha)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Senhas incorretas", Toast.LENGTH_SHORT).show()
                }
            }
        }

        bntVoltar.setOnClickListener {
            val intentVoltarLogin = Intent(this, MainActivity::class.java)
            startActivity(intentVoltarLogin)
        }
    }
}