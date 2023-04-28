package pi_estagio.br
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Perfil1 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_perfil1, container, false);


        var botaoEditar=view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_editarPerfil);
        val botaoSair=view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_sairApp);

        botaoEditar.setOnClickListener{
            val intentLogar = Intent(this.context, Vagas::class.java)
            startActivity(intentLogar)

        }

        botaoSair=
        // Inflate the layout for this fragment
        return view;

    }


}