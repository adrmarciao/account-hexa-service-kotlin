package br.com.project.account.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable

class Account: Persistable<Long> {
    @Id
    var idConta: Long? = null

    var numero: Long? = null

    var saldo: Long? = null

    @Transient
    var isNewEntity: Boolean = false

    override fun isNew(): Boolean = isNewEntity

    override fun getId(): Long? = idConta


}