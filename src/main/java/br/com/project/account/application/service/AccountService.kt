package br.com.project.account.application.service

import br.com.project.account.model.Account
import br.com.project.account.ports.AccountPersistencePort
import br.com.project.account.ports.AccountServicePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AccountService : AccountServicePort {

    @Autowired
    private lateinit var repository: AccountPersistencePort

    override fun find(number: Long): Flux<Account> = repository.findByNumero(number)

    override fun saveUpdate(account: Account): Mono<Account> = repository.save(account)
}