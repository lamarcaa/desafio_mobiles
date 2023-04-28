package pi_estagio.br
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailLogar =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.login_email)
        val senhaLogar =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.login_senha)
        val bntLogar = findViewById<MaterialButton>(R.id.btn_logar)
        val btnCadastrar = findViewById<MaterialButton>(R.id.btn_cadastrar)

        bntLogar.setOnClickListener {

            /* se n colocar o toString n pega a string digitada */
            val email = emailLogar.editText?.text.toString()
            val senha = senhaLogar.editText?.text.toString()


            /* se o login_email e login_senha estiver vazios n deixa passar */
            if (email.isEmpty() || senha.isEmpty()) {

                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

            } else {

                if (email == "teste@g" && senha == "123") {

                    /* intent para entrar na home caso os dados estiverem corretos */
                    bntLogar.setOnClickListener {
                        val intentLogar = Intent(this, TelaInicial::class.java)
                        startActivity(intentLogar)
                    }

                } else {

                    Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show()
                }


            }
        }

        /* intent para ir para o cadastro */
        btnCadastrar.setOnClickListener {
            val intentCadastro = Intent(this, Cadastro::class.java)
            startActivity(intentCadastro)
        }


    }

}
