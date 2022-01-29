package br.com.project.account.model

import javax.persistence.*


@Entity
@Table(name = "tb_conta")
@SequenceGenerator(name = "seq", sequenceName = "conta_values_seq", allocationSize = 1)
class Account {
    @Id
    @Column(name = "id_conta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    var id: Long? = null

    @Column(name = "numero")
    var numero: Long? = null

    @Column(name = "saldo")
    var saldo: Long? = null

}