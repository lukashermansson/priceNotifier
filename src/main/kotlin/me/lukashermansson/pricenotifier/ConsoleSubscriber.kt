package me.lukashermansson.pricenotifier

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class ConsoleSubscriber(val subscriber: Scheduler) {

    @PostConstruct
    fun e() {
        subscriber.subscribers += {
            println(it)
        }
    }
}