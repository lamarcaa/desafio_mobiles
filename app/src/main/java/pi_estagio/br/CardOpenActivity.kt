package pi_estagio.br

import android.content.Intent
import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pi_estagio.br.Adapter.VagaAdapter
import pi_estagio.br.databinding.ActivityCardAbertoBinding
import pi_estagio.br.databinding.FragmentListaVagasBinding
import pi_estagio.br.model.Vaga

class CardOpenActivity : AppCompatActivity() {

    private val vagas: MutableList<Vaga> = mutableListOf()
    val db = Firebase.firestore

    private lateinit var binding: ActivityCardAbertoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardAbertoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newTitulo = intent.getStringExtra("tituloCardOpen")
        val newAnunciante = intent.getStringExtra("anuncianteCardOpen")
        val newAreaConhecimento = intent.getStringExtra("areaCardOpen")
        val newRemuneracao = intent.getStringExtra("valorRemuneracaoCardOpen")
        val newLocalidade = intent.getStringExtra("localidadeCardOpen")

        val newDataInicio = intent.getStringExtra("dataInicioCardOpen")
        val newDataFinal = intent.getStringExtra("dataTerminoCardOpen")
        val newDescricao = intent.getStringExtra("descricaoVagaCardOpen")

        val newEmail = intent.getStringExtra("emailContatoCardOpen")
        val newTelefone = intent.getStringExtra("telefoneContatoCardOpen")

        binding.tituloOpen.text = getString(R.string.dadoTituloVaga, newTitulo)
        binding.resumo.text = getString(R.string.dadoResumoVaga, newAnunciante)
        binding.nomeEmpresa.text = getString(R.string.dadoNomeEmpresa, newAreaConhecimento)
        binding.areaConhecimento.text = getString(R.string.dadoAreaConhecimentoVaga, newRemuneracao)
        binding.valor.text = getString(R.string.dadoValorVaga, newLocalidade)

        binding.localidade.text = getString(R.string.dadoLocalidadeVaga, newLocalidade)
        binding.dataInicioVaga.text = getString(R.string.dadoDataInicioVaga, newDataFinal)
        binding.dataTerminoVaga.text = getString(R.string.dadoDataTerminoVaga, newDescricao)

        binding.telefone.text = getString(R.string.dadoTelefoneVaga, newTelefone)
        binding.email.text = getString(R.string.dadoEmailVaga, newEmail)


        val telefone = binding.telefone
        telefone.text = getString(R.string.dadoTelefoneVaga, newTelefone)

        telefone.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            } else {
                val intentLigacao = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefone"))
                startActivity(intentLigacao)
            }
        }

        binding.btnVoltar.setOnClickListener{
            finish()
        }


    }
}