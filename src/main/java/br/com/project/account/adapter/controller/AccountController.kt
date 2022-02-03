package br.com.project.account.adapter.controller

import br.com.project.account.adapter.dto.AccountDTO
import br.com.project.account.adapter.dto.MessageDTO
import br.com.project.account.ports.AccountServicePort
import br.com.project.account.ports.MessageProducerPort
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@Tag(name = "Conta", description = "Endpoint criado, para prover dados da conta do usuário")
@RequestMapping("/conta", produces = ["application/json"])
class AccountController {

    @Autowired
    private lateinit var accountService: AccountServicePort

    @Autowired
    private lateinit var messageProducerPort: MessageProducerPort

    @Operation(
            description = "Endpoint que retorna dados da conta.",
            parameters = [Parameter(name = "accountNumber", description = "Numero da conta")])
    @ApiResponse(description = "Dados da conta", responseCode = "200")
    @GetMapping("/{accountNumber}")
    @ResponseBody
    fun get(@PathVariable("accountNumber") accountNumber: Long): Flux<AccountDTO> {
        return accountService.find(accountNumber).map { AccountDTO(it) }
    }

    @Operation(description = "Persiste dados da conta bancária.")
    @ApiResponse(description = "Retorna dados da conta com id persistido", responseCode = "200")
    @PostMapping("/", consumes = ["application/json"])
    @ResponseBody
    fun post(@RequestBody contaDTO: AccountDTO): Mono<AccountDTO> = accountService
            .saveUpdate(AccountDTO.valueOf(contaDTO)).map { AccountDTO(it) }

    @Operation(description = "Kafka Message")
    @ApiResponse(description = "Caso a mensagem tenha sido enviada", responseCode = "200")
    @PostMapping("/kafka/{topic}/send", consumes = ["application/json"])
    @ResponseBody
    fun send(@PathVariable("topic") topic: String, @RequestBody message: MessageDTO) {
        messageProducerPort.sendMessage(topic, message.message)
    }

}