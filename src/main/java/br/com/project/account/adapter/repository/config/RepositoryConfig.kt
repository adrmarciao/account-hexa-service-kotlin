package br.com.project.account.adapter.repository.config

import br.com.project.account.adapter.repository.AccountRepository
import br.com.project.account.ports.AccountRepositoryPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepositoryConfig {

    @Bean
    fun getAccountRepository(accountRepository: AccountRepository): AccountRepositoryPort {
        return accountRepository
    }
}