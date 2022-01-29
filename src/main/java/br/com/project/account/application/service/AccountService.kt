package br.com.project.account.application.service

import br.com.project.account.adapter.repository.AccountRepository
import br.com.project.account.application.exception.AccountNotFoundException
import br.com.project.account.model.Account
import br.com.project.account.ports.AccountServicePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService : AccountServicePort {

    @Autowired
    private lateinit var repository: AccountRepository

    override fun find(number: Long): Account {
        val result = repository.findByNumero(number)
        return result.orElseThrow { AccountNotFoundException(number) }
    }

    override fun saveUpdate(account: Account): Account = repository.save(account)
}