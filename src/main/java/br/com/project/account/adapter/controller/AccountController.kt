package br.com.project.account.adapter.controller

import br.com.project.account.adapter.dto.AccountDTO
import br.com.project.account.application.exception.AccountNotFoundException
import br.com.project.account.ports.AccountServicePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conta", produces = ["application/json"])
class AccountController {

    @Autowired
    private lateinit var accountService: AccountServicePort

    @GetMapping("/{id}")
    @ResponseBody
    fun get(@PathVariable("id") id: Long): ResponseEntity<AccountDTO> {
        return ResponseEntity(AccountDTO(accountService.find(id)), HttpStatus.OK)
    }

    @PostMapping("/", consumes = ["application/json"])
    @ResponseBody
    fun post(@RequestBody contaDTO: AccountDTO): AccountDTO = AccountDTO(accountService.saveUpdate(AccountDTO.valueOf(contaDTO)))

}