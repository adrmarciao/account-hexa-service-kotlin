package br.com.project.account.application.config

import br.com.project.account.application.service.AccountService
import br.com.project.account.ports.AccountServicePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun getAccountService(accountService: AccountService): AccountServicePort {
        return accountService
    }

}