package br.com.project.account.adapter.repository

import br.com.project.account.model.Account
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface AccountRepository : R2dbcRepository<Account, Long> {
    fun findByNumero(numero: Long): Flux<Account>
}