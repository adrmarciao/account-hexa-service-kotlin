package br.com.project.account.adapter.controller

import br.com.project.account.adapter.dto.AccountDTO
import br.com.project.account.application.exception.AccountNotFoundException
import br.com.project.account.ports.AccountServicePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/conta", produces = ["application/json"])
class AccountController {

    @Autowired
    private lateinit var accountService: AccountServicePort

    @GetMapping("/{id}")
    @ResponseBody
    fun get(@PathVariable("id") id: Long): Flux<AccountDTO> {
        return accountService.find(id).map { AccountDTO(it) }
    }

    @PostMapping("/", consumes = ["application/json"])
    @ResponseBody
    fun post(@RequestBody contaDTO: AccountDTO): Mono<AccountDTO> = accountService
            .saveUpdate(AccountDTO.valueOf(contaDTO)).map { AccountDTO(it) }

}