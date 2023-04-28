package pi_estagio.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import pi_estagio.br.databinding.TelaInicialBinding


class TelaInicial : AppCompatActivity() {

    private lateinit var binding: TelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Vagas())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.inicioBar -> replaceFragment(Inicio())
                R.id.vagaBar -> replaceFragment(Vagas())
                R.id.perfilBar -> replaceFragment(perfil1())

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