package br.com.project.account.adapter.message

import br.com.project.account.ports.MessageProducerPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
@Primary
class KafkaProducer: MessageProducerPort{

    @Autowired
    private lateinit var template: KafkaTemplate<String, String>

    override fun sendMessage(topic: String, data: String) {
        template.send(topic, data)
    }

}