package pi_estagio.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle??) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

                // get reference to the string array that we just created
                val languages = resources.getStringArray(R.array.opcoes_perfil)
                // create an array adapter and pass the required parameter
                // in our case pass the context, drop down layout , and array.
                val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, languages)
                // get reference to the autocomplete text view
                val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
                // set adapter to the autocomplete tv to the arrayAdapter
                autocompleteTV.setAdapter(arrayAdapter)
            }
        }