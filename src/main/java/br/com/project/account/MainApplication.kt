package br.com.project.account

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.web.reactive.config.EnableWebFlux


@EnableWebFlux
@SpringBootApplication
@EnableR2dbcRepositories
class MainApplication {

    @Bean
    fun swagger(): OpenAPI {
        return OpenAPI()
                .info(Info()
                        .title("Account Hexa Kotlin")
                        .version("0.2.0")
                        .termsOfService("http://swagger.io/terms/")
                        .license(License().name("Apache 2.0").url("http://springdoc.org")))
    }
}

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
