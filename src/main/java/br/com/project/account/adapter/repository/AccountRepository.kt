package br.com.project.account.adapter.repository

import br.com.project.account.model.Account
import br.com.project.account.ports.AccountRepositoryPort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : AccountRepositoryPort, JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
    fun findByNumero(numero: Long): Optional<Account>
}