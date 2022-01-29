package br.com.project.account.adapter.repository

import br.com.project.account.model.Account
import br.com.project.account.ports.AccountPersistencePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Component
@Primary
class AccountPersistence: AccountPersistencePort {

    @Autowired
    private lateinit var accountRepository: AccountRepository


    override fun findByNumero(numero: Long): Flux<Account> {
        return accountRepository.findByNumero(numero)
    }

    override fun save(account: Account): Mono<Account> {
        account.isNewEntity = true
        return accountRepository.save(account)
    }
}