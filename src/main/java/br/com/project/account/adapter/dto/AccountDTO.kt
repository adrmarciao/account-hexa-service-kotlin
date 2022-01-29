package br.com.project.account.adapter.dto

import br.com.project.account.model.Account
import com.fasterxml.jackson.annotation.JsonProperty

data class AccountDTO(
        @JsonProperty("id") val id: Long? = null,
        @JsonProperty("numero", required = true) val numero: Long? = null,
) {

    constructor(account: Account) : this(account.idConta, account.numero)

    companion object {
        fun valueOf(value: AccountDTO): Account = Account().apply {
            idConta = value.id
            numero = value.numero
        }
    }
}