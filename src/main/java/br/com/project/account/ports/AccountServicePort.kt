package br.com.project.account.ports

import br.com.project.account.model.Account

interface AccountServicePort {
    fun find(number: Long): Account
    fun saveUpdate(account: Account): Account
}