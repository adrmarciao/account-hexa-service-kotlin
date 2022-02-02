package br.com.project.account.ports

import br.com.project.account.application.model.Account
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AccountPersistencePort {
    fun findByNumero(numero: Long): Flux<Account>
    fun save(account: Account): Mono<Account>
}