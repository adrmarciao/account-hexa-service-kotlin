package br.com.project.account.ports

interface MessageProducerPort {
    fun sendMessage(topic: String, data: String)
}