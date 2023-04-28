package pi_estagio.br

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class CadastroVaga : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cadastro_vaga, container, false)


        val cadastro_nome_empresa = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_nome_empresa)
        val cadastro_titulo = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_titulo)
        val cadastro_resumo = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_resumo)
        val cadastro_area_Conhecimento = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_area_Conhecimento)
        val cadastro_localidade = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_localidade)
        val cadastro_valor = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_valor)
        val cadastro_telefone = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_telefone)
        val cadastro_email = view.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cadastro_email)
        val btn_Cadastar_Vaga = view.findViewById<MaterialButton>(R.id.btn_Cadastar_Vaga)

        btn_Cadastar_Vaga.setOnClickListener{
            val nome_empresa = cadastro_nome_empresa.editText?.text.toString()
            val titulo = cadastro_titulo.editText?.text.toString()
            val resumo = cadastro_resumo.editText?.text.toString()
            val area_Conhecimento = cadastro_area_Conhecimento.editText?.text.toString()
            val localidade = cadastro_localidade.editText?.text.toString()
            val valor = cadastro_valor.editText?.text.toString()
            val telefone = cadastro_telefone.editText?.text.toString()
            val email = cadastro_email.editText?.text.toString()


            if (titulo.isEmpty() || resumo.isEmpty() ||
                area_Conhecimento.isEmpty() || localidade.isEmpty() || valor.isEmpty()){

                Toast.makeText(requireContext(), "Campos não preenchidos", Toast.LENGTH_SHORT).show()

            }else{

                val intentCadastroVaga = Intent(requireContext(), Vagas::class.java)
                intentCadastroVaga.putExtra("titulo", nome_empresa)
                intentCadastroVaga.putExtra("titulo", titulo)
                intentCadastroVaga.putExtra("resumo", resumo)
                intentCadastroVaga.putExtra("remuneracao", valor)
                intentCadastroVaga.putExtra("areaConhecimento", area_Conhecimento)
                intentCadastroVaga.putExtra("localidade", localidade)
                intentCadastroVaga.putExtra("email", email)
                intentCadastroVaga.putExtra("telefone", telefone)
                startActivity(intentCadastroVaga)

            }

        }

        return view
    }
}
