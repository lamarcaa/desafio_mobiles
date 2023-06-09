package pi_estagio.br.model

import android.provider.ContactsContract.Data
import com.google.firebase.Timestamp

data class Vaga (
    val anunciante_vaga: String,
    val area_conhecimento: String,
    val data_inicio: Timestamp,
    val data_termino: Timestamp,
    val email_vaga: String,
    val localidade_vaga: String,
    val remuneracao_vaga: String,
    val resumo_vaga: String,
    val telefone_vaga: String,
    val titulo_vaga: String
)