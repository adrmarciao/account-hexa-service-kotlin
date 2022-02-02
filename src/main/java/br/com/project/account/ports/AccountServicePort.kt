package br.com.project.account.ports

import br.com.project.account.application.model.Account
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AccountServicePort {
    fun find(number: Long): Flux<Account>
    fun saveUpdate(account: Account): Mono<Account>
}