package me.lukashermansson.pricenotifier

import mu.KotlinLogging
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class ConsoleSubscriber(val subscriber: Scheduler) {
    private val logger = KotlinLogging.logger {}
    @PostConstruct
    fun setUpSubscription() {
        subscriber.subscribers += {
            logger.info { "Nytt pris inkommet: $it" }
        }
    }
}