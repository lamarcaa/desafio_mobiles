package pi_estagio.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import pi_estagio.br.databinding.ActivityTelaInicialBinding



class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(VagasFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.inicioBar -> replaceFragment(VagasFragment())
                R.id.vagaBar -> replaceFragment(CadastroVagaActivity())
                R.id.perfilBar -> replaceFragment(PerfilFragment())

                else->{

                }
            }
            true

        }

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

    }


}