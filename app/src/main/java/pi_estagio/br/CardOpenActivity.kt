package pi_estagio.br

import android.content.Intent
import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.textview.MaterialTextView;


class CardOpenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_aberto)

        /* recebidos do cadastroVagasActivity */
        val nomeEmpresaRecebido = intent.getStringExtra("nome_empresa")
        val telefoneRecebido = intent.getStringExtra("telefone")
        val emailRecebido = intent.getStringExtra("email")
        val tituloRecebido = intent.getStringExtra("titulo")
        val resumoRecebido = intent.getStringExtra("resumo")
        val remuneracaoRecebido = intent.getStringExtra("remuneracao")
        val areaConhecimentoRecebido = intent.getStringExtra("areaConhecimento")
        val localidadeRecebido = intent.getStringExtra("localidade")

        /* colocar os valores nos elementos do layout */
        val tituloOpen = findViewById<TextView>(R.id.tituloOpen)
        tituloOpen.text = tituloRecebido

        val area_Conhecimento = findViewById<TextView>(R.id.area_Conhecimento)
        area_Conhecimento.text = areaConhecimentoRecebido

        val resumo = findViewById<TextView>(R.id.resumo)
        resumo.text = resumoRecebido

        val localidade = findViewById<TextView>(R.id.localidade)
        localidade.text = localidadeRecebido

        val valor = findViewById<TextView>(R.id.valor)
        valor.text = remuneracaoRecebido

        val telefone = findViewById<TextView>(R.id.telefone)
        telefone.text = telefoneRecebido

        telefone.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            } else {
                val intentLigacao = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefoneRecebido"))
                startActivity(intentLigacao)
            }
        }

        val nome_empresa = findViewById<TextView>(R.id.nome_empresa)
        nome_empresa.text = nomeEmpresaRecebido

    }
}