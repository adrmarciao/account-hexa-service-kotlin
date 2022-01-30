package br.com.project.account.adapter.repository.config

import io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.env.get


@Configuration
class DatabaseConfig {

    @Autowired
    private lateinit var env: Environment

    @Bean
    fun connectionFactory(): ConnectionFactory? {
        val host = env["POSTGRES_DATABASE"] ?: "localhost"
        val user = env["POSTGRES_USER"] ?: "postgres"
        val pwd = env["POSTGRES_PASSWORD"] ?: "123456"

        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, "postgresql")
                        .option(HOST, host)
                        .option(PORT, 5432)
                        .option(USER, user)
                        .option(PASSWORD, pwd)
                        .option(DATABASE, "db")
                        .option(MAX_SIZE, 40)
                        .build());

    }

}